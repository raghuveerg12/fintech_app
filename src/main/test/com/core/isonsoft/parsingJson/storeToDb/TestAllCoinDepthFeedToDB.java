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

public class TestAllCoinDepthFeedToDB {

	@SuppressWarnings("unchecked")
	@Test
	public void testConvertJsonDataToDb() {

		// To test whether the file is correctly storing into DB
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		AllCoinDepthFeedToDB.convertJsonDataToDb(
				"src\\main\\filesPath\\in\\20170238\\35.json",
				System.currentTimeMillis(), session);

		// To test whether data is present in DB
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		Query query = session1
				.createQuery("from com.core.isonsoft.beans.StagAllCoinDepthMainBean");
		List<StagAllCoinTradesBean> results = query.getResultList();
		assertNotNull(results.size());
		session1.close();
	}

}
