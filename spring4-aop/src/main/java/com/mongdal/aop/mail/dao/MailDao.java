package com.mongdal.aop.mail.dao;

import com.mongdal.aop.mail.vo.MailVo;

public interface MailDao {

	public void sendMail(MailVo mailVo);

	public MailVo receiveMail();

}
