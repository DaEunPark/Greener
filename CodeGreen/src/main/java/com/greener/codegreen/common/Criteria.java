package com.greener.codegreen.common;

public class Criteria {
	private int page;					// 현재 페이지 번호
	private int perPageNum;	// 페이지당 보여줄 소비자 목록의 개수
	
	public Criteria() {
		this.page = 1;						// 시작시 페이지 번호를 1로 고정
		this.perPageNum = 20;		// 페이지당 보여줄 소비자 목록의 개수를 설정한다.
	} // end - public Criteria()

	public int getPage() {
		return page;
	}

	public void setPage(int page) { // 시작 페이지에 0이나 음수가 오면 안되므로 if문을 써서 1로 고정을 해준다.
		if(page<=0) {
			this.page = 1;
		}else { // 아닐경우 그 값을 그대로 받아온다.
		this.page = page;
		}
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) { 
		this.perPageNum = perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
	
	
}
