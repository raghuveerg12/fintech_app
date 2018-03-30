/*
 * 
 */
package com.core.isonsoft.parsingJson.storeToDb;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.codehaus.jackson.JsonParseException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.core.isonsoft.beans.StagCcexGetMarketHistoryBean;
import com.core.isonsoft.main.MaillingService;
import com.core.isonsoft.xmlParsing.HibernateUtil;
import com.web.isonsoft.helper.CcexGetMarketHistoryHelper;

/**
 * 
 * @author raghu
 *
 */
public class CcexGetMarketHistoryFeedToDB extends TimerTask {

	/** LOGGER */
	public final static Logger LOG = LoggerFactory
			.getLogger(CcexGetMarketHistoryFeedToDB.class);

	/** The Constant statusFlag. */
	public static Boolean statusFlag = Boolean.FALSE;
	/** The Constant message. */
	private static String message = null;

	/** The Constant id. */
	public final static String codeDataSourceId = "46";

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
	public static void main(String[] args) throws JsonParseException,
			IOException {
		
		 /* Session session=HibernateUtil.getSessionFactory().openSession();
		  session.beginTransaction();
		  convertJsonDataToDb("C:\\Users\\raghu\\Desktop\\faliure\\46.json",System.currentTimeMillis(),session);
		 
			*/
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new CcexGetMarketHistoryFeedToDB(), 0,
				60 * 60 * 1000);
	}

	/*
	 * 
	 * 
	 */
	public static void convertJsonDataToDb(String path, long systemTime,
			Session session) {
		try {
			
			List<StagCcexGetMarketHistoryBean> list=new CcexGetMarketHistoryHelper().convertJsonDataToList(path);

			for (StagCcexGetMarketHistoryBean object : list) {
				session.save(object);
			}
			session.getTransaction().commit();

		} catch (NullPointerException ex) {
			statusFlag = Boolean.TRUE;
			message = "The server is busy unable to create JSON File, Please check the URL for ID "
					+ codeDataSourceId;
		} catch (Exception e) {
			LOG.error("cannot convert the URL to json file {}{}", e,
					codeDataSourceId);

			statusFlag = Boolean.TRUE;
			message = InsertToStatsDownTable.convertTheExceptionToString(e);
		} finally {

			if (statusFlag) {
				downloadStatus = "failure";
				MaillingService.sendMail(codeDataSourceId, message);
			}
			LOG.info("before the insertionsss");
			if (!session.getTransaction().isActive()) {
				session.beginTransaction();
			}
			InsertToStatsDownTable.insertingDataToTab(session, message,
					codeDataSourceId, systemTime, downloadStatus);

			session.close();
		}

	}

	@Override
	public void run() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		// get the url from the codedatasource based on the ID
		String url = InsertToStatsDownTable.getUrlFromCodeDataTab(session,
				codeDataSourceId);
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
					ConvertUrlToJsonFile.readJsonFromUrl(url, codeDataSourceId),
					System.currentTimeMillis(), session);
		} catch (IOException e) {

			LOG.error("cannot convert the URL to json file {},{}",
					codeDataSourceId, e);
		} finally {
			session.close();
		}
	}

}
