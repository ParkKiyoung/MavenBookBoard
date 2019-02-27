package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {
	
	public void register(BoardVO board);//등록
	
	public BoardVO get(Long bno);//상세보기
	
	public boolean modify(BoardVO board);//수정
	
	public boolean remove(Long bno);//삭제
	
	public List<BoardVO> getList();//전체보기
	

	
	public int getTotal();//개수
	
	//검색 포함 리스트, 게시물 수 
	public List<BoardVO> getList(Criteria cri);
	public int getTotalCount(Criteria cri);

}
