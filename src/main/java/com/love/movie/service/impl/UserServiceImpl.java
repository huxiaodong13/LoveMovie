package com.love.movie.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love.movie.mapper.CustomedSakuraUserMapper;
import com.love.movie.mapper.SeenmovieMapper;
import com.love.movie.mapper.UserMapper;
import com.love.movie.model.Movie;
import com.love.movie.model.Seenmovie;
import com.love.movie.model.SeenmovieExample;
import com.love.movie.model.User;
import com.love.movie.model.UserExample;
import com.love.movie.model.UserExample.Criteria;
import com.love.movie.service.UserService;



@Service("userServiceId")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private SeenmovieMapper seenMMapper;
	
	@Autowired
	private CustomedSakuraUserMapper csUserMapper;
	
	
	
	
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


	@Override
	public boolean updateUserInfo(User user) {
		int n = userMapper.updateByPrimaryKeySelective(user);
		return false;
	}


	@Override
	public List<Map<String, Object>> getSeenMovies(int uid) {
		return csUserMapper.getUserSeenMovies(uid);
	}


	@Override
	public List<Map<String, Object>> getWantSeeMovie(int uid) {
		return csUserMapper.getUserWSeenMovies(uid);
	}


	@Override
	public List<Map<String, Object>> getCommentByUserId(int uid) {
		return csUserMapper.getUserComments(uid);
	}


	@Override
	public User getUserByUid(int uid) {
		return userMapper.selectByPrimaryKey(uid);
	}
	

	
}
