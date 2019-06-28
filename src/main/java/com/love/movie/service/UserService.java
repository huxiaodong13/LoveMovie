package com.love.movie.service;

import java.util.List;
import java.util.Map;

import com.love.movie.model.Movie;
import com.love.movie.model.User;

/**
 * 关于用户的一些操作封
 * 
 * @author sakura
 *
 */
public interface UserService {
	
	/**
	 * 注册用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean addUser(User user);
	
	/**
	 * 通过用户名查看用户是否存在
	 * 
	 * @param name
	 * @return
	 */
	public boolean isExistUserByName(String name);
	
	/**
	 * 根据用户名获取用户
	 * 
	 * @param name
	 * @return
	 */
	public User getUserByName(String name);
	
	
	/**
	 * 更新用户信息
	 * 
	 * @param user
	 * @return
	 */
	public boolean updateUserInfo(User user);
	
	
	/**
	 * 获取用户看过的电影
	 * 
	 * @param uid
	 * @return
	 */
	public List<Map<String, Object>> getSeenMovies(int uid);
	
	
	/**
	 * 获取用户想看的电影
	 * 
	 * @param uid
	 * @return
	 */
	public List<Map<String, Object>> getWantSeeMovie(int uid);
	
	/**
	 * 获取参与的评论
	 * 
	 * @param uid
	 * @return
	 */
	public List<Map<String, Object>> getCommentByUserId(int uid);
	
	
	/**
	 * 根据用户id 获取用户信息
	 * 
	 * @param uid
	 * @return
	 */
	public User getUserByUid(int uid);
	
	
	
}
