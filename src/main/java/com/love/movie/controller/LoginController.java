package com.love.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.love.movie.model.User;

/**
 * 登录/注册
 * 
 * @author sakura
 */
@Controller
@RequestMapping("index")
public class LoginController {
	
	/**
	 * 登录
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	
	/**
	 * 处理登录
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("doLogin")
	public ModelAndView doLogin(User user) {
		ModelAndView mv = null;
		return mv;
	}
	
	
	/**
	 * 注册
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("register")
	public ModelAndView doRegister(User user) {
		ModelAndView mv = null;
		return null;
	}
	
	
	
	
	
}
