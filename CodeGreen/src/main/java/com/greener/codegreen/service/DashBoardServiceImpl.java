package com.greener.codegreen.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.greener.codegreen.dao.DashBoardDAO;
import com.greener.codegreen.dto.DashBoardDTO;

@Service("dashBoardService")
public class DashBoardServiceImpl implements DashBoardService {
	
	@Autowired
	DashBoardDAO dashBoardDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(DashBoardServiceImpl.class);

	//-----------------------------------------------------------------------------//
	// 쌀,잡곡 판매량 가져오기(월)                                                 //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardDTO getGrain() throws DataAccessException {
		
		logger.info("DashBoardService에서 getGrainMon()...");
		
		return dashBoardDAO.getGrainVolume();
	}

	//-----------------------------------------------------------------------------//
	// 과일,견과,건과 판매량 가져오기                                              //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardDTO getFruit() throws DataAccessException {
		
		logger.info("DashBoardService에서 getFruit()...");
		
		return dashBoardDAO.getFruitVolume();
	}
	
	//-----------------------------------------------------------------------------//
	// 수산, 건어물 판매량 가져오기                                                //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardDTO getFish() throws DataAccessException {
		
		logger.info("DashBoardService에서 getFish()...");
		
		return dashBoardDAO.getFishVolume();
	}

	//-----------------------------------------------------------------------------//
	// 정육,계란류 판매량 가져오기                                                 //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardDTO getMeat() throws DataAccessException {
		
		logger.info("DashBoardService에서 getMeat()...");
		
		return dashBoardDAO.getMeatVolume();
	}

	//-----------------------------------------------------------------------------//
	// 건강식품 판매량 가져오기                                                    //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardDTO getHealthy() throws DataAccessException {
		
		logger.info("DashBoardService에서 getHealthy()...");
		
		return dashBoardDAO.getHealthyVolume();
	}

	//-----------------------------------------------------------------------------//
	// 차·음료·생수·유제품 판매량 가져오기                                         //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardDTO getWater() throws DataAccessException {
		
		logger.info("DashBoardService에서 getWater()...");
		
		return dashBoardDAO.getWaterVolume();
	}

	//-----------------------------------------------------------------------------//
	// 과자·간식·빵·빙과 판매량 가져오기                                           //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardDTO getSnack() throws DataAccessException {
		
		logger.info("DashBoardService에서 getSnack()...");
		
		return dashBoardDAO.getSnackVolume();
	}

}
