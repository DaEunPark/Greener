package com.greener.codegreen.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;


@Repository("dashBoardDAO")
public class DashBoardDAOImpl implements DashBoardDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(BuyerDAOImpl.class);
	@Autowired
	private SqlSession sqlSession;
	
	private	static final String Namespace = "com.greener.codegreen.dashBoard";
	
	//-----------------------------------------------------------------------------------------------------------
    // 월별 가입자수 차트 (정하)
	//-----------------------------------------------------------------------------------------------------------
	public List<Map<String, Object>> getChart(Map<String, Object> map)  throws DataAccessException{
		return sqlSession.selectList(Namespace + ".getChart", map);
		//}
	}
}
