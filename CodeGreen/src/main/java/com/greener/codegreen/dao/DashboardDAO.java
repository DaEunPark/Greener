package com.greener.codegreen.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;

import com.greener.codegreen.dto.ProductAvgCntDTO;
import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.DashboardDTO;

public interface DashboardDAO {
	/*
	 * 구매 상품 주문 수량 평균 - 박다은
	 */
	List<ProductAvgCntDTO> getProductAvgCntInfo(int limit) throws DataAccessException;
  
	// 대시보드 - 김민준
	public List<DashboardDTO>Dash() throws Exception;

	// 대시보드 - 이정하
	List<Map<String, Object>> getChart(Map<String, Object> map) throws DataAccessException;

}
