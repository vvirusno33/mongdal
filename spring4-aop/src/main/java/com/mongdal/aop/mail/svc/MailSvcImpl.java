package com.mongdal.aop.mail.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongdal.aop.mail.dao.MailDao;
import com.mongdal.aop.mail.vo.MailVo;

@Service
public class MailSvcImpl implements MailSvc {

	@Autowired
	private MailDao mailDaoImpl;

	@Override
	public void sendMail(MailVo mailVo) {
		mailDaoImpl.sendMail(mailVo);
	}

	@Override
	public MailVo receiveMail() {
		return mailDaoImpl.receiveMail();
	}

}