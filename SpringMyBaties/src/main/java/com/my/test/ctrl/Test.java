package com.my.test.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.test.manage.TestService;
import com.my.test.mapper.baseUser;
import com.my.test.mapper.userInfo;
import com.my.test.mongodb.TestMongoDb;

@Controller
public class Test {

	@Autowired
	TestService testService;
	
	@Autowired
	TestMongoDb testMongoDb;
	
	@RequestMapping(value="/test")
	public void test(baseUser base,userInfo user){
		testService.test(base,user);
		System.out.println("aaa");
	}
	
	@RequestMapping(value="/testt")
	public void testt(){
		testService.testt();
	}
	
	
	@RequestMapping(value="/mogo")
	public void mogo(baseUser base){
		testMongoDb.save(base);
	}
	
	@RequestMapping(value="/find")
	public void find(baseUser base){
		List<baseUser> list =testMongoDb.find(base.getUserName());
		System.out.println("list="+list.size());
	}
}
