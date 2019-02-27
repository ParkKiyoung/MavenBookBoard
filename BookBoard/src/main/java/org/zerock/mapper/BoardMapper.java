package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {

	public void insert(BoardVO board);

	public Integer insertSelectKey(BoardVO board);

	public List<BoardVO> getList();
	
	

	public int getTotal();

	public BoardVO get(Long bno);

	public BoardVO read(Long bno);

	public int delete(Long bno);

	public int update(BoardVO board);

	//검색포함
	public List<BoardVO> getListWithPaging(Criteria cri);
	public int getTotalCount(Criteria cri);

	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
		// 값이 두개 이상 들어갈때는 Param으로 잡아줘야함
		
	

	

}
