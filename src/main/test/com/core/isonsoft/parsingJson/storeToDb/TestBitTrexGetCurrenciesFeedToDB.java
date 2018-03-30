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

import com.core.isonsoft.beans.StagBitTrexGetCurrenciesBean;
import com.core.isonsoft.xmlParsing.HibernateUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestBitTrexGetCurrenciesFeedToDB {

	@SuppressWarnings("unchecked")
	@Test
	public void testConvertJsonDataToDb() throws IOException {

		final ObjectMapper mapper = new ObjectMapper();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String url = InsertToStatsDownTable
				.getUrlFromCodeDataTab(session, "29");

		BitTrexGetCurrenciesFeedToDB.convertJsonDataToDb(
				ConvertUrlToJsonFile.readJsonFromUrl(url, "29"),
				System.currentTimeMillis(), session);

		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		Query query = session1
				.createQuery("from com.core.isonsoft.beans.StagBitTrexGetCurrenciesBean");
		List<StagBitTrexGetCurrenciesBean> results = query.getResultList();

		assertNotNull(results.size());
		session1.close();
	}

}
