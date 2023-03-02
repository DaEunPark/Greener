package com.greener.codegreen.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.ManagerDTO;
import com.greener.codegreen.dto.OrderDTO;

@Repository("managerDAO")
public class ManagerDAOImpl implements ManagerDAO {

	private static final Logger logger = LoggerFactory.getLogger(ManagerDAO.class);
	
	@Inject
	private SqlSession sqlSession;

	@Autowired
	private BuyerDTO buyerDTO;
	
	@Autowired
	private OrderDTO orderDTO;
	
	
	private static String Namespace = "com.greener.codegreen.manager";
	
	@Override
	public ManagerDTO login(ManagerDTO managerDTO) throws DataAccessException {
		
		ManagerDTO loginDTO = sqlSession.selectOne(Namespace + ".ManagerLogin", managerDTO);
		return loginDTO;
	}

}
