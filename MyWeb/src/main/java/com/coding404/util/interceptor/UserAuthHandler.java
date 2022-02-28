package com.coding404.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.coding404.command.UsersVO;

public class UserAuthHandler implements HandlerInterceptor {
	//요청을 가로채 검사하는 인터샙터 클래스
	
	
	//1.컨트롤러 이전에 요청을 가로챔
	//2.bean으로 생성하고,가로챌  경로를 추가.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session	=request.getSession();
	
	    UsersVO vo =(UsersVO)session.getAttribute("users");
	
	    String query = request.getQueryString();
		System.out.println(query);
		String uri = request.getRequestURI();
		System.out.println(uri);
	   
	   if(vo == null) { //로그인이 안된시점
		   response.sendRedirect(request.getContextPath()+"/user/userLogin"); //절대경로
		   return false;
	   }

		return true;
	}
}
