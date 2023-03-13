package com.greener.codegreen.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.greener.codegreen.dto.DashboardDTO;

@Repository
public class DashboardDAOImpl implements DashboardDAO {

	@Inject
	private SqlSession sqlsession;
	
	private static final String Namespace = "com.greener.codegreen.dash";
	
	@Override
	public List<DashboardDTO> Dash() throws Exception {

		return sqlsession.selectList(Namespace+".dash");
	}

}
