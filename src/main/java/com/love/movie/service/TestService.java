package com.love.movie.service;

import java.util.List;
import java.util.Map;

import com.love.movie.model.User;

public interface TestService {
	
	//获取用户信息
	public User getUserInfoByUid(int uid);
	
	//获取所有用户信息
	public List<Map<String, Object>> getAllUsers();
	
	
	//注册
	public boolean registUser(User user);
}
