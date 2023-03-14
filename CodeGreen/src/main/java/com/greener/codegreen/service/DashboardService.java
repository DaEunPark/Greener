
package com.greener.codegreen.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;

import com.greener.codegreen.dto.ProductAvgCntDTO;
import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.DashboardAgeDTO;

public interface DashboardService {

	/*
	 * 구매 상품 주문 수량 평균
	 */
	List<ProductAvgCntDTO> getProductAvgCntInfo(int limit) throws DataAccessException;
  
	// 대시보드 - 김민준
	public List<DashboardAgeDTO> Dash() throws Exception;
	
	//-----------------------------------------------------------------------------------------------------------
	// 월별 가입자수 차트 (정하)
	//-----------------------------------------------------------------------------------------------------------
	List<Map<String, Object>> getChart(Map<String, Object> map) throws DataAccessException;
}

