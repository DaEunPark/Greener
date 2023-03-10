package com.greener.codegreen.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.greener.codegreen.dto.ProductOrderBuyerDTO;

public interface OrderService {

	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 목록 불러오기 (전체&조건지정시)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> getOrderListAll() throws Exception;

	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> getOrderList(HashMap<String, String> paramMap) throws Exception;

	//-----------------------------------------------------------------------------------------------------------
	// 주문번호 누르면 상세 주문내역 보여주기
	//-----------------------------------------------------------------------------------------------------------
	public ProductOrderBuyerDTO getOrderDetail(int orderNum) throws Exception;
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(day)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> getOrderListDay(HashMap<String, String> paramMap) throws Exception;
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(onlyDay)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> getOrderListOnlyDay(HashMap<String, String> paramMap) throws Exception;
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(week)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> getOrderListWeek(HashMap<String, String> paramMap) throws Exception;
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(onlyWeek)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> getOrderListOnlyWeek(HashMap<String, String> paramMap) throws Exception;
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(month)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> getOrderListMonth(HashMap<String, String> paramMap) throws Exception;
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(onlyMonth)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> getOrderListOnlyMonth(HashMap<String, String> paramMap) throws Exception;
	
	//-----------------------------------------------------------------------------------------------------------
	// 전체 주문 개수 불러오기
	//-----------------------------------------------------------------------------------------------------------
	public int getOrderCount() throws Exception;
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 취소하기
	//-----------------------------------------------------------------------------------------------------------
	public int setOrderCancle(int oNum) throws Exception;
				
				
	
}
