package com.coding404.controller;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding404.command.FreeBoardVO;
import com.coding404.freeboard.service.FreeBoardService;
import com.coding404.util.Criteria;
import com.coding404.util.PageVO;

@Controller
@RequestMapping("/freeBoard")
public class FreeBoardController {
	
	@Autowired
	@Qualifier("freeboardService")
	private FreeBoardService freeboardService;
	
	//등록화면
	@RequestMapping("freeRegist")
	public void freeRegist() {
		
	}
	
	@RequestMapping("registForm")
	public String registForm(FreeBoardVO vo,RedirectAttributes RA) {
		
		System.out.println(vo.toString());
		boolean result =freeboardService.regist(vo);
		System.out.println(result);
		
		if(result) {
			RA.addFlashAttribute("msg","정상처리되었습니다.");
		}else {
			RA.addFlashAttribute("msg","등록에 실패하였습니다.");
		}
		
		return "redirect:/freeBoard/freeList";
	}
	
	//목록화면 
	@RequestMapping("freeList")
	public void freeList(Model mo ,Criteria cri) {
		
		//select
//		ArrayList<FreeBoardVO> list= freeboardService.getList();
//		mo.addAttribute("list", list);
			
		ArrayList<FreeBoardVO> list= freeboardService.getList(cri);		
		mo.addAttribute("list", list);
		
		//페이지네이션
		int total = freeboardService.getTotal(cri);
		PageVO pageVO = new PageVO(cri,total);
		mo.addAttribute("pageVO" ,pageVO);
		System.out.println(pageVO.toString());
	}

	//상세보기 (변경화면,상세화면은 동일한 내용을 가지고 있어서 묶어서 사용)
	@RequestMapping({"freeDetail","freeModify"})
    public void freeDetail(@RequestParam("bno") int bno, Model model) {
		FreeBoardVO vo =freeboardService.getContent(bno);
		model.addAttribute("vo", vo);
	}
	
	//수정화면
//	@RequestMapping("freeModify")
//	public void freeModify(@RequestParam("bno") int bno,
//            Model model) {
//		FreeBoardVO vo =freeboardService.getContent(bno);
//		model.addAttribute("vo", vo);
//	}
	
	//수정기능
	@RequestMapping("freeUpdate")
	public String freeUpdate(FreeBoardVO vo,RedirectAttributes RA) {
		
		boolean result = freeboardService.Update(vo);
		if(result) {
			RA.addFlashAttribute("msg","정상 수정되었습니다.");
		}else {
			RA.addFlashAttribute("msg", "수정에 실패하였습니다.");
		}
//		
//		return "redirect:/freeBoard/freeList";
		return "redirect:/freeBoard/freeDetail?bno=" + vo.getBno();
	}
	
  //삭제
  /*
   * 1.삭제버튼에서 bno값을 전달합니다.
   * 2. 요청주소 freeDelete
   * 3.삭제를 진행하고 list 화면으로 이동.
   */
	@RequestMapping("freeDelete")
	public String freeDelete(@RequestParam("bno") int bno,RedirectAttributes RA) {
		
		freeboardService.freeDelete(bno);
		return "redirect:/freeBoard/freeList";
	}
}
