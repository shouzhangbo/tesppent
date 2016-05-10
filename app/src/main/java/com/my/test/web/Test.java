package com.my.test.web;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.test.service.TestServiceImpl;

@Controller
public class Test {

	@Autowired
	private TestServiceImpl testService;
	
//	@Autowired
//	private TestMapper testMapper;
	
	@RequestMapping(value="/testt")
	@ResponseBody
	public Object Testt(String name){
		TestServiceImpl testService = new TestServiceImpl();
		Map<String,Object> map = new HashMap<String,Object>();
//		java.util.List<com.my.test.mapper.Test> testt = testMapper.getTest();
		map.put("name", testService.getTest(name));
		return map;
	}
	@RequestMapping(value="/list")
	public String List(){
		return "list";
	}
	
}
