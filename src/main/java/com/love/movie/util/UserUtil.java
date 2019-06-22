package com.love.movie.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.love.movie.model.User;

public class UserUtil {
	
	/**
	 * 判断用户是否登录
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("login") != null) {
			return true;
		}
		
		
		return false;
		
	}
	
	
}
