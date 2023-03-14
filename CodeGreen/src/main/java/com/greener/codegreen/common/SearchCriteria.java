package com.greener.codegreen.common;

public class SearchCriteria extends Criteria {
	private String keyword;		// 검색 키워드
	private String searchType;	// 검색 타입 ('id' = 회원아이디 , 'name' == 회원이름)
	private String orderNum;	// 주문 번호	
	private String buyerName;	// 주문자 이름
	private String productNum;	// 상품 번호
	private String period0;		// 하루 주문건
	private String period1;		// 일주일 주문건
	private String period2;		// 한달 주문건
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getProductNum() {
		return productNum;
	}
	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}
	public String getPeriod0() {
		return period0;
	}
	public void setPeriod0(String period0) {
		this.period0 = period0;
	}
	public String getPeriod1() {
		return period1;
	}
	public void setPeriod1(String period1) {
		this.period1 = period1;
	}
	public String getPeriod2() {
		return period2;
	}
	public void setPeriod2(String period2) {
		this.period2 = period2;
	}
	@Override
	public String toString() {
		return "SearchCriteria [keyword=" + keyword + ", searchType=" + searchType + ", orderNum=" + orderNum
				+ ", buyerName=" + buyerName + ", productNum=" + productNum + ", period0=" + period0 + ", period1="
				+ period1 + ", period2=" + period2 + "]";
	}
	
	
}
