package com.coding404.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.coding404.command.UsersVO;
import com.coding404.users.service.UsersService;

@Controller
@RequestMapping("/user")
public class UsersController {
	
	
	@Autowired
    private UsersService usersService;
	
	
	@RequestMapping("/userJoin")
	public void userJoin() {
	}
	
	@RequestMapping("/userLogin")
	public void userLogin() {
		
	}
	
	@RequestMapping("/userMypage")
	public String userMypage(/* HttpSession session */) {
		/*
		 * if(session.getAttribute("users") == null) { //.....로그인화면으로.... return
		 * "redirect:/user/userLogin"; } return "user/userMypage";
		 */
		
	return "user/userMypage";
	}
	
	//일반적인 방식이 아님 pom.xml에 jackson-databind추가
	//@RequestBody -> 비동기로 넘어오는 data를 vo에 맵핑할 때 사용
	//@ResponseBody -> 호출한 곳으로 데이터를 반환 하겠다.
	//찜목록, 장바구니에 사용
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("/idCheck") public int idCheck(@RequestBody UsersVO vo) {
	 * 
	 * int result=usersService.idCheck(vo);
	 * 
	 * 
	 * 
	 * return result; }
	 */
	// @ REQUESTBODY 요청 바디에 들어있는 JSON데이터를 USERVO에 매핑시켜라는 어노테이션
	// @ResponseBody 리턴데이터가 뷰리졸버가 아니라 호출한 곳(JSP의 버튼)으로 보내준다. SUCCESS함수의 첫 번쨰 매개변수로~
	@ResponseBody 
	@RequestMapping("/idCheck")
	public ResponseEntity<Integer> idCheck(@RequestBody UsersVO vo) {
		
		int result=usersService.idCheck(vo);
		
		ResponseEntity<Integer> entity = null;
		try {
			//첫번째 매개변수:데이터정보,HttpHeader정보(기본형) , Http상태정보
			HttpHeaders header= new HttpHeaders();
			header.add("Content-type", "application/json");
			entity =new ResponseEntity<Integer>(result,header, HttpStatus.OK);
			
		} catch (Exception e) { }
	
		return entity; 
	}
	
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public String signUp(UsersVO vo) {
		
		boolean result =usersService.signUp(vo);
	    
		if(result) {
			return "redirect:/user/userLogin";
		}else {
			return "rediect:/user/userJoin";
		}
	}
	
//	@RequestMapping(value="login", method=RequestMethod.POST)
//	public ModelAndView login(UsersVO vo,HttpSession session) {
//		
//		UsersVO users =usersService.login(vo);
//		
//		ModelAndView mv = new ModelAndView();
//		
//	   System.out.println(users);
//	   mv.setViewName("user/userLogin");
//	   if(users == null) {
//	   
//		   mv.addObject("msg","아이디 비밀번호를 확인하세요");
//		   
//	   }else {
//		  
//		   session.setAttribute("users", users);//세션의 유저정보 저장
//		   mv.addObject("msg","로그인 성공");
//		   
//		   
//	   }
//		 System.out.println(1);
//		return mv;
//	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView login(UsersVO vo,HttpSession session) {
		
		UsersVO users =usersService.login(vo);
		ModelAndView mv = new ModelAndView();
		
		System.out.println(users);
		mv.setViewName("user/userLogin");
		if(users == null) {
		   mv.addObject("msg","아이디 비밀번호를 확인하세요");
	   }else {
		  mv.addObject("users",users); //mv에 user객체를 저장하고 핸들러에서 처리
	   }
		
		System.out.println(1);
		return mv;
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
