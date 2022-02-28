package com.coding404.users.service;

import java.util.Base64;
import java.util.Base64.Encoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.coding404.command.UsersVO;
import com.coding404.users.mapper.UsersMapper;

@Service("usersService")
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersMapper usersMapper;

	@Override
	public int idCheck(UsersVO vo) {
	
		return usersMapper.idCheck(vo);
	}

	@Override
	public boolean signUp(UsersVO vo) {
	
		//암호화->단방향 암호화 spring security 
	Encoder encoder=Base64.getEncoder();
	
	byte[] result=encoder.encode(vo.getPw().getBytes());//byte[]형태로 암호화데이터를 전달
	vo.setPw(new String(result));
		  
		return  usersMapper.signUp(vo);
	}

	@Override
	public UsersVO login(UsersVO vo) {
		Encoder encoder=Base64.getEncoder();
		
		byte[] result=encoder.encode(vo.getPw().getBytes());//byte[]형태로 암호화데이터를 전달
		vo.setPw(new String(result));
		return usersMapper.login(vo);
	}

}
