package com.greener.codegreen.common;

public class PageHandler {

	private int totalCount;		// 총 게시물 개수
	private int pageSize;		// 한 페이지의 크기
	private int naviSize = 10;	// 페이지 내비게이션의 크기
	private int totalPage;		// 전체 페이지의 개수
	private int page;			// 현재 페이지
	private int beginPage;		// 내비게이션의 첫 번째 페이지
	private int endPage;		// 내비게이션의 마지막 페이지
	private boolean showPrev;	// 이전 페이지로 이동할 것인지 여부
	private boolean showNext;	// 다음 페이지로 이동할 것인지 여부
	
	public PageHandler(int totalCount, int page) {
		this(totalCount, page, 10);
	}
	
	public PageHandler(int totalCount, int page, int pageSize) {
		this.totalCount = totalCount;
		this.page = page;
		this.pageSize = pageSize;
		
		totalPage = (int)Math.ceil(totalCount / (double)pageSize);
		beginPage = page-1 / naviSize * naviSize + 1;
		endPage = Math.min(pageSize + naviSize -1, totalPage);
		showPrev = beginPage != 1;
		showNext = endPage != totalPage;
	}
	
	void print() {
		System.out.println("page = "+page);
		System.out.print(showPrev ? "<" : "");
		for(int i=beginPage; i<=endPage; i++) {
			System.out.print(i + " ");
		}
		System.out.println(showNext ? ">":"");
	}

	@Override
	public String toString() {
		return "PageHandler [totalCount=" + totalCount + ", pageSize=" + pageSize + ", naviSize=" + naviSize
				+ ", totalPage=" + totalPage + ", page=" + page + ", beginPage=" + beginPage + ", endPage=" + endPage
				+ ", showPrev=" + showPrev + ", showNext=" + showNext + "]";
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getNaviSize() {
		return naviSize;
	}

	public void setNaviSize(int naviSize) {
		this.naviSize = naviSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isShowPrev() {
		return showPrev;
	}

	public void setShowPrev(boolean showPrev) {
		this.showPrev = showPrev;
	}

	public boolean isShowNext() {
		return showNext;
	}

	public void setShowNext(boolean showNext) {
		this.showNext = showNext;
	}
	
	
	
}




