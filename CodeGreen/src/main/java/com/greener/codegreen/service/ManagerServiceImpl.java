package com.greener.codegreen.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.greener.codegreen.controller.ManagerController;
import com.greener.codegreen.dao.ManagerDAO;

import com.greener.codegreen.dto.ManagerDTO;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
	private static final Logger logger = LoggerFactory.getLogger(ManagerServiceImpl.class);
	
	@Inject
	ManagerDTO managerDTO;
	
	@Inject
	ManagerController managerController;
	
	@Inject
	ManagerDAO managerDAO;

	//-------------------------------------------------------------------------------------------------------------------------
	// 관리자 로그인
	//-------------------------------------------------------------------------------------------------------------------------
	@Override
	public ManagerDTO login(ManagerDTO managerDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		logger.info("MangerService login() => " + managerDTO);
		return managerDAO.login(managerDTO);
	}

	
	
}
