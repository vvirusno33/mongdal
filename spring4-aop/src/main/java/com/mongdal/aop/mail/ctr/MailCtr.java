package com.mongdal.aop.mail.ctr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongdal.aop.mail.svc.MailSvc;
import com.mongdal.aop.mail.vo.MailVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MailCtr {

	@Autowired
	private MailSvc mailSvcImpl;

	@RequestMapping(value = "/aopTestSendMail.do", method = RequestMethod.GET)
	public String sendMail(Model model) {

		MailVo mailVo = new MailVo();
		mailVo.setTitle("핸드폰이 액정이 깨졌습니다.");
		mailVo.setContents("핸드폰 액정이 깨졌습니다. 수리해 주세요");
		mailVo.setSender("몽달이");
		mailVo.setReceiver("접수팀");
		mailSvcImpl.sendMail(mailVo);

		model.addAttribute("resultMsg", "메일 전송 성공");

		return "sendResult";
	}

	@RequestMapping(value = "/aopTestReceiveMail.do", method = RequestMethod.GET)
	public String receiveMail(Model model) {

		MailVo receiveMail = mailSvcImpl.receiveMail();
		model.addAttribute("mailVo", receiveMail);

		return "receiveResult";
	}

}
