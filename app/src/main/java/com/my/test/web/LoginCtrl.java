package com.my.test.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginCtrl {

	@RequestMapping("/login")
	public String login(HttpServletRequest request,
            HttpServletResponse response,String userName,String pwd){
		HttpSession session = request.getSession();
		session.setAttribute("user", userName+","+pwd);
		response.addCookie(new Cookie("user",userName+","+pwd));
		return "main";
	}
}
