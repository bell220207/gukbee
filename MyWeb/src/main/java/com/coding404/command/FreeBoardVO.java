package com.coding404.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data //게터세터투스트링 생성해줌
@AllArgsConstructor //멤버변수를 받는 생성자
@NoArgsConstructor//기본생성자
public class FreeBoardVO {
	
	private int bno;
	private String title;
	private String writer;
	private String content;
	private Timestamp regdate;
	private Timestamp updatedate;
 
	

}


