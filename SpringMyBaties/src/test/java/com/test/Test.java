package com.test;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.my.test.dao.BaseUserDao;
import com.my.test.dao.UserInfoDao;
import com.my.test.manage.TestService;

//@ContextConfiguration(value = "classpath:spring/spring-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试  
@ContextConfiguration   
({"classpath:*.xml"}) //加载配置文件  
public class Test {

	@Resource
    private TestService testService;
	
	@org.junit.Test
    public void test(){
//		testService.test();
    }
}
