package com.greener.codegreen.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.greener.codegreen.common.Criteria;
import com.greener.codegreen.common.SearchCriteria;
import com.greener.codegreen.dto.ProductOrderBuyerDTO;

public interface OrderDAO {
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 목록 불러오기 (전체 주문)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> orderListAll(SearchCriteria scri) throws DataAccessException;

	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> orderList(SearchCriteria scri) throws DataAccessException;
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(onlyDay)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> orderListOnlyDay(SearchCriteria scri) throws DataAccessException;

	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(onlyWeek)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> orderListOnlyWeek(SearchCriteria scri) throws DataAccessException;
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(onlyMonth)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> orderListOnlyMonth(SearchCriteria scri) throws DataAccessException;
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalNum)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalNum(SearchCriteria scri) throws DataAccessException;
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalNumTwo)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalNumTwo(SearchCriteria scri) throws DataAccessException;
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문번호 누르면 상세 주문내역 보여주기
	//-----------------------------------------------------------------------------------------------------------
	public ProductOrderBuyerDTO orderDetail(int orderNum) throws DataAccessException;
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 취소하기
	//-----------------------------------------------------------------------------------------------------------
	public int orderListCancle(int oNum) throws DataAccessException;
	
	
}
