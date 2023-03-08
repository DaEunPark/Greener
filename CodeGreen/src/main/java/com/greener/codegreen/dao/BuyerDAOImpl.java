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
	private static final Logger logger = LoggerFactory.getLogger(BuyerDAOImpl.class);
	@Autowired
	private SqlSession sqlSession;
	
	private	static final String Namespace = "com.greener.codegreen.buyer";
	
	//-----------------------------------------------------------------------------------------------------------
	// 로그인(시훈)
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public BuyerDTO loginByIdPwd(BuyerDTO buyerIdPwd) throws DataAccessException {
		BuyerDTO buyDTO = sqlSession.selectOne(Namespace + ".loginByIdPwd", buyerIdPwd);
		return buyDTO;
	} // loginByID()
	
	//-----------------------------------------------------------------------------------------------------------
	// 아이디 중복 검사(민준)
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public int idCheck(BuyerDTO buyerDTO) throws DataAccessException {
		return sqlSession.selectOne(Namespace + ".idCheck", buyerDTO);
	} // idCheck()
	
	//-----------------------------------------------------------------------------------------------------------
	// 회원가입 처리하기(민준)
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public int addBuyer(BuyerDTO buyerDTO) throws DataAccessException {
		int result = sqlSession.insert(Namespace + ".addBuyer", buyerDTO);
		return result;
	} // addBuyer()
	
	//-----------------------------------------------------------------------------------------------------------
	// 소비자 계정 총 개수 조회(민준)
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public int totalCount(SearchCriteria scri) throws DataAccessException {
		return sqlSession.selectOne(Namespace+".totalCount", scri);
	} // totalCount()
	
	//-----------------------------------------------------------------------------------------------------------
	// 소비자 리스트 조회(민준)
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public List<BuyerDTO> buyerList(SearchCriteria scri) throws DataAccessException {
		return sqlSession.selectList(Namespace+".buyerList",scri);
	} // buyerList()

	//-----------------------------------------------------------------------------------------------------------
	// 소비자 상세 조회
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public BuyerDTO buyerDetail(String b_id) throws Exception {
		
		return sqlSession.selectOne(Namespace+".buyerDetail", b_id);
	}


} // End - public class BuyerDAOImpl implements BuyerDAO
