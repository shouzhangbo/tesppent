package com.my.paypal.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.my.paypal.mapper.TestMapper;

@Controller
public class TestCtrl {
	
	private static final Log log = LogFactory.getLog(TestCtrl.class);
	@Autowired
	private TestMapper testMapper;
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(String name){
		log.info("info级别的日志输出：into test controller!!");
		log.error("error级别的日志输出：into test controller!!");
		log.debug("debug级别的日志输出：into test controller!!");
//		System.out.println(testMapper.getTest().size());
		return null==name?"this is a test!":name;
	}

}
