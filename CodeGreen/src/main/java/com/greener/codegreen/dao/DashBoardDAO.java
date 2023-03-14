package com.greener.codegreen.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface DashBoardDAO {

	public List<Map<String, Object>> getChart(Map<String, Object> map) throws DataAccessException ;

}
