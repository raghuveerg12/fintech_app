/*
 * 
 */
package com.core.isonsoft.parsingJson.storeToDb;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.junit.Test;

import com.core.isonsoft.beans.StagAllCoinTradesBean;
import com.core.isonsoft.xmlParsing.HibernateUtil;

public class TestAllCoinTradesFeedToDB {

	@Test
	public void testConvertJsonDataToDb() {

		// To test whether the file is correctly storing into DB
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		AllCoinTradesFeedToDB.convertJsonDataToDb(
				"src\\main\\filesPath\\in\\20170238\\37.json",
				System.currentTimeMillis(), session);
		// To test whether data is present in DB
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		Query query = session1
				.createQuery("from com.core.isonsoft.beans.StagAllCoinTradesBean");
		List<StagAllCoinTradesBean> results = query.getResultList();
		assertNotNull(results.size());
	}

}
