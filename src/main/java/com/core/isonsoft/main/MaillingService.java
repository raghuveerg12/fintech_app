package com.core.isonsoft.main;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MaillingService {

	public static void sendMail(String Id, String errorMessage) {
		// Recipient's email ID needs to be mentioned.
		String to = "g.raghu.v@gmail.com";// change accordingly
		String to2 = "raghuveerg12@gmail.com";

		// Sender's email ID needs to be mentioned
		String from = "raghuveerg@isonsoft.cz";// change accordingly
		final String username = "raghuveerg@isonsoft.cz";// change accordingly
		final String password = "wwwsdrftweetech@121swqawsawdfffc";// change
																	// accordingly

		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		// Get the Session object.
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password
								.substring(11, 19));
					}
				});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			message.addRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.addRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to2));
			// Set To: header field of the header.

			// Set Subject: header field
			message.setSubject(" exception processing id" + Id);

			// Now set the actual message
			message.setText("Please find below details stackTrace for Excception occured while Downloading"
					+ '\n' + '\n' + '\n' + "" + errorMessage);

			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		String Id = "11";
		String errorMessage = "Exception in thread main java.sql.SQLRecoverableException: Closed Connection"
				+ "	at oracle.sql.CLOB.getDBAccess(CLOB.java:1714)"
				+ "at oracle.sql.CLOB.isOpen(CLOB.java:1287)"
				+ "at oracle.sql.CLOB.free(CLOB.java:2037)"
				+ "at com.core.isonsoft.Scheduler.ScheduleForId11.getTheDetailsForIdForDB(ScheduleForId11.java:90)"
				+ "at com.core.isonsoft.Scheduler.ScheduleForId11.main(ScheduleForId11.java:99)";

		MaillingService.sendMail(Id, errorMessage);
	}
}
