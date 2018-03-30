/*
 * 
 */
package com.core.isonsoft.parsingJson.storeToDb;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.core.isonsoft.beans.StagBitStampEurUsdBean;
import com.core.isonsoft.main.MaillingService;
import com.core.isonsoft.xmlParsing.HibernateUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author raghu
 *
 */
public class BitStampEurUsdFeedToDb extends TimerTask {

	/** LOGGER */
	public final static Logger LOG = LoggerFactory
			.getLogger(BitStampEurUsdFeedToDb.class);

	/** The Constant statusFlag. */
	public static Boolean statusFlag = Boolean.FALSE;
	/** The Constant message. */
	private static String message = "";

	/** The Constant id. */
	public static String codeDataSourceID = "24";
	/** The downloadStatus */
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
		
		new Timer().scheduleAtFixedRate(new BitStampEurUsdFeedToDb(), 0,
				60 * 60 * 1000);

	}

	/**
	 * 
	 * @param path
	 * @param systemTime
	 * @param session
	 */
	public static void convertJsonDataToDb(final String path,
			final long systemTime, final Session session) {
		try {
			final StagBitStampEurUsdBean stagBtSpEuUsBean = new ObjectMapper()
					.readValue(new File(path), StagBitStampEurUsdBean.class);

			session.save(stagBtSpEuUsBean);
			session.getTransaction().commit();

		} catch (NullPointerException ex) {
			statusFlag = Boolean.TRUE;
			message = "The server is busy unable to create JSON File, Please check the URL for ID "
					+ codeDataSourceID;
		} catch (Exception e) {
			e.printStackTrace();
			statusFlag = Boolean.TRUE;
			message = InsertToStatsDownTable.convertTheExceptionToString(e);
		} finally {

			if (statusFlag) {
				downloadStatus = "failure";
				MaillingService.sendMail(codeDataSourceID, message);
			}
			LOG.info("before the insertionsss");
			// session.beginTransaction();
			if (!session.getTransaction().isActive()) {
				session.beginTransaction();
			}
			InsertToStatsDownTable.insertingDataToTab(session, message,
					codeDataSourceID, systemTime, downloadStatus);

			session.close();
		}

	}

	/**
	 * run method
	 * 
	 */
	@Override
	public void run() {

		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		final String url = InsertToStatsDownTable.getUrlFromCodeDataTab(
				session, codeDataSourceID);
		try {
			convertJsonDataToDb(
					ConvertUrlToJsonFile.readJsonFromUrl(url, codeDataSourceID),
					System.currentTimeMillis(), session);
		} catch (IOException e) {

			LOG.error("cannot convert the URL to json file {},{}",
					codeDataSourceID, e);
		} finally {
			session.close();
		}
	}

}
