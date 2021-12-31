package com.hrms.util;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * 发送邮件的工具类
 */
public class MailUtils {
	// 定义邮箱常量信息
	public static final String mail_smtp_auth = "true";
	public static final String mail_transport_protocol = "smtp";
	public static final String mail_smtp_ssl_enable = "true";
	public static final String mail_smtp_socketFactory_class = "javax.net.ssl.SSLSocketFactory";
	public static final String mail_InternetAddress = "heshinuo@163.com";
	public static final String mail_Host = "smtp.163.com";
	public static final int mail_port = 465;
	public static final String mail_username = "heshinuo@163.com";
	public static final String mail_password = "CKHBVIKQNFSHUHHQ"; // 授权码，不是登陆密码

	public static void sendMail(String email, String emailMsg)
			throws AddressException, MessagingException, GeneralSecurityException {
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		final Properties props = new Properties();
		// 表示SMTP发送邮件，需要进行身份验证
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.163.com");
		// smtp登陆的账号、密码 ；需开启smtp登陆
		props.setProperty("mail.debug", "true");
		props.put("mail.user", "heshinuo@163.com");
		props.put("mail.password", "CKHBVIKQNFSHUHHQ");
		// 特别需要注意，要将ssl协议设置为true,否则会报530错误
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.socketFactory", sf);
		Authenticator authenticator = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				// 用户名、密码
				String userName = props.getProperty("mail.user");
				String password = props.getProperty("mail.password");
				return new PasswordAuthentication(userName, password);
			}
		};
		// 使用环境属性和授权信息，创建邮件会话
		Session mailSession = Session.getInstance(props, authenticator);
		// 创建邮件消息
		MimeMessage message = new MimeMessage(mailSession);
		// 设置发件人
		try {
			InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
			message.setFrom(form);
			// 设置收件人
			InternetAddress to = new InternetAddress(email);
			message.setRecipient(Message.RecipientType.TO, to);

			message.setSubject("您的请假回复");
			// 设置邮件的内容体
			message.setContent(emailMsg, "text/html;charset=UTF-8");
			// 发送邮件
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
