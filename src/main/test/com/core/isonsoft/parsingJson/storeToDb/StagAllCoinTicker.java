/*
 * 
 */
package com.core.isonsoft.parsingJson.storeToDb;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.core.isonsoft.beans.StagAllCoinsTickerBean;
import com.core.isonsoft.xmlParsing.HibernateUtil;

public class StagAllCoinTicker {

	@Test
	public void testGetFeedDataToDb() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Object obj = session.load(StagAllCoinsTickerBean.class, "607.61");
		StagAllCoinsTickerBean sr = (StagAllCoinsTickerBean) obj;
		assertNotNull(sr.getHigh());

		session.close();
		sessionFactory.close();
	}

}
