package com.my.test.service;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

	public String getTest(String name) {
		return null==name?"this is a Test!":name;
	}

}
