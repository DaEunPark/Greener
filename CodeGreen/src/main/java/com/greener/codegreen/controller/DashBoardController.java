package com.greener.codegreen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.greener.codegreen.dto.DashBoardDTO;
import com.greener.codegreen.service.DashBoardService;

@Controller("DashBoardController")
@RequestMapping("/dash/*")
public class DashBoardController {
	
	@Autowired
	DashBoardService dashBoardService;
	
	private static final Logger logger = LoggerFactory.getLogger(DashBoardController.class);

	@GetMapping("/dash/dashBoard")
	public ModelAndView dashBoardController() {

		logger.info("dashboardController() 실행....");
		
		ModelAndView mav = new ModelAndView("/dash/dashBoard");
		
		DashBoardDTO dashBoardDTO = dashBoardService.getGrain();
		DashBoardDTO dashBoardDTOF = dashBoardService.getFruit();
		DashBoardDTO dashBoardDTOS = dashBoardService.getFish();
		DashBoardDTO dashBoardDTOM = dashBoardService.getMeat();
		DashBoardDTO dashBoardDTOH = dashBoardService.getHealthy();
		DashBoardDTO dashBoardDTOW = dashBoardService.getWater();
		DashBoardDTO dashBoardDTON = dashBoardService.getSnack();
		
		mav.addObject("dashBoardDTO", dashBoardDTO);
		mav.addObject("dashBoardDTOF", dashBoardDTOF);
		mav.addObject("dashBoardDTOS", dashBoardDTOS);
		mav.addObject("dashBoardDTOM", dashBoardDTOM);
		mav.addObject("dashBoardDTOH", dashBoardDTOH);
		mav.addObject("dashBoardDTOW", dashBoardDTOW);
		mav.addObject("dashBoardDTON", dashBoardDTON);
		
		return mav;
	}
}
