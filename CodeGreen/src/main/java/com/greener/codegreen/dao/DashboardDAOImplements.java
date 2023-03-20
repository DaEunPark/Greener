
package com.greener.codegreen.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.greener.codegreen.dto.ProductAvgCntDTO;
import com.greener.codegreen.dto.DashBoardCategoryDTO;
import com.greener.codegreen.dto.DashboardAgeDTO;

@Repository("dashboardDAO")
public class DashboardDAOImplements implements DashboardDAO {
	private static final Logger logger = LoggerFactory.getLogger(DashboardDAOImplements.class);
	@Autowired
	private SqlSession sqlSession;
	
	private	static final String Namespace = "com.greener.codegreen.dashboard";
	/*
	* 상품 구매 개수 평균 - 박다은
	*/
	@Override
	public List<ProductAvgCntDTO> getProductAvgCntInfo(int limit) throws DataAccessException {
		List<ProductAvgCntDTO> list = sqlSession.selectList(Namespace + ".productAvgCntInfo", limit);
		return list;
	}

	// 대시보드 - 김민준
	@Override
	public List<DashboardAgeDTO> Dash() throws Exception {

		return sqlSession.selectList(Namespace+".dash");
	}

	// 대시보드 - 이정하
	
	//public List<Map<String, Object>> getChart(Map<String, Object> map) throws DataAccessException {
		// TODO Auto-generated method stub
		//return sqlSession.selectList(Namespace + ".getChart", map);
	@Override
	public DashboardAgeDTO jan22() throws DataAccessException { 	
//	public DashboardAgeDTO jan22() throws DataAccessException {
		return sqlSession.selectOne(Namespace+ ".getChart");
}
	@Override
	public DashboardAgeDTO feb22() throws DataAccessException { 	
//	public DashboardAgeDTO jan22() throws DataAccessException {
		return sqlSession.selectOne(Namespace+ ".getChart");
}
	/* -----------------------------
	 * *********** 유현지 **********
	 * -----------------------------
	 */
	//-----------------------------------------------------------------------------//
	// 쌀,잡곡 판매량 가져오기                                                     //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardCategoryDTO getGrainVolume() throws DataAccessException {
		
		logger.info("DashBoardDAO에서 getGrainMonVolume()실행..");
		
		return sqlSession.selectOne(Namespace+".grainVolume");
	}
	
	//-----------------------------------------------------------------------------//
	// 과일,견과,건과 판매량 가져오기                                              //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardCategoryDTO getFruitVolume() throws DataAccessException {
		
		logger.info("DashBoardDAO에서 getFruitVolume()실행..");
		
		return sqlSession.selectOne(Namespace+".fruitVolume");
	}

	//-----------------------------------------------------------------------------//
	// 수산, 건어물 판매량 가져오기                                                //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardCategoryDTO getFishVolume() throws DataAccessException {
		
		logger.info("DashBoardDAO에서 getFishVolume()실행..");
		
		return sqlSession.selectOne(Namespace+".fishVolume");
	}

	//-----------------------------------------------------------------------------//
	// 정육,계란류 판매량 가져오기                                                 //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardCategoryDTO getMeatVolume() throws DataAccessException {
		
		logger.info("DashBoardDAO에서 getMeatVolume()실행..");
		
		return sqlSession.selectOne(Namespace+".meatVolume");
	}

	//-----------------------------------------------------------------------------//
	// 건강식품 판매량 가져오기                                                    //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardCategoryDTO getHealthyVolume() throws DataAccessException {
		
		logger.info("DashBoardDAO에서 getHealthyVolume()실행..");
		
		return sqlSession.selectOne(Namespace+".healthyVolume");
	}

	//-----------------------------------------------------------------------------//
	// 차·음료·생수·유제품 판매량 가져오기                                         //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardCategoryDTO getWaterVolume() throws DataAccessException {
		
		logger.info("DashBoardDAO에서 getWaterVolume()실행..");
		
		return sqlSession.selectOne(Namespace+".waterVolume");
	}

	//-----------------------------------------------------------------------------//
	// 과자·간식·빵·빙과 판매량 가져오기                                           //
	//-----------------------------------------------------------------------------//
	@Override
	public DashBoardCategoryDTO getSnackVolume() throws DataAccessException {
		
		logger.info("DashBoardDAO에서 getSnackVolume()실행..");
		
		return sqlSession.selectOne(Namespace+".snackVolume");
	}

}
