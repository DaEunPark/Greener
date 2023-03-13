package com.greener.codegreen.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.greener.codegreen.dto.ProductAvgCntDTO;

public interface DashboardService {

	/*
	 * 구매 상품 주문 수량 평균
	 */
	List<ProductAvgCntDTO> getProductAvgCntInfo(int limit) throws DataAccessException;

}
