/*
 * 
 */
package com.core.isonsoft.parsingJson.storeToDb;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.core.isonsoft.beans.StagBitCoinMagazinBean;
import com.core.isonsoft.main.MaillingService;
import com.core.isonsoft.xmlParsing.Feed;
import com.core.isonsoft.xmlParsing.FeedMessage;
import com.core.isonsoft.xmlParsing.HibernateUtil;
import com.core.isonsoft.xmlParsing.RSSFeedParser;

public class BitCoinMagazinFeedToDB extends TimerTask {

	/** LOGGER */
	public final static Logger LOG = LoggerFactory
			.getLogger(BitCoinMagazinFeedToDB.class);

	/** The Constant statusFlag. */
	public static Boolean statusFlag = Boolean.FALSE;
	/** The Constant message. */
	private static String message = null;

	/** The Constant id. */
	public static String codeDataSourceId = "12";

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * ObjectMapper mapper = new ObjectMapper(); JsonNode rootNode =
		 * mapper.createObjectNode(); Session
		 * session=HibernateUtil.getSessionFactory().openSession();
		 * 
		 * convertJsonDataToDb(rootNode,mapper,"https://bitcoinmagazine.com/feed/"
		 * ,System.currentTimeMillis(),"12",session);
		 */

		new Timer().scheduleAtFixedRate(new BitCoinMagazinFeedToDB(), 0,
				60 * 60 * 1000);

	}

	/**
	 * 
	 * @param rootNode
	 * @param mapper
	 * @param path
	 * @param systemTime
	 * @param id
	 * @param session
	 */
	@SuppressWarnings("deprecation")
	public static void convertJsonDataToDb(String url, long systemTime,
			Session session) {

		try {

			LOG.info(url);
			RSSFeedParser parser = new RSSFeedParser(url);
			Feed feed = parser.readFeed();
			for (FeedMessage message : feed.getMessages()) {
				StagBitCoinMagazinBean stagBitCoinMagazinBean = new StagBitCoinMagazinBean();
				stagBitCoinMagazinBean.setCreator(message.creator);
				stagBitCoinMagazinBean.setCategory(message.category);
				stagBitCoinMagazinBean.setDescription(message.description);
				stagBitCoinMagazinBean.setUpdated(new Timestamp(new Date(
						message.pubDate).getTime()));
				stagBitCoinMagazinBean.setLink(message.link);
				stagBitCoinMagazinBean.setTitle(message.title);
				stagBitCoinMagazinBean.setContent(message.content);
				session.save(stagBitCoinMagazinBean);
			}

			session.getTransaction().commit();

		} catch (NullPointerException ex) {
			statusFlag = Boolean.TRUE;
			message = "The server is busy unable to create JSON File, Please check the URL for ID "
					+ codeDataSourceId;
		} catch (Exception e) {
			e.printStackTrace();
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

	/**
	 * 
	 */
	@Override
	public void run() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String url = InsertToStatsDownTable.getUrlFromCodeDataTab(session,
				codeDataSourceId);
		try {
			convertJsonDataToDb(url, System.currentTimeMillis(), session);
		} finally {
			session.close();
		}

	}

}
