package com.greener.codegreen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.greener.codegreen.dao.DashboardDAO;
import com.greener.codegreen.dto.ProductAvgCntDTO;

@Service("dashboardService")
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private DashboardDAO dashboardDAO;
	
	@Override
	public List<ProductAvgCntDTO> getProductAvgCntInfo(int limit) throws DataAccessException {
		// TODO Auto-generated method stub
		return dashboardDAO.getProductAvgCntInfo(limit);
	}

}
