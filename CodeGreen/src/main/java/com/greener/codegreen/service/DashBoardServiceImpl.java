package com.greener.codegreen.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.greener.codegreen.dao.DashboardDAO;
import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.DashboardDTO;

@Service
public class DashBoardServiceImpl implements DashboardService {
	
	@Inject
	private DashboardDAO dashboarddao;
	@Override
	public List<DashboardDTO> Dash() throws Exception {
		
		return dashboarddao.Dash();
	}

}
