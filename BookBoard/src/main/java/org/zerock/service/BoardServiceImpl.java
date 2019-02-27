package org.zerock.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.book.HomeController;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	@Autowired
	private BoardMapper mapper;
	@Override
	public void register(BoardVO board) {
		
		logger.info("log....추가");
		
//		mapper.insert(board);
		mapper.insertSelectKey(board);
		System.out.println("추가");
	}

	@Override
	public BoardVO get(Long bno) {
		BoardVO board = mapper.get(bno);
		
		return board;
	}

	@Override
	public boolean modify(BoardVO board) {
		
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) {
		
		return mapper.delete(bno)==1;
	}

	@Override
	public List<BoardVO> getList() {
		List<BoardVO> list = mapper.getList();
		return list;
	}

	@Override
	public int getTotal() {
		int total = mapper.getTotal();
		return total;
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		List<BoardVO> list = mapper.getListWithPaging(cri);
		return list;
	}

	@Override
	public int getTotalCount(Criteria cri) {
		 int total = mapper.getTotalCount(cri);
		return total;
	}

}
