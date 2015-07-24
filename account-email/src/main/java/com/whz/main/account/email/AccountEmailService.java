package com.whz.main.account.email;

import com.whz.main.account.email.exception.AccountEmailException;

public interface AccountEmailService {
	void sendMail(String to,String subject,String htmlText) throws AccountEmailException;
}
