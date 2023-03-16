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
	private String state0;		// 결제완료
	private String state1;		// 배송준비
	private String state2;		// 배송중
	private String state3;		// 배송완료
	private String dateAsc;		// 주문일자(오름차순)
	private String dateDes;		// 주문일자(내림차순)
	private String priceAsc;	// 결제금액순(내림차순)
	private String priceDes;	// 결제금액순(내림차순)
	
	
	public String getDateAsc() {
		return dateAsc;
	}
	public void setDateAsc(String dateAsc) {
		this.dateAsc = dateAsc;
	}
	public String getDateDes() {
		return dateDes;
	}
	public void setDateDes(String dateDes) {
		this.dateDes = dateDes;
	}
	public String getPriceAsc() {
		return priceAsc;
	}
	public void setPriceAsc(String priceAsc) {
		this.priceAsc = priceAsc;
	}
	public String getPriceDes() {
		return priceDes;
	}
	public void setPriceDes(String priceDes) {
		this.priceDes = priceDes;
	}
	public String getState0() {
		return state0;
	}
	public void setState0(String state0) {
		this.state0 = state0;
	}
	public String getState1() {
		return state1;
	}
	public void setState1(String state1) {
		this.state1 = state1;
	}
	public String getState2() {
		return state2;
	}
	public void setState2(String state2) {
		this.state2 = state2;
	}
	public String getState3() {
		return state3;
	}
	public void setState3(String state3) {
		this.state3 = state3;
	}
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
