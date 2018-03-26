package com.mongdal.aop.mail.dao;

import org.springframework.stereotype.Repository;

import com.mongdal.aop.mail.vo.MailVo;

@Repository
public class MailDaoImpl implements MailDao {

	@Override
	public void sendMail(MailVo mailVo) {
		System.out.println("메일 전송 완료");
	}

	@Override
	public MailVo receiveMail() {
		MailVo mailVo = new MailVo();
		mailVo.setTitle("RE : 접수가 완료되었습니다.");
		mailVo.setContents("감사합니다. 접수가 완료 되었습니다.");
		mailVo.setSender("접수팀");
		mailVo.setReceiver("몽달이");
		return mailVo;
	}
}
