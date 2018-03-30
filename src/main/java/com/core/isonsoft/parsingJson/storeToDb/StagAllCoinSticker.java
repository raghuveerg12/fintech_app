/*
 * 
 */
package com.core.isonsoft.parsingJson.storeToDb;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Timer;
import java.util.TimerTask;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.core.isonsoft.beans.StagAllCoinsTickerBean;
import com.core.isonsoft.beans.StagAllCoinsTickerMainBean;
import com.core.isonsoft.main.MaillingService;
import com.core.isonsoft.xmlParsing.HibernateUtil;

/**
 * 
 * @author raghu
 *
 */
public class StagAllCoinSticker extends TimerTask {
	/** LOGGER */
	public final static Logger LOG = LoggerFactory
			.getLogger(StagAllCoinSticker.class);

	/** The Constant statusFlag. */
	public static Boolean statusFlag = Boolean.FALSE;
	/** The Constant message. */
	private static String message = null;

	/** The Constant id. */
	public final static String codeDataSourceId = "36";
	/** The Constant downloadStatus. */
	public static String downloadStatus = "success";

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

			StagAllCoinsTickerMainBean stagAllCoinsTickerBeanMain = new ObjectMapper()
					.readValue(new File(path), StagAllCoinsTickerMainBean.class);
			StagAllCoinsTickerBean stagAllBeancoinsTicker=stagAllCoinsTickerBeanMain.getTicker();
			stagAllBeancoinsTicker.setUpdated(new Timestamp(stagAllCoinsTickerBeanMain.getDate()*1000L) );
			

			session.save(stagAllBeancoinsTicker);
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
		/*
		 * ObjectMapper mapper = new ObjectMapper(); JsonNode rootNode =
		 * mapper.createObjectNode(); Session
		 * session=HibernateUtil.getSessionFactory().openSession();
		 * convertJsonDataToDb
		 * (rootNode,mapper,"C:\\Users\\raghu\\Desktop\\faliure\\36.json"
		 * ,System.currentTimeMillis(),"36",session);
		 */
		
		/*Session session=HibernateUtil.getSessionFactory().openSession();
		  session.beginTransaction();
		  convertJsonDataToDb( "C:\\Users\\raghu\\Desktop\\faliure\\36.json",System.currentTimeMillis(),session);*/
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new StagAllCoinSticker(), 0, 60 * 60 * 1000);
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
