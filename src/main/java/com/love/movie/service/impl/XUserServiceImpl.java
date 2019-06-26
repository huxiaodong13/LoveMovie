package com.love.movie.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love.movie.mapper.UserMapper;
import com.love.movie.mapper.XCustomedUserMapper;
import com.love.movie.service.XUserService;

@Service("xuserService")
public class XUserServiceImpl implements XUserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private XCustomedUserMapper xcustomedUserMapper; 
	@Override
	public List<Map<String, Object>> getMAllUser() {
		List<Map<String, Object>>  usersList = xcustomedUserMapper.getMAllUser();
		return usersList;
	}

	@Override
	public boolean delUserById(int uid) {
		int n = userMapper.deleteByPrimaryKey(uid);
		if(n == 1) {
			return true;
		}
		return false;
	}

}
