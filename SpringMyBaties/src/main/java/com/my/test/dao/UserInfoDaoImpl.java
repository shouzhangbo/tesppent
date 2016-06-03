package com.my.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.test.mapper.baseUserMapper;
import com.my.test.mapper.userInfo;
import com.my.test.mapper.userInfoMapper;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {

	@Autowired
	userInfoMapper userMapper;
	@Override
	public void save(userInfo user) {
		userMapper.insert(user);
	}

	@Override
	public void update(userInfo user) {
		userMapper.updateByPrimaryKey(user);
	}

}
