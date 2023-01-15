	package util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class RegisterMailUtil {
	private static final String FROM = "students.masterinfo@gmail.com";
	private static final String NAME = "STUDENTS!";
	private static final String PW = "qrqercuxfvkajglk";
	private static final String CHARSET = "UTF-8";

	public static void sendMail(String to, String subject, String body) {
		Properties property = new Properties();

		property.put("mail.smtp.auth", "true");
		property.put("mail.smtp.starttls.enable", "true");
		property.put("mail.smtp.host", "smtp.gmail.com");
		property.put("mail.smtp.port", "587");
		property.put("mail.smtp.debug", "true");

		Session session = Session.getInstance(property,new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM,PW);
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(FROM, NAME));
			
			Address toAddress = new InternetAddress(to);
			message.setRecipient(Message.RecipientType.TO, toAddress);
			
			message.setSubject(subject, CHARSET);
			message.setText(body, CHARSET);
			
			Transport.send(message);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
