/*
 * 
 */
package com.core.isonsoft.parsingJson.storeToDb;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.core.isonsoft.beans.StagBtceTradeBean;
import com.core.isonsoft.main.MaillingService;
import com.core.isonsoft.xmlParsing.HibernateUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.web.isonsoft.helper.BtcTradeHelper;

/**
 * 
 * @author raghu
 *
 */
public class BtceTradeFeedToDb extends TimerTask {

	/** LOGGER */
	public final static Logger LOG = LoggerFactory
			.getLogger(BtceTradeFeedToDb.class);

	/** The Constant statusFlag. */
	public static Boolean statusFlag = Boolean.FALSE;
	/** The Constant message. */
	private static String message = null;

	/** The Constant id. */
	public final static String codeDataSourceId = "21";

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
		
		/*Session session=HibernateUtil.getSessionFactory().openSession();
		  session.beginTransaction();
		  convertJsonDataToDb("C:\\Users\\raghu\\Desktop\\faliure\\21.json",System.currentTimeMillis(),session);*/
		 

		 new Timer().scheduleAtFixedRate(new BtceTradeFeedToDb(), 0, 60 * 60 * 1000);
	}

	/**
	 * 
	 * @param rootNode
	 * @param mapper
	 * @param path
	 * @param systemTime
	 * @param Id
	 * @param session
	 */
	public static void convertJsonDataToDb(String path, long systemTime,
			Session session) {
		try {
			
			List<StagBtceTradeBean> list=new BtcTradeHelper().convertJsonDataToList(path);

			for (StagBtceTradeBean object : list) {
				object.setUpdated(new Timestamp(  object.getTimestamp()*1000L));
				session.save(object);
			}
						session.getTransaction().commit();

		} catch (NullPointerException ex) {
			message = "The server is busy unable to create JSON File, Please check the URL for ID "
					+ codeDataSourceId;
		} catch (Exception e) {
			statusFlag = Boolean.TRUE;
			LOG.error("cannot convert the URL to json file {}{}", e,
					codeDataSourceId);

			statusFlag = Boolean.TRUE;
			message = InsertToStatsDownTable.convertTheExceptionToString(e);
		} finally {

			if (statusFlag == true) {
				downloadStatus = "failure";
				MaillingService.sendMail(codeDataSourceId, message);
			}
			LOG.info("before the insertionsss");
			if (!session.beginTransaction().isActive()) {
				session.beginTransaction();
			}
			InsertToStatsDownTable.insertingDataToTab(session, message,
					codeDataSourceId, systemTime, downloadStatus);

			session.close();
		}

	}

	/**
	 * 
	 */
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
