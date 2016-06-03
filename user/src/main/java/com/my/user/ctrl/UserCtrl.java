package com.my.user.ctrl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("users")
public class UserCtrl {

	@POST
    @Path("register")
    @Consumes({MediaType.APPLICATION_JSON})
	public void test(){
		System.out.println("sssss");
	}
}
