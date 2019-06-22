package com.love.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love.movie.mapper.UserMapper;
import com.love.movie.model.User;
import com.love.movie.model.UserExample;
import com.love.movie.model.UserExample.Criteria;
import com.love.movie.service.UserService;



@Service("userServiceId")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public boolean addUser(User user) {

		//如果用户存在 直接返回失败
		if(isExistUserByName(user.getUsername())) {
			return false;
		}
		
		int n = userMapper.insertSelective(user);
		
		
		if(n>=1) {
			return true;
		}
		return false;
	}


	@Override
	public boolean isExistUserByName(String name) {
		UserExample userExample = new UserExample();
		Criteria uCriteria = userExample.createCriteria();
		uCriteria.andUsernameEqualTo(name);
		List<User> users = userMapper.selectByExample(userExample);
		
		System.out.println("findusers BY name ====" + users);
		if(users.isEmpty()) {
			return false;
		}
		return true;
	}


	@Override
	public User getUserByName(String name) {
		UserExample userExample = new UserExample();
		Criteria uCriteria = userExample.createCriteria();
		uCriteria.andUsernameEqualTo(name);
		List<User> users = userMapper.selectByExample(userExample);
		return users.get(0);
	}

}
