package com.my.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.test.mapper.Test;
import com.my.test.mapper.TestMapper;

@Service
public class TestServiceImpl implements TestService{

//	@Autowired
//	private TestMapper testMapper;
	
	public String getTest(String name) {
//		List<Test> testt = testMapper.getTest();
//		System.out.println("testt="+testt.size());
		return null==name?"this is a Test!":name;
	}

}
