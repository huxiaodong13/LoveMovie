package com.love.movie.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.love.movie.util.UserUtil;

@Controller
@RequestMapping("index")
public class UserController {
	
	
	/**
	 * 用户个人信息主页
	 * 
	 * @return
	 */
	@RequestMapping("userInfo")
	public ModelAndView userInfo(HttpServletRequest request) {
		
		if(!UserUtil.isLogin(request)) {
			return new ModelAndView("error");
		}
		
		ModelAndView mv = new ModelAndView("userPage");
		return mv;
	}
	
	
	
	
}
