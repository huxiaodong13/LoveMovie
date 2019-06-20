package com.love.movie.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love.movie.mapper.CustomedLMMapper;
import com.love.movie.mapper.UserMapper;
import com.love.movie.model.User;
import com.love.movie.service.TestService;


@Service("testService")
public class TestServiceImpl implements TestService {
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private CustomedLMMapper customedLMMapper;
	
	@Override
	public User getUserInfoByUid(int uid) {
		
		User user = userMapper.selectByPrimaryKey(uid);
		
		System.out.println("user===" + user);
		
		return user;
	}

	@Override
	public List<Map<String, Object>> getAllUsers() {
		return customedLMMapper.getAllUsers();
	}

	@Override
	public boolean registUser(User user) {
		int n = userMapper.insertSelective(user);
		if(n>=1) {
			return true;
		}
		return false;
	}

}
