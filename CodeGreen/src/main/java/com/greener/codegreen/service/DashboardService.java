
package com.greener.codegreen.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;

import com.greener.codegreen.dto.ProductAvgCntDTO;
import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.DashBoardCategoryDTO;
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
	//List<Map<String, Object>> getChart(Map<String, Object> map) throws DataAccessException;
	public DashboardAgeDTO jan22() throws DataAccessException ;
	public DashboardAgeDTO feb22() throws DataAccessException ;
	/* -----------------------------
	 * *********** 유현지 **********
	 * -----------------------------
	 */
	//-----------------------------------------------------------------------------//
	// 쌀,잡곡 판매량 가져오기 //
	// -----------------------------------------------------------------------------//
	public DashBoardCategoryDTO getGrain() throws DataAccessException;

	// -----------------------------------------------------------------------------//
	// 과일,견과,건과 판매량 가져오기 //
	// -----------------------------------------------------------------------------//
	public DashBoardCategoryDTO getFruit() throws DataAccessException;

	// -----------------------------------------------------------------------------//
	// 수산, 건어물 판매량 가져오기 //
	// -----------------------------------------------------------------------------//
	public DashBoardCategoryDTO getFish() throws DataAccessException;

	// -----------------------------------------------------------------------------//
	// 정육,계란류 판매량 가져오기 //
	// -----------------------------------------------------------------------------//
	public DashBoardCategoryDTO getMeat() throws DataAccessException;

	// -----------------------------------------------------------------------------//
	// 건강식품 판매량 가져오기 //
	// -----------------------------------------------------------------------------//
	public DashBoardCategoryDTO getHealthy() throws DataAccessException;

	// -----------------------------------------------------------------------------//
	// 차·음료·생수·유제품 판매량 가져오기 //
	// -----------------------------------------------------------------------------//
	public DashBoardCategoryDTO getWater() throws DataAccessException;

	// -----------------------------------------------------------------------------//
	// 과자·간식·빵·빙과 판매량 가져오기 //
	// -----------------------------------------------------------------------------//
	public DashBoardCategoryDTO getSnack() throws DataAccessException;
}

