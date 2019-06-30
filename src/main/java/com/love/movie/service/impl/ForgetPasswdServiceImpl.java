package com.love.movie.service.impl;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.love.movie.util.DESUtil;
import com.love.movie.util.MailSenderInfo;
import com.love.movie.util.SimpleMailSender;

@Service("FPService")
public class ForgetPasswdServiceImpl implements com.love.movie.service.ForgetPasswdService {

	/**
	 * 配置邮箱信息
	 * 
	 * 
	 * @param toMailAddress
	 * @param contents
	 */
	@Override
	public boolean setMail(String toMailAddress, String contents) {
		// 这个类主要是设置邮件
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.163.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUserName("15114075724@163.com");
		mailInfo.setPassword("xjwyf201755");// 您的邮箱密授权码
		mailInfo.setFromAddress("15114075724@163.com");

		mailInfo.setToAddress(toMailAddress);

		mailInfo.setSubject("想看电影");
		mailInfo.setContent(contents);
		// 这个类主要来发送邮件
		SimpleMailSender sms = new SimpleMailSender();
		try{
			sms.sendHtmlMail(mailInfo);// 发送html格式
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * desp 用户输入的密码
	 * 
	 * @param userEmail
	 * @return
	 */
	@Override
	public boolean sendMail(String userEmail) {

		boolean sendOk = true; // 标记邮件是否发送成功

		try {
			
			// 获取系统当前时间
			Date now = new Date();
			String currentTime = "" + now.getTime();
			// 重置密码链接
			String urlStr = "http://localhost:8080/LoveMovie/forgetPassword/resetPassword?key=";
			String plainText = currentTime + "@" + userEmail; // 当前时间加上用户邮箱     
			String desKey = "LOVEMOIVE"; // des算法中的密钥
			String link = urlStr + DESUtil.encrypt(desKey, plainText);
			
			
			
			System.out.println("加密后的链接link:" + link);
			String adminEmail = "15114075724@163.com";
			String contents = this.setContent(userEmail, link, adminEmail);
			System.out.println("contents=====" + contents);

			sendOk = this.setMail(userEmail, contents);

			return sendOk;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sendOk;
	}

	/**
	 * 设置发送内容
	 * 
	 * @param userEmail
	 * @param link
	 * @param adminEmailA
	 * @return
	 */
	@Override
	public String setContent(String userEmail, String link, String adminEmail) {

//		String content = "<a href='#'>" + userEmail + "</a>，您好：<br>\r\n"
//				+ "您收到这封电子邮件是因为您(也可能是某人冒充您的名义)申请了一个找回密码的请求。<br>\r\n" + 
//		"假如这不是您本人所申请，或者您曾持续收到这类的信件骚扰，请您尽快联络管理员。<br>\r\n"
//				+ "您可以点击如下链接重新设置您的密码，如果点击无效,请把下面的代码拷贝到浏览器的地址栏中:<br>\r\n" + "<a href=" + link + ">" + link
//				+ "</a><br>\r\n" + "请在2小时之内访问链接，访问链接后，您可以重新设置新的密码。<br>\r\n" + 
//		"如果您还有任何的疑问，请与我们联系。邮箱地址: <a href='#'>" + adminEmail + "</a><br>\r\n" + "请不要直接回复本邮件。<br>";
		
		
		String content = "<a href='#'>" + userEmail + "</a>，您好：<br>\r\n"+
				"请在两小时内 ，请访问如下链接，进行password重置<br>" + "<a href=" + link + ">" + link +"</a>"+
				"如果您还有任何的疑问，请与我们联系。" + "请不要直接回复本邮件。<br>";

		return content;
	}

	/**
	 * 检查重置密码的连接的有效性
	 * 
	 * @param key
	 * @return
	 */
	@Override
	public boolean checkResetPasswdLink(String key) {
		String desKey = "LOVEMOIVE"; // des算法中的密钥

		try {
			String plainText = DESUtil.decrypt(desKey, key);
			System.out.println("plainText===" + plainText);
			String timeStr = plainText.split("@")[0];
			long sendEmailTime = Long.parseLong(timeStr);
			Date nowDate = new Date();
			long nowTime = nowDate.getTime();
			long delta = (nowTime - sendEmailTime) / 1000;

			System.out.println("delta====" + delta);

			// 有限时间为2小时
			if (delta <= 3600 * 2) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("解密失败");
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 从重置密码链接中获取用户的邮箱
	 * 
	 * @param key
	 * @return
	 */
	@Override
	public String getUserEmailFromLink(String key) {
		String desKey = "LOVEMOIVE"; // des算法中的密钥

		try {
			String plainText = DESUtil.decrypt(desKey, key);

			String[] strs = plainText.split("@");

			String userEmail = strs[1] + "@" + strs[2];

			return userEmail;

		} catch (Exception e) {
			System.out.println("解密失败");
			e.printStackTrace();
		}

		return null;
	}

}
