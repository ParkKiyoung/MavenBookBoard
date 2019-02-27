package org.zerock.domain;

public class Criteria {
	private int pageNum = 1;
	private int amount = 5;// 한화면에 보이는 게시물 수

	private String type;
	private String keyword;
	private String[] typeArr;

	public Criteria() {
		this(1, 10);
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
		// 반환되는 type의 형태에 따라서 배열화 시킴
		// 한글자 씩이기 때문에 한글자씩 분리해서 확인
	}

	public void setTypeArr(String[] typeArr) {
		this.typeArr = typeArr;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type == null ? "" : type.trim();
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword == null ? "" : keyword.trim();
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
