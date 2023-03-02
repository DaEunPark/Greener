package com.greener.codegreen.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.greener.codegreen.dto.ProductOrderBuyerDTO;

public interface OrderDAO {
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 목록 불러오기 (전체&조건지정시)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> orderListAll() throws DataAccessException;

	//----------------------------------------------------------------------------------//
	// 조건에 맞는 주문내역 목록 불러오기
	//----------------------------------------------------------------------------------//
	public List<HashMap<String, String>> orderList(HashMap<String, String> paramMap) throws DataAccessException;

	//-----------------------------------------------------------------------------------------------------------
	// 주문번호 누르면 상세 주문내역 보여주기
	//-----------------------------------------------------------------------------------------------------------
	public ProductOrderBuyerDTO orderDetail(int orderNum) throws DataAccessException;
}
