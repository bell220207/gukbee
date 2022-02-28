package com.coding404.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersVO {

	private String id;
	private String pw;
	private String name;
	private String email1;
	private String email2;
	private String addrZipNum;
	private String addrBasic;
	private String addrDetail;
	private Timestamp regdate;
	
}
