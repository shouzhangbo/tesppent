package com.my.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.test.mapper.baseUser;
import com.my.test.mapper.baseUserMapper;

@Repository
public class BaseUserDaoImpl implements BaseUserDao {

	@Autowired
	baseUserMapper baseMapper;
	
	@Override
	public void save(baseUser base) {
		baseMapper.insert(base);
	}

	@Override
	public void update(baseUser base) {
		baseMapper.updateByPrimaryKey(base);
	}

}
