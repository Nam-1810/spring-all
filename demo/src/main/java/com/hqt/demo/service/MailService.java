package com.hqt.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqt.demo.dao.MailDao;

@Service
public class MailService {

	@Autowired
	MailDao mailDao;

	public void addMail(String path) throws FileNotFoundException, MessagingException {
		Properties props = System.getProperties();
		props.put("mail.host", "smtp.dummydomain.com");
		props.put("mail.transport.protocol", "smtp");

		Session mailSession = Session.getDefaultInstance(props, null);
		InputStream source = new FileInputStream(new File(path));
		MimeMessage message = new MimeMessage(mailSession, source);

		mailDao.addMail(message.getSentDate().toString(), message.getAllRecipients()[0].toString(), path);
	}

}
