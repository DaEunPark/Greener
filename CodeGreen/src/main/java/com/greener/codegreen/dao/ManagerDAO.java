package com.greener.codegreen.dao;

import org.springframework.dao.DataAccessException;

import com.greener.codegreen.dto.ManagerDTO;

public interface ManagerDAO {
	public ManagerDTO login(ManagerDTO managerDTO) throws DataAccessException;
}
