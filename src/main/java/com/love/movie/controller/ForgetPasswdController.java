package com.love.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.love.movie.service.ForgetPasswdService;

/**
 * 忘记密码控制器
 * 
 * @author sakura
 *
 */

@Controller
@RequestMapping("/forgetPassword")
public class ForgetPasswdController {

	@Autowired
	private ForgetPasswdService FPService;
	
	
	
	/**
	 * 找回密码界面
	 * 
	 * @return
	 */
	@RequestMapping("findPassword")
	public String findPassword() {
		return "findPassword";
	}
	
	/**
	 * 处理找回密码 发送邮件
	 * 
	 * @param userEmail 用户用于找回密码的邮箱
	 * @return
	 */
	@RequestMapping("doFindPassword")
	public ModelAndView doFindPassword(String userEmail) {

//		userEmail = "xiaod_Hu@163.com";

		boolean sendOk = FPService.sendMail(userEmail);
		
		System.out.println("userEmail====" + userEmail);
		
		
		ModelAndView mv = null;
		if (sendOk) {
			mv = new ModelAndView("sendEmailOK");
		} else {
			mv = new ModelAndView("sendEmailFail");
		}

		return mv;
	}

	/**
	 * 重置密码
	 * 
	 * @param key
	 * @return
	 */
	@RequestMapping("resetPassword")
	public ModelAndView resetPassword(String key) {
		ModelAndView mv = null;

		//检查重置链接的合法性
		boolean isVaildLink = FPService.checkResetPasswdLink(key);
		isVaildLink = false;
		if (isVaildLink) {
			mv = new ModelAndView("resetPassword");
			String userEmail = FPService.getUserEmailFromLink(key);
			mv.addObject("userEmail", userEmail);
			
			System.out.println("重置密码成功===" + userEmail);
		} else {
			System.out.println("密码链接失效");
			mv = new ModelAndView("resetPasswordError");
			mv.addObject("errorMsg", "重置密码链接失效");

		}
		return mv;
	}

}
