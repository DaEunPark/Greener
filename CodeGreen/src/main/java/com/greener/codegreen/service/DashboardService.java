package com.greener.codegreen.service;

import java.util.List;

import org.springframework.ui.Model;

import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.DashboardDTO;

public interface DashboardService {
	
	public List<DashboardDTO> Dash() throws Exception;
	
}
