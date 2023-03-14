package com.greener.codegreen.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.greener.codegreen.dao.DashboardDAO;
import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.DashboardDTO;
import com.greener.codegreen.dto.ProductAvgCntDTO;

@Service("dashboardService")
public class DashBoardServiceImplements implements DashboardService {
	
	@Inject
	private DashboardDAO dashboarddao;
	// 대시보드 - 민준
	@Override
	public List<DashboardDTO> Dash() throws Exception {
		
		return dashboarddao.Dash();
	}
	
	// 대시보드 - 다은
	@Override
	public List<ProductAvgCntDTO> getProductAvgCntInfo(int limit) throws DataAccessException {
		// TODO Auto-generated method stub
		return dashboarddao.getProductAvgCntInfo(limit);
	}

	// 대시보드 - 정하
	@Override
	public List<Map<String, Object>> getChart(Map<String, Object> map) throws DataAccessException {
		// TODO Auto-generated method stub
		return dashboarddao.getChart(map);
	}

}
