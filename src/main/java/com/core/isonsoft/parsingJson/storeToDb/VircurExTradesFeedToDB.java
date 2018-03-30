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

import com.core.isonsoft.beans.VirCurexOrderBookMainBean;
import com.core.isonsoft.xmlParsing.HibernateUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author raghu
 *
 */
public class VircurExTradesFeedToDB extends TimerTask {
	/** LOGGER */
	public final static Logger LOG = LoggerFactory
			.getLogger(VircurExTradesFeedToDB.class);

	/** The Constant statusFlag. */
	public static Boolean statusFlag = Boolean.FALSE;
	/** The Constant message. */
	private static String message = null;

	/** The Constant id. */
	public final static String codeDataSourceId = "14";
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
		/*
		 * ObjectMapper mapper = new ObjectMapper(); JsonNode rootNode =
		 * mapper.createObjectNode(); Session session=
		 * HibernateUtil.getSessionFactory().openSession();
		 * 
		 * convertJsonDataToDb(rootNode,mapper,
		 * "C:\\Users\\raghu\\Desktop\\faliure\\14.json"
		 * ,System.currentTimeMillis(),"14",session);
		 */

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new VircurExTradesFeedToDB(), 0,
				60 * 60 * 1000);
	}

	/*
	 * Parsing Vector Data using Jackson
	 */
	public static void convertJsonDataToDb(String path, long systemTime,
			Session session) {
		try {

			final JsonNode jsonNode = new ObjectMapper().readValue(new File(
					path), JsonNode.class);

			for (JsonNode askNode : jsonNode.get("asks")) {
				VirCurexOrderBookMainBean stgAsks = new VirCurexOrderBookMainBean();
				stgAsks.setAsks("1");
				stgAsks.setBids("0");
				stgAsks.setPrice(askNode.get(0).toString());
				stgAsks.setVolume(askNode.get(1).toString());
				session.save(stgAsks);
			}

			for (JsonNode bidNode : jsonNode.get("bids")) {
				VirCurexOrderBookMainBean stgBids = new VirCurexOrderBookMainBean();
				stgBids.setAsks("0");
				stgBids.setBids("1");
				stgBids.setPrice(bidNode.get(0).toString());
				stgBids.setVolume(bidNode.get(1).toString());
				session.save(stgBids);
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
				// MaillingService.sendMail(codeDataSourceId, message);
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
