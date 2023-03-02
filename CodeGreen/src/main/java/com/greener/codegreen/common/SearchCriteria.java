package com.greener.codegreen.common;

public class SearchCriteria extends Criteria {
	private String keyword;		// 검색 키워드
	private String searchType;		// 검색 타입 ('id' = 회원아이디 , 'name' == 회원이름)
	
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
	@Override
	public String toString() {
		return "SearchCriteria [keyword=" + keyword + ", searchType=" + searchType + "]";
	}
	
	
}
