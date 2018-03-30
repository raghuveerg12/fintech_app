/*
 * 
 */
package com.core.isonsoft.parsingJson.storeToDb;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.junit.Test;

import com.core.isonsoft.beans.StagBitTrexGetTickerBean;
import com.core.isonsoft.xmlParsing.HibernateUtil;

public class TestBitTrexGetTickerFeedToDB {

	@Test
	public void testConvertJsonDataToDb() throws IOException {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String url = InsertToStatsDownTable
				.getUrlFromCodeDataTab(session, "31");

		BitTrexGetTickerFeedToDB.convertJsonDataToDb(
				ConvertUrlToJsonFile.readJsonFromUrl(url, "31"),
				System.currentTimeMillis(), session);

		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		Query query = session1
				.createQuery("from com.core.isonsoft.beans.StagBitTrexGetTickerBean");
		List<StagBitTrexGetTickerBean> results = query.getResultList();

		assertNotNull(results.size());
		session1.close();
	}

}
