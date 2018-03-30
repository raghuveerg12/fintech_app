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

import com.core.isonsoft.beans.StagVirCurExCurrencyBean;
import com.core.isonsoft.xmlParsing.HibernateUtil;

public class TestVirCurExCurrencyFeedToDb {

	@Test
	public void testConvertJsonDataToDb() throws IOException {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String url = InsertToStatsDownTable
				.getUrlFromCodeDataTab(session, "17");

		VirCurExCurrencyFeedToDb.convertJsonDataToDb(
				ConvertUrlToJsonFile.readJsonFromUrl(url, "17"),
				System.currentTimeMillis(), session);

		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		Query query = session1
				.createQuery("from com.core.isonsoft.beans.StagVirCurExCurrencyBean");
		List<StagVirCurExCurrencyBean> results = query.getResultList();

		assertNotNull(results.size());
		session1.close();
	}

}
