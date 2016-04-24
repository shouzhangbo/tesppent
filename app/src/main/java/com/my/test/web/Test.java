package com.my.test.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.test.service.TestService;
import com.my.test.service.TestServiceImpl;

@Controller
public class Test {

//	@Autowired
	private TestServiceImpl testService;
	@RequestMapping(value="/testt")
	@ResponseBody
	public Object Testt(String name){
		TestServiceImpl testService = new TestServiceImpl();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", testService.getTest(name));
		return map;
	}
	
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request,String userName){
		HttpSession session = request.getSession();
		System.out.println("传入的userName="+userName);
		session.setAttribute("userName", userName);
		System.out.println("session里面的userName="+(String) session.getAttribute("userName"));
		return "test";
	}
}
