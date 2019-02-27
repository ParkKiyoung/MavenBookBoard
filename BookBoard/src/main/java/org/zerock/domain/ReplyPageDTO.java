package org.zerock.domain;

import java.util.List;

public class ReplyPageDTO {
	private List<ReplyVO> list;
	private int replyCnt;
	
	
	public ReplyPageDTO(int replyCnt, List<ReplyVO> list) {
	this.list=list;
	this.replyCnt=replyCnt;
	}
	
	public List<ReplyVO> getList() {
		return list;
	}
	public void setList(List<ReplyVO> list) {
		this.list = list;
	}
	public int getReplyCnt() {
		return replyCnt;
	}
	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}
	
	

}
