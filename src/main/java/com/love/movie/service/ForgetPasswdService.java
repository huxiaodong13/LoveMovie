package com.love.movie.service;

/**
 * 忘记密码服务
 * 
 * @author sakura
 *
 */

public interface ForgetPasswdService {
	
	/**
	 * 配置邮箱信息
	 * 
	 * 
	 * @param toMailAddress
	 * @param contents
	 */
	public boolean setMail(String toMailAddress, String contents);
	
	
	
	/**
	 * 用户输入的密码
	 * 
	 * @param userEmail
	 * @return
	 */
	public boolean sendMail(String userEmail);
	
	
	/**
	 * 设置发送内容
	 * 
	 * @param userEmail
	 * @param link
	 * @param adminEmailA
	 * @return
	 */
	public String setContent(String userEmail, String link, String adminEmailA);
	
	
	/**
	 * 检查重置密码的连接的有效性
	 * 
	 * @param key
	 * @return
	 */
	public boolean checkResetPasswdLink(String key);
	
	
	
	/**
	 * 从重置密码链接中获取用户的邮箱
	 * 
	 * @param key
	 * @return
	 */
	public String getUserEmailFromLink(String key);
	
	
	
}
