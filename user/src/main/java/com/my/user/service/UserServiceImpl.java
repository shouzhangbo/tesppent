package com.my.user.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.my.user.mode.User;

@Path("user")
public class UserServiceImpl implements UserService{

//	@GET
    @Path("register")
    @Consumes({MediaType.APPLICATION_JSON})
	public String test(User user) {
		System.out.println(user.getName()+","+user.getId());
		return "success";
	}

}
