/*
 * 
 */
package com.core.isonsoft.parsingJson.storeToDb;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.core.isonsoft.beans.StagBitTrexGetCurrencieBean;
import com.core.isonsoft.beans.StagBitTrexGetCurrenciesBean;
import com.core.isonsoft.main.MaillingService;
import com.core.isonsoft.xmlParsing.HibernateUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.isonsoft.helper.BitTrexGetCurrenciesHelper;

/**
 * The class for convert the url feed to Store in to DB
 * 
 */
public class BitTrexGetCurrenciesFeedToDB extends TimerTask {

	/** LOGGER */
	public final static Logger LOG = LoggerFactory
			.getLogger(BitTrexGetCurrenciesFeedToDB.class);

	/** The Constant statusFlag. */
	public static Boolean statusFlag = Boolean.FALSE;
	/** The Constant message. */
	private static String message;

	/** The Constant dataSourceId. */
	public static String dataSourceId = "29";
	/** The Constant downloadStatus. */
	public static String downloadStatus = "success";

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws JsonParseException
	 *             the json parse exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */

	public static void main(final String[] args) throws JsonParseException,
			IOException {
		/* Session session=HibernateUtil.getSessionFactory().openSession();
		  session.beginTransaction();
		  convertJsonDataToDb("C:\\Users\\raghu\\Desktop\\faliure\\29.json",System.currentTimeMillis(),session);
		 */

		final Timer timer = new Timer();

		timer.scheduleAtFixedRate(new BitTrexGetCurrenciesFeedToDB(), 0,
				60 * 60 * 1000);
	}

	/**
	 * convert the Json file data to DB values
	 * 
	 */
	public static void convertJsonDataToDb(	final String path, final long systemTime,
			 final Session session) {
		try {

			
			List<StagBitTrexGetCurrencieBean> list=new BitTrexGetCurrenciesHelper().convertJsonDataToList(path);
			for (StagBitTrexGetCurrencieBean object : list) {
				session.save(object);
			}

			
			session.getTransaction().commit();

		} catch (NullPointerException ex) {
			message = "The server is busy unable to create JSON File, Please check the URL for ID "
					+ dataSourceId;
		} catch (Exception e) {
			LOG.error("eception occured {} ", e);
			statusFlag = Boolean.TRUE;
			message = InsertToStatsDownTable.convertTheExceptionToString(e);
		} finally {

			if (statusFlag) {
				downloadStatus = "failure";
				MaillingService.sendMail(dataSourceId, message);
			}
			LOG.info("before the insertionsss");
			if (!session.getTransaction().isActive()) {
				session.beginTransaction();
			}
			InsertToStatsDownTable.insertingDataToTab(session, message,
					dataSourceId, systemTime, downloadStatus);

			session.close();
		}
	}

	@Override
	public void run() {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		// get the url from the codedatasource based on the ID
		final String url = InsertToStatsDownTable.getUrlFromCodeDataTab(
				session, dataSourceId);
		try {
			/**
			 * gets the url and convert the feed data to Json file in system
			 * Specified File by ConvertUrlToJsonFile.readJsonFromUrl(url, id)
			 * 
			 * below method is used to take json file from specified path and
			 * insert into DB.
			 * 
			 */
			convertJsonDataToDb(
					ConvertUrlToJsonFile.readJsonFromUrl(url, dataSourceId),
					System.currentTimeMillis(), session);
		} catch (IOException e) {

			LOG.error("cannot convert the URL to json file {},{}",
					dataSourceId, e);
		} finally {
			session.close();
		}

	}

}
