package com.whz.main.account.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.whz.main.account.email.exception.AccountEmailException;

public class AccountEmailServiceImpl implements AccountEmailService {

	private JavaMailSender javaMailSender;
	
	private String systemEmailAdr;
	
	@Override
	public void sendMail(String to, String subject, String htmlText)
			throws AccountEmailException {

			MimeMessage msg=javaMailSender.createMimeMessage();
			MimeMessageHelper msgHelper=new MimeMessageHelper(msg);
			
			try {
				msgHelper.setFrom(systemEmailAdr);
				msgHelper.setTo(to);
				msgHelper.setSubject(subject);
				msgHelper.setText(htmlText, true);
			} catch (MessagingException e) {
				throw new AccountEmailException("Faild to send mail.",e);
			}
			
			javaMailSender.send(msg);

	}

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public String getSystemEmailAdr() {
		return systemEmailAdr;
	}

	public void setSystemEmailAdr(String systemEmailAdr) {
		this.systemEmailAdr = systemEmailAdr;
	}

}
