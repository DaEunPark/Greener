package com.greener.codegreen.common;


public class PageMaker {
	private Criteria cri;
	private int totalCount;		// 총 소비자의 수
	private int startPage;			// 첫 시작 페이지
	private int endPage;			// 마지막 페이지
	private boolean prev;			// 이전
	private boolean next;			// 다음
	private int viewPageNum = 10;	// 하단에 보여줄 페이지의 개수
	
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calculratePage();
	}
	public void calculratePage() {
		endPage = (int)(Math.ceil(cri.getPage()/(double)viewPageNum)*viewPageNum);
		
		startPage = (endPage-viewPageNum)+1;
		
		if(startPage <= viewPageNum) {
			startPage = 1;
		}
		if(startPage <=0) {
			startPage =1;
		}
		
		int realEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		if(endPage > realEndPage) {
			endPage = realEndPage;
		}
		
		prev = startPage == 1 ? false: true;
		next = endPage * cri.getPerPageNum() < totalCount ? true:false; 
		
		
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getViewPageNum() {
		return viewPageNum;
	}
	public void setViewPageNum(int viewPageNum) {
		this.viewPageNum = viewPageNum;
	}
	
	
	
}
