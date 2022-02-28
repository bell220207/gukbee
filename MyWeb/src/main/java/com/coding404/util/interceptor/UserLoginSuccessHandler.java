package com.coding404.util.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.coding404.command.UsersVO;

public class UserLoginSuccessHandler implements HandlerInterceptor {
  //1. 로그인 성공 핸들러 
	//로그인 성공 시 세션을 만들고, 리다이렉트를 통한 페이지 이동
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	             
//	       Map<String,Object> map=      modelAndView.getModel();
//	       
//	       String msg = (String)map.get("msg");
//	       System.out.println(msg);
//	       System.out.println("로그인 포스트핸들러");
		//mv에 담겨있는 users객체를 세션에 저장
		
		 
	     ModelMap mv=modelAndView.getModelMap();
	   UsersVO users = (UsersVO)mv.get("users"); //컨트롤러에서 넘겨받은 유저객체
	     
		if(users != null) {
			 HttpSession session=  request.getSession();
			session.setAttribute("users", users);
			
			response.sendRedirect(request.getContextPath()+"/");
					
		}
	}
}
