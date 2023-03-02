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
	@Override
	public List<SellerDTO> sellerList(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(Namespace+".sellerList",scri);
	}

	@Override
	public int totalCount(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(Namespace+".totalCount",scri);
	}

}
