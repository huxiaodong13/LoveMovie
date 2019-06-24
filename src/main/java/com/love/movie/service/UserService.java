package com.love.movie.service;

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
	
	
}
