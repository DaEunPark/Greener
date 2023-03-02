package com.greener.codegreen.dao;

import java.util.List;

import com.greener.codegreen.common.SearchCriteria;
import com.greener.codegreen.dto.SellerDTO;

public interface SellerDAO {
	//------------------------------------------------------------------------------------------------------------
	// 판매자 리스트 조회
	//------------------------------------------------------------------------------------------------------------
	public List<SellerDTO> sellerList(SearchCriteria scri) throws Exception;


	//------------------------------------------------------------------------------------------------------------
	// 판매자 회원 수 조회
	//------------------------------------------------------------------------------------------------------------
	public int totalCount(SearchCriteria scri) throws Exception;
}
