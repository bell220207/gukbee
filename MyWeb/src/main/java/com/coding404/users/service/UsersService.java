package com.coding404.users.service;
import com.coding404.command.UsersVO;

public interface UsersService {

	  public int idCheck(UsersVO vo);
	  public boolean signUp(UsersVO vo);
	  public UsersVO login(UsersVO vo);
}
