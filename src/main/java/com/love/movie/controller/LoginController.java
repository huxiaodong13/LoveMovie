package com.love.movie.controller;

import java.security.MessageDigest;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.love.movie.model.User;
import com.love.movie.service.UserService;

/**
 * 登录/注册
 * 
 * @author sakura
 */
@Controller
@RequestMapping("index")
public class LoginController {

	@Autowired
	private UserService userServiceId;

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
	 * 处理登录 异步请求
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("doLogin")
	@ResponseBody
	public String doLogin(User user, HttpServletRequest request) {
		System.out.println("login user===" + user);

		// 用户名不存在
		if (!userServiceId.isExistUserByName(user.getUsername())) {
			return "-1";
		}

		MessageDigest md = DigestUtils.getSha256Digest();
		byte[] passwordByte = md.digest(user.getPassword().getBytes());
		String userInputPassword = Hex.encodeHexString(passwordByte);
		User user2 = userServiceId.getUserByName(user.getUsername());
		
		
		System.out.println("1234567" + Hex.encodeHexString(md.digest("123456".getBytes())));
		
		
		// 密码错误
		if (!user2.getPassword().equals(userInputPassword)) {
			return "0";
		}

		// 设置session
		HttpSession session = request.getSession();
		session.setAttribute("user", user2);
		session.setAttribute("login", true);

		return "1"; // 密码不正确
	}

	/**
	 * 退出登录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("logout")
	public String doLogout(HttpServletRequest request) {
		
		// 销毁会话
		request.getSession().invalidate();

		// 重定向至首页
		return "redirect:login";
	}

	/**
	 * 处理注册
	 * 
	 * @param user 使用对象接收对象
	 * @return
	 */
	@RequestMapping("doRegister")
	@ResponseBody
	public String doRegister(User user) {
		System.out.println("register user============" + user);
		MessageDigest md = DigestUtils.getSha256Digest();
//		byte[] password = md.digest("sakura".getBytes());
//		System.out.println("使用sha256加密后===" + Hex.encodeHexString(password));

		// 将密码使用sha256加密
		byte[] passwordByte = md.digest(user.getPassword().getBytes());
		String password = Hex.encodeHexString(passwordByte);

		user.setPassword(password);
		user.setUdate(new Date());
		user.setLevel(0); //普通用户

		// 插入用户 插入不成功则已存在同名用户
		boolean addOk = userServiceId.addUser(user);

		if (addOk) {
			return "success";
		} else {
			return "failure";
		}
	}
	
	
	//临时的主页
	@RequestMapping("LMindex")
	public ModelAndView goLMindex() {
		ModelAndView mv = new ModelAndView("indexr");
		return mv;
	}
}
