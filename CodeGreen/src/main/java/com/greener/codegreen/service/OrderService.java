package com.greener.codegreen.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.greener.codegreen.common.SearchCriteria;
import com.greener.codegreen.dto.ProductOrderBuyerDTO;

public interface OrderService {

	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 목록 불러오기 (전체 주문)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> getOrderListAll(SearchCriteria scri) throws DataAccessException;

	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> getOrderList(SearchCriteria scri) throws DataAccessException;
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(onlyDay)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> getOrderListOnlyDay(SearchCriteria scri) throws DataAccessException;

	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(onlyWeek)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> getOrderListOnlyWeek(SearchCriteria scri) throws DataAccessException;
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(onlyMonth)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> getOrderListOnlyMonth(SearchCriteria scri) throws DataAccessException;
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotal)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotal(SearchCriteria scri) throws DataAccessException;
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalTwo)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalTwo(SearchCriteria scri) throws DataAccessException;
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문번호 누르면 상세 주문내역 보여주기
	//-----------------------------------------------------------------------------------------------------------
	public ProductOrderBuyerDTO getOrderDetail(int orderNum) throws DataAccessException;
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 취소하기
	//-----------------------------------------------------------------------------------------------------------
	public int setOrderCancle(int oNum) throws DataAccessException;
	
		
}










