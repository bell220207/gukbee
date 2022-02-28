package com.coding404.freeboard.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding404.command.FreeBoardVO;
import com.coding404.freeboard.mapper.FreeBoardMapper;
import com.coding404.util.Criteria;

@Service("freeboardService")
public class FreeBoardServiceImpl implements FreeBoardService{
	
	@Autowired
	private FreeBoardMapper freeBoardMapper;

	@Override
	public boolean regist(FreeBoardVO vo) {
		return freeBoardMapper.regist(vo);
	}

	@Override
	public ArrayList<FreeBoardVO> getList(Criteria cri) {
		return freeBoardMapper.getList(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		return freeBoardMapper.getTotal(cri);
	}


	@Override
	public FreeBoardVO getContent(int bno) {
		return freeBoardMapper.getContent(bno);
	}

	@Override
	public boolean Update(FreeBoardVO vo) {
		return freeBoardMapper.Update(vo);
	}

	@Override
	public void freeDelete(int bno) {
		 freeBoardMapper.freeDelete(bno);
	}

}
