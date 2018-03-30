/*
 * 
 */
package com.core.isonsoft.parsingJson.storeToDb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.core.isonsoft.xmlParsing.HibernateUtil;
import com.web.isonsoft.helper.GetUrlBasedOnId;

public class ConvertUrlToJsonFile {
	/** LOGGER */
	public final static Logger LOG = LoggerFactory
			.getLogger(ConvertUrlToJsonFile.class);
	private static final String INDEX_NAME = "feedUrl.";

	/**
	 * Read json from url.
	 *
	 * @param url
	 *            the url
	 * @param codeDataSourceId
	 *            the id
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws JSONException
	 *             the JSON exception
	 */
	/*
	 * This method is used to read the content from the url which is fetched
	 * from DB based on the ID
	 * 
	 * 
	 * based on the URL , data is retrieved and converted into JSon format file
	 * and saved in the specified location as per the date
	 */
	public static String readJsonFromUrl(String url, String codeDataSourceId)
			throws IOException {
		LOG.info("URL is {} and ID are  {}", url, codeDataSourceId);
		BufferedWriter output = null;
		try {
			
			String  path =ClassLoader.getSystemResource("in").getPath();
			
			// Is used to hit the url
			URL urls = new URL(url);
			// open the hit the url
			URLConnection is = urls.openConnection();
			// based on the url , need to set the property
			/*
			 * if this is not sent then some times , when we fire URL we may get
			 * the content as blank and throws exception.
			 */
			is.setRequestProperty(
					"User-Agent",
					"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");

			/*
			 * Here, based on the date ,creating the folder in the Specified
			 * location, folder name is created on the system date
			 * 
			 * also validating whether already the same dir is been created on
			 * it, if folder exist with system date, then use the same, or else
			 * create new folder based on the format
			 */

			// create new date object
			Date now = new Date();
			// create simpledateFormat basaed on the YYYYMMDD
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMDD");
			// converting the date in to format and into String
			String stringFormatedSystemDate = dateFormat.format(now);

			File dir = null;
			String currentSystemTimeAndDate = new SimpleDateFormat(
					"yyyyMMddHHmmss", Locale.ENGLISH).format(now);

			// create file with system date
			dir = new File(path+"/" + stringFormatedSystemDate);
			LOG.info(path);
			// For Linux
			// dir = new File("/home/raghu/out/"+ stringFormatedSystemDate);
			// validating whether the Dir with system date exists, if not create
			// new file name
			if (!dir.exists()) {
				dir.mkdir();
			}

			// reader is used to read the data from the url on the char format
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					is.getInputStream(), Charset.forName("UTF-8")));
			// LOG.info(rd.toString());
			// passing the reader fetched data to below method to gather all the
			// data in URL in string format
			String jsonText = readAll(rd);
			// LOG.info(jsonText);
			if (StringUtils.isNotEmpty(jsonText)) {
				// creating an file name with ID from DB table and format of
				// current
				// systemdate and time
				String formatForFileSaving = codeDataSourceId + "_"
						+ currentSystemTimeAndDate;

				// create file based on the ID fetched from DB
				File jsonFileName = new File(dir.toString() + "/"
						+ codeDataSourceId + ".json");
				// validating the file exists or not, if exists create an file
				// name
				// using ID and Systemdate and time
				if (jsonFileName.exists()) {
					jsonFileName = new File(dir.toString() + "/"
							+ formatForFileSaving + ".json");
				}
				// using the json file as created in the folder for writing the
				// content from the url
				
				output = new BufferedWriter(new FileWriter(jsonFileName));

				output.write(jsonText);
				LOG.info("path where file is stored {}",
						jsonFileName.getAbsolutePath());

				return jsonFileName.getAbsolutePath();

			} else {
				LOG.info("The data in the file is empty{}", codeDataSourceId);

			}

			// return is introduced to implemention part of sending the data to
			// the FTP server
			/*
			 * By using this return we are able to achieve current folder name
			 * used as part of the file creation this return can be removed if
			 * once the some logic is implemented in the sending data to FTP
			 * part
			 */

		} finally {
			if (output != null) {
				output.close();
			}
		}

		// dummy return ... to avoid return error
		return null;

	}

	/**
	 * Read all.
	 *
	 * @param rd
	 *            the rd
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	/*
	 * This method is used the content got from the url and append to string
	 */
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */


	/**
	 * Read json from url.
	 *
	 * @param url
	 *            the url
	 * @param codeDataSourceId
	 *            the id
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws JSONException
	 *             the JSON exception
	 */
	/*
	 * This method is used to read the content from the url which is fetched
	 * from DB based on the ID
	 * 
	 * 
	 * based on the URL , data is retrieved and converted into JSon format file
	 * and saved in the specified location as per the date
	 */
	public static String readJsonFromUrlMVC( String codeDataSourceId,HttpServletRequest request)
			throws IOException {
		
		ServletContext sc = request.getSession().getServletContext();
		String path=sc.getRealPath("/");
		String url = new GetUrlBasedOnId().getUrlFromId(INDEX_NAME+codeDataSourceId);
		 LOG.info("url is {} and path of file location is {}",url,path);
		BufferedWriter output = null;
		try {
			// Is used to hit the url
			URL urls = new URL(url);
			// open the hit the url
			URLConnection is = urls.openConnection();
			// based on the url , need to set the property
			/*
			 * if this is not sent then some times , when we fire URL we may get
			 * the content as blank and throws exception.
			 */
			is.setRequestProperty(
					"User-Agent",
					"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");

			/*
			 * Here, based on the date ,creating the folder in the Specified
			 * location, folder name is created on the system date
			 * 
			 * also validating whether already the same dir is been created on
			 * it, if folder exist with system date, then use the same, or else
			 * create new folder based on the format
			 */

			// create new date object
			Date now = new Date();
			// create simpledateFormat basaed on the YYYYMMDD
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMDD");
			// converting the date in to format and into String
			String stringFormatedSystemDate = dateFormat.format(now);

			File dir = null;
			String currentSystemTimeAndDate = new SimpleDateFormat(
					"yyyyMMddHHmmss", Locale.ENGLISH).format(now);

			// create file with system date
			dir = new File(path+"MVCS"+ stringFormatedSystemDate);
			// For Linux
			// dir = new File("/home/raghu/out/"+ stringFormatedSystemDate);
			// validating whether the Dir with system date exists, if not create
			// new file name
			if (!dir.exists()) {
				dir.mkdir();
			}

			// reader is used to read the data from the url on the char format
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					is.getInputStream(), Charset.forName("UTF-8")));
			// LOG.info(rd.toString());
			// passing the reader fetched data to below method to gather all the
			// data in URL in string format
			String jsonText = readAll(rd);
			// LOG.info(jsonText);
			if (StringUtils.isNotEmpty(jsonText)) {
				// creating an file name with ID from DB table and format of
				// current
				// systemdate and time
				String formatForFileSaving = codeDataSourceId + "_"
						+ currentSystemTimeAndDate;

				// create file based on the ID fetched from DB
				File jsonFileName = new File(dir.toString() + "/"
						+ codeDataSourceId + ".json");
				// validating the file exists or not, if exists create an file
				// name
				// using ID and Systemdate and time
				if (jsonFileName.exists()) {
					jsonFileName = new File(dir.toString() + "/"
							+ formatForFileSaving + ".json");
				}
				// using the json file as created in the folder for writing the
				// content from the url
				LOG.info(jsonText);
				output = new BufferedWriter(new FileWriter(jsonFileName));

				output.write(jsonText);
				LOG.info("path where file is stored {}",
						jsonFileName.getAbsolutePath());

				return jsonFileName.getAbsolutePath();

			} else {
				LOG.info("The data in the file is empty{}", codeDataSourceId);

			}

			// return is introduced to implemention part of sending the data to
			// the FTP server
			/*
			 * By using this return we are able to achieve current folder name
			 * used as part of the file creation this return can be removed if
			 * once the some logic is implemented in the sending data to FTP
			 * part
			 */

		} finally {
			if (output != null) {
				output.close();
			}
		}

		// dummy return ... to avoid return error
		return null;

	}
	
	
	public static void main(String[] args) throws IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		// get the url from the codedatasource based on the ID
		// String url=InsertToStatsDownTable.getUrlFromCodeDataTab(session,
		// "25");

		// readJsonFromUrl(InsertToStatsDownTable.getUrlFromCodeDataTab(session,
		// "25"),"10");
		readJsonFromUrl("https://api.allcoin.com/api/v1/trades?symbol=btc_usd",
				"10");

	}

}
