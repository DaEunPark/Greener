package com.greener.codegreen.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.greener.codegreen.dao.DashBoardDAO;
@Service("dashBoardService")
public class DashBoardServiceImpl implements DashBoardService {
	private static final Logger logger = LoggerFactory.getLogger(BuyerServiceImpl.class);
	@Autowired
	private DashBoardDAO dashBoardDAO;

	
	public List<Map<String, Object>> getChart(Map<String, Object> map) throws Exception{
		
		return dashBoardDAO.getChart(map);	
	}
}
