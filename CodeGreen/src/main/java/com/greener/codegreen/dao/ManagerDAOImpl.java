package com.greener.codegreen.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.greener.codegreen.dto.ManagerDTO;

@Repository("managerDAO")
public class ManagerDAOImpl implements ManagerDAO {
	@Inject
	private SqlSession sqlSession;
	
	private static String Namespace = "com.greener.codegreen.manager";
	
	@Override
	public ManagerDTO login(ManagerDTO managerDTO) throws DataAccessException {
		
		ManagerDTO loginDTO = sqlSession.selectOne(Namespace + ".ManagerLogin", managerDTO);
		return loginDTO;
	}

}
