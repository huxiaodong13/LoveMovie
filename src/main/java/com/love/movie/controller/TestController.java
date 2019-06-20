package com.love.movie.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.love.movie.model.User;
import com.love.movie.service.TestService;

@Controller
@RequestMapping("/index")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	
	/**
	 * forgetpassword 忘记密码
	 * 
	 * @return
	 */
	public ModelAndView forgetPassword() {
		ModelAndView mv = new ModelAndView("findPassword");
		
		
		
		return mv;
	}
	
	
	@RequestMapping("test")
	public ModelAndView test(String name) {
		//插入用户
//		User ruser = new User(3,"sakura","12345","23@qq.com",1,new Date(), "111",new Date(),1234567891);
		
//		if(testService.registUser(ruser)) {
//			System.out.println("注册成功啦");
//		}else {
//			System.out.println("注册失败");
//		}
		
		System.out.println("name==" + name);
		ModelAndView mv = new ModelAndView("xd");
		mv.addObject("password", "123456");
		
		User user = testService.getUserInfoByUid(1);
		
		List<Map<String, Object>> users = testService.getAllUsers();
		for(Map<String, Object> u : users) {
			System.out.println("======================");
			System.out.println(u);
			System.out.println("======================");
		}
		mv.addObject("user", user);
		mv.addObject("users", users);
		
		return mv;
	}
	
	
	
}
