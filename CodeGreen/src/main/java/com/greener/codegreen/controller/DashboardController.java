package com.greener.codegreen.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.DashboardDTO;
import com.greener.codegreen.service.BuyerService;
import com.greener.codegreen.service.DashboardService;

@Controller
@RequestMapping(value="/admin/dash")
public class DashboardController {
	
	@Inject
	private BuyerService buyerservice;
	
	@Inject
	private DashboardService dashboardservice;
	
	@RequestMapping(value="/Dashboard",method = RequestMethod.GET)
	public void Dash()throws Exception{}

	@RequestMapping(value = "/Dashboard22", method = RequestMethod.GET)
	@ResponseBody
	public List<DashboardDTO> Dashboard() throws Exception {
		
		List<DashboardDTO> dashboard = dashboardservice.Dash();
				
		
		
		return dashboard; 
	}
	
}
