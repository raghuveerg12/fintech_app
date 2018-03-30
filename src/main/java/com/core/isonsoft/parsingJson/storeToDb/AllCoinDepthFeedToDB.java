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

import com.core.isonsoft.xmlParsing.HibernateUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.web.isonsoft.helper.AllCoinDepthHelper;

/**
 * 
 * @author raghu
 *
 */
public class AllCoinDepthFeedToDB extends TimerTask {

	/** LOGGER */
	public final static Logger LOG = LoggerFactory
			.getLogger(AllCoinDepthFeedToDB.class);

	/** The Constant statusFlag. */
	public static Boolean statusFlag = Boolean.FALSE;
	/** The Constant message. */
	private static String message = null;

	/** The Constant id. */
	public static String codeDataSourceId = "35";

	/** The downloadStatus id. */
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
		/*
		 * ObjectMapper mapper = new ObjectMapper(); JsonNode rootNode =
		 * mapper.createObjectNode(); Session session=
		 * HibernateUtil.getSessionFactory().openSession();
		 * session.beginTransaction(); String
		 * url=InsertToStatsDownTable.getUrlFromCodeDataTab(session, "35");
		 * convertJsonDataToDb
		 * (rootNode,mapper,ConvertUrlToJsonFile.readJsonFromUrl(url,
		 * "35"),System.currentTimeMillis(),"35",session);
		 */
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new AllCoinDepthFeedToDB(), 0, 60 * 60 * 1000);

	}

	/**
	 * Parsing Vector Data using Jackson
	 * 
	 * @param path
	 * @param startTime
	 * @param session
	 */
	public static void convertJsonDataToDb(final String path,
			final long startTime, final Session session) {
		try {
			
			List<Object> list=new AllCoinDepthHelper().convertJsonDataToList(path);
			for (Object object : list) {
				session.save(object);
			}
			session.getTransaction().commit();

		} catch (NullPointerException ex) {
			statusFlag = Boolean.TRUE;
			message = "The server is busy unable to create JSON File, Please check the URL for ID "
					+ codeDataSourceId;
		} catch (IOException e) {

			statusFlag = Boolean.TRUE;
			message = e.getMessage();
		} finally {

			InsertToStatsDownTable.sendMailAndInsertInDownStats(statusFlag,
					session, startTime, message, codeDataSourceId,
					downloadStatus);

		}

	}

	/**
	 * 
	 */

	@Override
	public void run() {
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		final String url = InsertToStatsDownTable.getUrlFromCodeDataTab(
				session, codeDataSourceId);
		try {
			convertJsonDataToDb(
					ConvertUrlToJsonFile.readJsonFromUrl(url, codeDataSourceId),
					System.currentTimeMillis(), session);
		} catch (IOException e) {

			LOG.error("cannot convert the URL to json file {}{}",
					codeDataSourceId, e.getMessage());
		} finally {
			InsertToStatsDownTable.sendMailAndInsertInDownStats(statusFlag,
					session, System.currentTimeMillis(), message,
					codeDataSourceId, downloadStatus);

		}

	}

}
