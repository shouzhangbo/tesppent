package com.my.test.common;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class CommonInterceptor extends HandlerInterceptorAdapter {
	
	private static Logger log =  LoggerFactory.getLogger(CommonInterceptor.class);
	
	
	@Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("userName");
		if(null==user){
			
			return false;
		}
		return true;
//		response.setHeader("Access-Control-Allow-Origin", "*" );
//		//userId鍙屾柟绾﹀畾锛氶鍏坉es鍔犲瘑锛岀劧鍚巙rl鎸夌収utf-8缂栫爜
//        String username = (String)request.getParameter("userId");
//    	OutputStream outputStream = response.getOutputStream();//鑾峰彇OutputStream杈撳嚭娴?
//    	response.setHeader("content-type", "text/html;charset=UTF-8");//閫氳繃璁剧疆鍝嶅簲澶存帶鍒舵祻瑙堝櫒浠TF-8鐨勭紪鐮佹樉绀烘暟鎹紝濡傛灉涓嶅姞杩欏彞璇濓紝閭ｄ箞娴忚鍣ㄦ樉绀虹殑灏嗘槸涔辩爜
//    	outputStream.write(r.toString().getBytes("UTF-8"));
    }
	@Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }    
    
    @Override    
    public void afterCompletion(HttpServletRequest request,    
            HttpServletResponse response, Object handler, Exception ex)    
            throws Exception {
    }
    public static void main(String[] args) throws UnsupportedEncodingException, IOException, Exception {
    	String test = "";//DesUtil.decrypt(URLDecoder.decode("vvklxsIN8pY%3d", "UTF-8"), key);
    	System.out.println(test);
	}
}
