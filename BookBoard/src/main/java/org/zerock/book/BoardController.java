package org.zerock.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private PageDTO page;
	@Autowired
	private BoardService service;
	
	//추가폼
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board,RedirectAttributes rttr) {
		//RedirectAttributes은 1회성으로만 전송하는 값
		service.register(board);
		rttr.addFlashAttribute("result",board.getBno());
		//result 값에 글번호가 붙어져서옴
		return "redirect:/board/list";
		//list에 result 값을 한번만 줌. F5번 계속 눌러도 안나옴
	}
	
	//전체보기
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		logger.info("리스트  ..");
		
		int total = service.getTotalCount(cri);
		page.paging(cri,total);
		model.addAttribute("list",service.getList(cri));
		model.addAttribute("total",total);
		model.addAttribute("pageMaker",page);
		
	}
	
	
	
	//상세보기  , 수정
	@GetMapping({"/get","/modify"})
	//두번써야할때는 위처럼 묶으면 됨
	public void get(Model model, Long bno,Criteria cri) {
		logger.info("상세보기");
		
		BoardVO board = service.get(bno);
		model.addAttribute("board",board);
		model.addAttribute("cri",cri);
		
	}
	@PostMapping("/remove")
	public String remove(Long bno,Model model, RedirectAttributes rttr) {
		logger.info("삭제명령");
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	@PostMapping("/modify")
	public String modify(BoardVO board, Model model, RedirectAttributes rttr) {
		logger.info("수정명령");
		
		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
		
	}
	
}
