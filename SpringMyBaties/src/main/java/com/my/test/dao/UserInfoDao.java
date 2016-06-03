package com.my.test.dao;

import com.my.test.mapper.userInfo;

public interface UserInfoDao {
	
	void save(userInfo user);
	void update(userInfo user);
}
