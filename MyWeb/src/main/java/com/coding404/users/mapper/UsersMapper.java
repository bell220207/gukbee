package com.coding404.users.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.coding404.command.UsersVO;

public interface UsersMapper {
	
	 public int idCheck(UsersVO vo);
	 public boolean signUp(UsersVO vo);
	 public UsersVO login(UsersVO vo);
}
