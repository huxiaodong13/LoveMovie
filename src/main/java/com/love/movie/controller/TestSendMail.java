package com.love.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.love.movie.service.ForgetPasswdService;



@Controller
public class TestSendMail {
//	public static void main(String[] args){  
//        //这个类主要是设置邮件  
//     MailSenderInfo mailInfo = new MailSenderInfo();   
//     mailInfo.setMailServerHost("smtp.163.com");   
//     mailInfo.setMailServerPort("25");   
//     mailInfo.setValidate(true);   
//     mailInfo.setUserName("15114075724@163.com");   
//     mailInfo.setPassword("xjwyf201755");//您的邮箱密码   
//     mailInfo.setFromAddress("15114075724@163.com");   
//     mailInfo.setToAddress("xiaod_Hu@163.com");   
//     mailInfo.setSubject("这是测试");   
//     mailInfo.setContent("<a href = \"http://write.blog.csdn.net/postlist\">http://write.blog.csdn.net/postlist</a>");   
//        //这个类主要来发送邮件  
//     SimpleMailSender sms = new SimpleMailSender();  
////         sms.sendTextMail(mailInfo);//发送文体格式   
//         sms.sendHtmlMail(mailInfo);//发送html格式  
//   }  
	
//	@Autowired
//	private ForgetPasswdService FPService;
//	
//	@RequestMapping("forgetPassword")
//	public ModelAndView forgetPassword(String userEmail) {
//		
////		Boolean sendOk = FPService.sendMail("1432532621@qq.com");
//		
//		Boolean sendOk = FPService.sendMail("xiaod_Hu@163.com");
//		
//		ModelAndView mv = null;
//		if(sendOk) {
//			mv = new ModelAndView("sendEmailOK");
//		}else {
//			mv = new ModelAndView("sendEmailFail");
//		}
//		
//		return mv;
//	}
}
