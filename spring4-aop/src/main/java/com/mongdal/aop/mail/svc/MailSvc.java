package com.mongdal.aop.mail.svc;

import com.mongdal.aop.mail.vo.MailVo;

public interface MailSvc {

	void sendMail(MailVo mailVo);

	MailVo receiveMail();

}
