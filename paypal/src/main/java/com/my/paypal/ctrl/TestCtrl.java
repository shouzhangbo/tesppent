package com.my.paypal.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.paypal.mapper.TestMapper;

@Controller
public class TestCtrl {
	
	@Autowired
	private TestMapper testMapper;
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(String name){
		System.out.println(testMapper.getTest().size());
		return null==name?"this is a test!":name;
	}

}
