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
	
	//�߰���
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board,RedirectAttributes rttr) {
		//RedirectAttributes�� 1ȸ�����θ� �����ϴ� ��
		service.register(board);
		rttr.addFlashAttribute("result",board.getBno());
		//result ���� �۹�ȣ�� �پ�������
		return "redirect:/board/list";
		//list�� result ���� �ѹ��� ��. F5�� ��� ������ �ȳ���
	}
	
	//��ü����
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		logger.info("����Ʈ  ..");
		
		int total = service.getTotalCount(cri);
		page.paging(cri,total);
		model.addAttribute("list",service.getList(cri));
		model.addAttribute("total",total);
		model.addAttribute("pageMaker",page);
		
	}
	
	
	
	//�󼼺���  , ����
	@GetMapping({"/get","/modify"})
	//�ι�����Ҷ��� ��ó�� ������ ��
	public void get(Model model, Long bno,Criteria cri) {
		logger.info("�󼼺���");
		
		BoardVO board = service.get(bno);
		model.addAttribute("board",board);
		model.addAttribute("cri",cri);
		
	}
	@PostMapping("/remove")
	public String remove(Long bno,Model model, RedirectAttributes rttr) {
		logger.info("�������");
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	@PostMapping("/modify")
	public String modify(BoardVO board, Model model, RedirectAttributes rttr) {
		logger.info("�������");
		
		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
		
	}
	
}
