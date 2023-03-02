package com.greener.codegreen.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.greener.codegreen.common.SearchCriteria;
import com.greener.codegreen.dto.BuyerDTO;

//-----------------------------------------------------------------------------------------------------------
//회원 정보 서비스
//-----------------------------------------------------------------------------------------------------------
@Repository("buyerDAO")
public class BuyerDAOImpl implements BuyerDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final Logger logger 
			= LoggerFactory.getLogger(BuyerDAOImpl.class);
	
	private	static final String Namespace = "com.greener.codegreen";
	
	
	@Override
	public BuyerDTO loginByIdPwd(BuyerDTO buyerDTO) throws DataAccessException {
		BuyerDTO buyDTO = sqlSession.selectOne(Namespace + ".loginByIdPwd", buyerDTO);
		return buyDTO;
	}

	@Override
	public int addBuyer(BuyerDTO buyerDTO) throws DataAccessException {
		logger.info("*** addUser ***");
		int result = sqlSession.insert(Namespace + ".addBuyer", buyerDTO);
		
		return result;
	}

	@Override
	public int idCheck(BuyerDTO buyerDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace + ".idCheck", buyerDTO);
	}

	@Override
	public int totalCount(SearchCriteria scri)  throws DataAccessException {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace+".totalCount", scri);
	}

	@Override
	public List<BuyerDTO> buyerList(SearchCriteria scri) throws DataAccessException {
		// TODO Auto-generated method stub
		return sqlSession.selectList(Namespace+".buyerList",scri);
	}
	
	

}
