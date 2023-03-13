package com.greener.codegreen.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.greener.codegreen.dto.ProductAvgCntDTO;

@Repository("dashboardDAO")
public class DashboardDAOImpl implements DashboardDAO {
	private static final Logger logger = LoggerFactory.getLogger(DashboardDAOImpl.class);
	@Autowired
	private SqlSession sqlSession;
	
	private	static final String Namespace = "com.greener.codegreen.dashboard";
	@Override
	public List<ProductAvgCntDTO> getProductAvgCntInfo(int limit) throws DataAccessException {
		List<ProductAvgCntDTO> list = sqlSession.selectList(Namespace + ".productAvgCntInfo", limit);
		return null;
	}

}
