package com.love.movie.service;

import java.util.List;
import java.util.Map;

public interface XUserService {

	//管理员 获取所有用户
	public List<Map<String, Object>> getMAllUser();
	
	//管理员 注销用户账号(删除)
	public boolean delUserById(int uid);
}
