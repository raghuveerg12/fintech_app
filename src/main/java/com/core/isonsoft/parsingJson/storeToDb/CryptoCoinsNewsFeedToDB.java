/*
 * 
 */
package com.core.isonsoft.parsingJson.storeToDb;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.core.isonsoft.beans.StagCryptoCoinsNewsFeedBeans;
import com.core.isonsoft.main.MaillingService;
import com.core.isonsoft.xmlParsing.HibernateUtil;
import com.web.isonsoft.helper.RssFeedHelper;

/**
 * 
 * @author raghu
 *
 */
public class CryptoCoinsNewsFeedToDB extends TimerTask {
	/** LOGGER */
	public final static Logger LOG = LoggerFactory
			.getLogger(CryptoCoinsNewsFeedToDB.class);

	/** The Constant statusFlag. */
	public static Boolean statusFlag = Boolean.FALSE;
	/** The Constant message. */
	private static String message = null;

	/** The Constant id. */
	public final static String codeDataSourceId = "13";
	/** The Constant downloadStatus. */
	public static String downloadStatus = "success";

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		
		
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new CryptoCoinsNewsFeedToDB(), 0,
				60 * 60 * 1000);

	}

	/**
	 * 
	 * @param rootNode
	 * @param mapper
	 * @param path
	 * @param l
	 * @param id
	 * @param session
	 */
	public static void convertJsonDataToDb(String path, long systemTime,
			Session session) {
		try {

			List<Object> list=RssFeedHelper.convertRssFeedToList(new StagCryptoCoinsNewsFeedBeans() ,path);
			for (Object object : list) {
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
			 * gets the url and convert the feed data to DBalues
			 * 
			 * below method is used to take json file from specified path and
			 * insert into DB.
			 * 
			 */
			convertJsonDataToDb(url, System.currentTimeMillis(), session);
		} finally {
			session.close();
		}
	}

}
