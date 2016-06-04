package com.my.test.ctrl;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.test.mapper.baseUser;
import com.my.test.util.JsonUtil;
import com.my.test.util.MemcachedUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class LoginCtrl {

	 private final static Logger log = LoggerFactory.getLogger(LoginCtrl.class);
	@Autowired
	private MemcachedUtil memcachedUtil;
	
	@RequestMapping(value="/valiLlogin")
	@ResponseBody
	public Map<String,Object> valiLlogin(HttpServletResponse response,HttpServletRequest request)
	{
		log.info("哈哈哈哈哈哈哈哈哈哈");
		Map<String,Object> map = new HashMap<String,Object>();
		baseUser user = getUserByCookies(request,"name");
		if(null==user){
			log.info("该用户不存在");
			map.put("respCode", "9000");
			map.put("respMsg", "用户不存在");
			return map;
		}
		baseUser user1 = (baseUser) memcachedUtil.get(user.getUserName());
		if(user1.getSessionId().equals(user.getSessionId()))
		{
			map.put("respCode", "0000");
			map.put("respMsg", "用户已经登录");
		}else{
			map.put("respCode", "9000");
			map.put("respMsg", "用户登出");
		}
		return map;
	}
	@RequestMapping(value="/login")
	public String login(HttpServletResponse response,HttpServletRequest request,
			String userName,String pwd){
		baseUser base = new baseUser();
		if(null!=userName&&null!=pwd){
			base.setUserName(userName);
			base.setUserPwd(pwd);
			base.setCreatedate(new Date());
			base.setModifydate(new Date());
			base.setSessionId(getRandomString(6));
			memcachedUtil.set(userName, 1500, base);
			String val = JsonUtil.objectToJson(base);
			Cookie cookie = new Cookie("name", val);
			response.addCookie(cookie);
		}
		Object user =  memcachedUtil.get(userName);
		return "main";
	}
	@RequestMapping(value="/opt")
	public String caozuo(HttpServletResponse response,HttpServletRequest request,
			String userName,String pwd){
		baseUser base = new baseUser();
		if(null!=userName&&null!=pwd){
			base.setUserName(userName);
			base.setUserPwd(pwd);
			base.setCreatedate(new Date());
			base.setModifydate(new Date());
			memcachedUtil.set(userName, 1500, base);
		}
		Cookie cookie = new Cookie("name", JsonUtil.objectToJson(base));
		response.addCookie(cookie);
		Object user =  memcachedUtil.get(userName);
		return "main";
	}
	public static void main(String[] args) {
		String ss = "1234567";
		System.out.println(ss.length());
		System.out.println(ss.substring(0,5).length());
	}
	public baseUser getUserByCookies(HttpServletRequest request,String cooKey){
		Cookie[] coos = request.getCookies();
		if(null!=coos){
			for(Cookie co:coos){
				if(cooKey.equals(co.getName())){
					return (baseUser) JsonUtil.jsonToBean(co.getValue(), baseUser.class);
				}
			}
		}
		return null;
	}
	
	//生成随机数
    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
