/*
 * 
 */
package com.core.isonsoft.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

// TODO: Auto-generated Javadoc
/**
 * The Class EpochDateConverter.
 */
public class EpochDateConverter {

	/**
	 * Epoch Time converter which return string.
	 *
	 * @param dateInLong
	 *            the date in long
	 * @return the string
	 */
	public static String epochTImeConverrter(long dateInLong) {

		Date date = new Date(dateInLong * 1000L);
		System.out.println(date);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String formatted = format.format(date);
		format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		// System.out.println("formatted--->"+formatted);
		return formatted;

	}

	/**
	 * Epoch T ime converrter in to date.
	 *
	 * @param dateInLong
	 *            the date in long
	 * @return the date
	 */
	public static Date epochTImeConverrterInToDate(long dateInLong) {

		Date date = new Date(dateInLong);
		System.out.println(date);
		return date;

	}

	/**
	 * Normal date converter.
	 *
	 * @param date
	 *            the date
	 * @return the string
	 */
	@SuppressWarnings("deprecation")
	public static String normalDateConverter(String date) {
		Date date2 = new Date(date);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setTimeZone(TimeZone.getTimeZone("ISO"));

		String formatted1 = format.format(date2);
		return formatted1;
	}

	/**
	 * Converting simple date.
	 *
	 * @param timestamp
	 *            the timestamp
	 * @return the date
	 * @throws ParseException
	 *             the parse exception
	 */
	public static Date convertingSimpleDate(String timestamp)
			throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date date2 = formatter.parse(timestamp);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date2);
		Date jaffa = calendar.getTime();

		return jaffa;
	}

	/**
	 * Converting simple date.
	 *
	 * @param timestamp
	 *            the timestamp
	 * @return the date
	 * @throws ParseException
	 *             the parse exception
	 */
	public static String convertingSimpleDateForT(String timestamp)
			throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date date2 = formatter.parse(timestamp);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setTimeZone(TimeZone.getTimeZone("ISO"));

		String formatted1 = format.format(date2);

		return formatted1;
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws InterruptedException
	 *             the interrupted exception
	 * @throws ParseException
	 *             the parse exception
	 */
	public static void main(String[] args) throws InterruptedException,
			ParseException {

		/*
		 * Long epoch= new Long("1475606007"); long y=epoch.MIN_VALUE;
		 * System.out.println(""+y); String epochString="1476137924112";
		 * 
		 * String date="Oct 4, 2016 at 19:31 BST"; String timestamp =
		 * "Oct 4, 2016 at 19:31 BST";
		 * 
		 * EpochDateConverter ep=new EpochDateConverter();
		 * ep.epochTImeConverrter(epoch);
		 */
		// ep.epochTImeConverrter(epoch);
		/*
		 * ep.normalDateConverter(date); ep.convertingSimpleDateForT(timestamp);
		 */
		// ep.epochTImeConverrterInToDate(epoch);

	}

}
