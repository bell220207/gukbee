package com.coding404.freeboard.mapper;
import java.util.ArrayList;
import com.coding404.command.FreeBoardVO;
import com.coding404.util.Criteria;

public interface FreeBoardMapper {
	
	public boolean regist(FreeBoardVO vo);
	public ArrayList<FreeBoardVO> getList(Criteria cri);
	public int getTotal(Criteria cri);

	public FreeBoardVO getContent(int bno);
	public boolean Update(FreeBoardVO vo);
	public void freeDelete(int bno);
}
