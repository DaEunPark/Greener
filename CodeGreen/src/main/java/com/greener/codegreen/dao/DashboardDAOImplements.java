
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
	@Override
	public List<Map<String, Object>> getChart(Map<String, Object> map) throws DataAccessException {
		// TODO Auto-generated method stub
		return sqlSession.selectList(Namespace + ".getChart", map);
	}
}
