/*
 * 
 */
package com.core.isonsoft.parsingJson.storeToDb;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.core.isonsoft.beans.CodeDataSourceBean;
import com.core.isonsoft.beans.StatsDownloadBean;
import com.core.isonsoft.main.MaillingService;
import com.core.isonsoft.xmlParsing.HibernateUtil;

/**
 * 
 * @author raghu
 *
 */
public class InsertToStatsDownTable {
	/** LOGGER */
	public final static Logger LOG = LoggerFactory
			.getLogger(InsertToStatsDownTable.class);

	/**
	 * 
	 * @param session
	 * @param exceptionString
	 * @param dataSourceID
	 * @param startTime
	 * @param status
	 */
	public static void insertingDataToTab(Session session,
			String exceptionString, String dataSourceID, long startTime,
			String status) {

		try {
			long endTime = System.currentTimeMillis();

			StatsDownloadBean stats = new StatsDownloadBean();

			stats.setDataSourceId(dataSourceID);
			stats.setDuration(startTime);
			stats.setStartDT(new Timestamp(startTime));
			stats.setEndDT(new Timestamp(endTime));
			stats.setErrorMessage(exceptionString);
			stats.setStatus(status);
			stats.setDuration(getStopTime(endTime));

			session.save(stats);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	/**
	 * 
	 * @param exceptionString
	 * @return
	 */
	public static String convertTheExceptionToString(Exception exceptionString) {

		StringWriter sw = null;

		try {
			sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			exceptionString.printStackTrace(pw);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sw.toString();

	}

	/**
	 * 
	 * @return
	 */
	public static long getTimeStart() {

		long startTime = System.currentTimeMillis();

		LOG.info("StartTime-->" + startTime);
		return startTime;
	}

	/**
	 * 
	 * @param startTime
	 * @return
	 */
	public static long getStopTime(long startTime) {
		long endTime = System.currentTimeMillis();
		LOG.info("endtime---" + endTime + "----startTime-" + startTime);
		long totaltime = ((endTime - startTime) / 1000);
		return totaltime;

	}

	/**
	 * 
	 * @param session
	 * @param codeDataSourceId
	 * @return
	 */
	public static String getUrlFromCodeDataTab(Session session,
			String codeDataSourceId) {
		String url = null;
		Query query = session
				.createQuery("from com.core.isonsoft.beans.CodeDataSourceBean where ID= :code");
		query.setParameter("code", Integer.parseInt(codeDataSourceId));
		@SuppressWarnings("unchecked")
		List<CodeDataSourceBean> result = query.getResultList();
		if (result.iterator().next().getUrl() != null) {
			url = result.iterator().next().getUrl();
		} else {
			url = "";
		}

		return url;
	}

	/**
	 * 
	 * @param statusFlag2
	 * @param session
	 * @param startTime
	 * @param message2
	 * @param codeDataSourceId2
	 * @param downloadStatus2
	 */
	public static void sendMailAndInsertInDownStats(Boolean statusFlag,
			Session session, long startTime, String message,
			String codeDataSourceId, String downloadStatus) {
		if (statusFlag) {
			downloadStatus = "failure";
			MaillingService.sendMail(codeDataSourceId, message);
		}

		if (!session.getTransaction().isActive()) {
			LOG.info(" session.getTransaction() is not active");
		    session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
		}
		InsertToStatsDownTable.insertingDataToTab(session, message,
				codeDataSourceId, startTime, downloadStatus);

		session.close();
	}
}
