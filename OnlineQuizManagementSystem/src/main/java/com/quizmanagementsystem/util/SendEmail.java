/**
 * 
 */
package com.quizmanagementsystem.util;

/**
 * Developer : Dhruv
 * Objective : 
 * Date      : Jul 9, 2022
 * Time      : 6:18:50 PM
 */
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail implements Runnable {

    String sendemail = null;
    String msg = null;

    public void senmail(String mail, String msg) {

	sendemail = mail;
	this.msg = msg;
    }

    @Override
    public void run() {
	final String username = "infothequizmanagement01@gmail.com";
	final String password = "qqijctuxeqlmzqvo";

	Properties prop = new Properties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
	prop.put("mail.smtp.port", "465");
	prop.put("mail.smtp.auth", "true");
	prop.put("mail.smtp.starttls.enable", "true");
	prop.put("mail.smtp.socketFactory.port", "465");
	prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
	    @Override
	    protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	    }
	});

	try {

	    Message message = new MimeMessage(session);
	    message.setFrom(new InternetAddress("infothequizmanagement01@gmail.com"));
	    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendemail));
	    message.setSubject("Online Quiz");
	    message.setContent(msg, "text/html");

	    Transport.send(message);

	    System.out.println("Done");

	} catch (MessagingException e) {
	    e.printStackTrace();
	}

    }
}
