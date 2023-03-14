package com.greener.codegreen.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.greener.codegreen.common.SearchCriteria;
import com.greener.codegreen.dto.SellerDTO;

@Repository("sellerDAO")
public class SellerDAOImpl implements SellerDAO {
	@Inject
	private SqlSession sqlsession;

	private static final String Namespace = "com.greener.codegreen.seller";
	//------------------------------------------------------------------------------------------------------------
	// 판매자 리스트 조회
	//------------------------------------------------------------------------------------------------------------
	@Override
	public List<SellerDTO> sellerList(SearchCriteria scri) throws Exception {
		
		return sqlsession.selectList(Namespace+".sellerList",scri);
	}

	//------------------------------------------------------------------------------------------------------------
	// 판매자 회원 수 조회
	//------------------------------------------------------------------------------------------------------------
	@Override
	public int totalCount(SearchCriteria scri) throws Exception {
		
		return sqlsession.selectOne(Namespace+".totalCount",scri);
	}

	//------------------------------------------------------------------------------------------------------------
	// 판매자 상세정보 조회
	//------------------------------------------------------------------------------------------------------------
	@Override
	public SellerDTO sellerDetail(String s_id) throws Exception {
		
		return sqlsession.selectOne(Namespace+".sellerDetail",s_id);
	}
}
