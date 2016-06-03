package com.my.test.mongodb;

import java.util.List;

import com.my.test.mapper.baseUser;

public interface TestMongoDb {
	
	void save(Object obj);
//	void update();
	List<baseUser> find(String userName);
	
}
