package com.greener.codegreen.dao;

import java.util.List;

import org.springframework.ui.Model;

import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.DashboardDTO;

public interface DashboardDAO {

	public List<DashboardDTO>Dash() throws Exception;
}
