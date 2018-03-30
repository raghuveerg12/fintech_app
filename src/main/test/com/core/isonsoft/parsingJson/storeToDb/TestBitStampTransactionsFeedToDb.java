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

import com.core.isonsoft.beans.StagBitStampTransactionsBean;
import com.core.isonsoft.xmlParsing.HibernateUtil;

public class TestBitStampTransactionsFeedToDb {

	@Test
	public void testConvertJsonDataToDb() throws IOException {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String url = InsertToStatsDownTable
				.getUrlFromCodeDataTab(session, "25");

		BitStampTransactionsFeedToDb.convertJsonDataToDb(
				ConvertUrlToJsonFile.readJsonFromUrl(url, "25"),
				System.currentTimeMillis(), session);

		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		Query query = session1
				.createQuery("from com.core.isonsoft.beans.StagBitStampTransactionsBean");
		List<StagBitStampTransactionsBean> results = query.getResultList();

		assertNotNull(results.size());
		session1.close();

	}

}
