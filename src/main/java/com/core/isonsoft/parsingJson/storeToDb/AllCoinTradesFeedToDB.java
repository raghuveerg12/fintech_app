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

import com.core.isonsoft.main.MaillingService;
import com.core.isonsoft.xmlParsing.HibernateUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.web.isonsoft.helper.AllCoinTradesHelper;

public class AllCoinTradesFeedToDB extends TimerTask {

	/** LOGGER */
	public final static Logger LOG = LoggerFactory
			.getLogger(AllCoinTradesFeedToDB.class);

	/** The Constant statusFlag. */
	public static Boolean statusFlag = Boolean.FALSE;
	/** The Constant message. */
	private static String message = null;

	/** The Constant id. */
	public static String codeDataSourceId = "37";

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
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		convertJsonDataToDb("C:\\Users\\raghu\\Desktop\\faliure\\37.json", System.currentTimeMillis(), session);
		/*
		new Timer().scheduleAtFixedRate(new AllCoinTradesFeedToDB(), 0,
				60 * 60 * 1000);
*/
	}

	/**
	 * IDS 37
	 * 
	 */
	public static void convertJsonDataToDb(String path, long systemTime,
			Session session) {
		try {

			List<Object> list=new AllCoinTradesHelper().convertJsonDataToList(path);
			
			for (Object object : list) {
				
				session.save(object);
			}
			session.getTransaction().commit();

		} catch (NullPointerException ex) {
			statusFlag = Boolean.TRUE;
			message = "The server is busy unable to create JSON File, Please check the URL for ID "
					+ codeDataSourceId;
		} catch (Exception e) {

			statusFlag = Boolean.TRUE;
			message = InsertToStatsDownTable.convertTheExceptionToString(e);
		} finally {
			String downloadStatus = "success";
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
		String url = InsertToStatsDownTable.getUrlFromCodeDataTab(session,
				codeDataSourceId);
		try {
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
