package com.greener.codegreen.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.greener.codegreen.dto.DashBoardDTO;

@Repository("dashBoardDAO")
public class DashBoardImpl implements DashBoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(DashBoardImpl.class);
	
	private	static final String Namespace = "com.greener.codegreen.dashBoard";

	//-----------------------------------------------------------------------------//
	// 쌀,잡곡 판매량 가져오기                                                     //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardDTO getGrainVolume() throws DataAccessException {
		
		logger.info("DashBoardDAO에서 getGrainMonVolume()실행..");
		
		return sqlSession.selectOne(Namespace+".grainVolume");
	}
	
	//-----------------------------------------------------------------------------//
	// 과일,견과,건과 판매량 가져오기                                              //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardDTO getFruitVolume() throws DataAccessException {
		
		logger.info("DashBoardDAO에서 getFruitVolume()실행..");
		
		return sqlSession.selectOne(Namespace+".fruitVolume");
	}

	//-----------------------------------------------------------------------------//
	// 수산, 건어물 판매량 가져오기                                                //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardDTO getFishVolume() throws DataAccessException {
		
		logger.info("DashBoardDAO에서 getFishVolume()실행..");
		
		return sqlSession.selectOne(Namespace+".fishVolume");
	}

	//-----------------------------------------------------------------------------//
	// 정육,계란류 판매량 가져오기                                                 //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardDTO getMeatVolume() throws DataAccessException {
		
		logger.info("DashBoardDAO에서 getMeatVolume()실행..");
		
		return sqlSession.selectOne(Namespace+".meatVolume");
	}

	//-----------------------------------------------------------------------------//
	// 건강식품 판매량 가져오기                                                    //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardDTO getHealthyVolume() throws DataAccessException {
		
		logger.info("DashBoardDAO에서 getHealthyVolume()실행..");
		
		return sqlSession.selectOne(Namespace+".healthyVolume");
	}

	//-----------------------------------------------------------------------------//
	// 차·음료·생수·유제품 판매량 가져오기                                         //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardDTO getWaterVolume() throws DataAccessException {
		
		logger.info("DashBoardDAO에서 getWaterVolume()실행..");
		
		return sqlSession.selectOne(Namespace+".waterVolume");
	}

	//-----------------------------------------------------------------------------//
	// 과자·간식·빵·빙과 판매량 가져오기                                           //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardDTO getSnackVolume() throws DataAccessException {
		
		logger.info("DashBoardDAO에서 getSnackVolume()실행..");
		
		return sqlSession.selectOne(Namespace+".snackVolume");
	}

}
