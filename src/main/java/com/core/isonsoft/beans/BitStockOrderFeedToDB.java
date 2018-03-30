package com.core.isonsoft.beans;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Session;

import com.core.isonsoft.xmlParsing.HibernateUtil;

public class BitStockOrderFeedToDB {
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
	public static void main(String[] args) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.createObjectNode();
		Session session = HibernateUtil.getSessionFactory().openSession();

		convertJsonDataToDb(rootNode, mapper,
				"C:\\Users\\raghu\\Desktop\\faliure\\48.json",
				System.currentTimeMillis(), "48", session);

	}

	public static void convertJsonDataToDb(JsonNode rootNode,
			ObjectMapper mapper, String path, long systemTime, String Id,
			Session session) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
