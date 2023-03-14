package com.greener.codegreen.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.greener.codegreen.dao.DashboardDAO;
import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.DashBoardCategoryDTO;
import com.greener.codegreen.dto.DashboardAgeDTO;
import com.greener.codegreen.dto.ProductAvgCntDTO;

@Service("dashboardService")
public class DashBoardServiceImplements implements DashboardService {
	
	@Inject
	private DashboardDAO dashboarddao;
	private static final Logger logger = LoggerFactory.getLogger(DashBoardServiceImplements.class);

	// 대시보드 - 민준
	@Override
	public List<DashboardAgeDTO> Dash() throws Exception {
		
		return dashboarddao.Dash();
	}
	
	// 대시보드 - 다은
	@Override
	public List<ProductAvgCntDTO> getProductAvgCntInfo(int limit) throws DataAccessException {
		// TODO Auto-generated method stub
		return dashboarddao.getProductAvgCntInfo(limit);
	}

	// 대시보드 - 정하
	@Override
	public List<Map<String, Object>> getChart(Map<String, Object> map) throws DataAccessException {
		// TODO Auto-generated method stub
		return dashboarddao.getChart(map);
	}

	/* -----------------------------
	 * *********** 유현지 **********
	 * -----------------------------
	 */
	//-----------------------------------------------------------------------------//
	// 쌀,잡곡 판매량 가져오기(월)                                                 //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardCategoryDTO getGrain() throws DataAccessException {
		
		logger.info("DashBoardService에서 getGrainMon()...");
		
		return dashboarddao.getGrainVolume();
	}

	//-----------------------------------------------------------------------------//
	// 과일,견과,건과 판매량 가져오기                                              //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardCategoryDTO getFruit() throws DataAccessException {
		
		logger.info("DashBoardService에서 getFruit()...");
		
		return dashboarddao.getFruitVolume();
	}
	
	//-----------------------------------------------------------------------------//
	// 수산, 건어물 판매량 가져오기                                                //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardCategoryDTO getFish() throws DataAccessException {
		
		logger.info("DashBoardService에서 getFish()...");
		
		return dashboarddao.getFishVolume();
	}

	//-----------------------------------------------------------------------------//
	// 정육,계란류 판매량 가져오기                                                 //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardCategoryDTO getMeat() throws DataAccessException {
		
		logger.info("DashBoardService에서 getMeat()...");
		
		return dashboarddao.getMeatVolume();
	}

	//-----------------------------------------------------------------------------//
	// 건강식품 판매량 가져오기                                                    //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardCategoryDTO getHealthy() throws DataAccessException {
		
		logger.info("DashBoardService에서 getHealthy()...");
		
		return dashboarddao.getHealthyVolume();
	}

	//-----------------------------------------------------------------------------//
	// 차·음료·생수·유제품 판매량 가져오기                                         //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardCategoryDTO getWater() throws DataAccessException {
		
		logger.info("DashBoardService에서 getWater()...");
		
		return dashboarddao.getWaterVolume();
	}

	//-----------------------------------------------------------------------------//
	// 과자·간식·빵·빙과 판매량 가져오기                                           //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardCategoryDTO getSnack() throws DataAccessException {
		
		logger.info("DashBoardService에서 getSnack()...");
		
		return dashboarddao.getSnackVolume();
	}

}
