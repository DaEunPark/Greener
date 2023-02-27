package com.greener.codegreen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.service.BuyerService;

//-----------------------------------------------------------------------------------------------------------
//회원 정보 컨트롤러
//-----------------------------------------------------------------------------------------------------------
@Controller("buyerController")
@RequestMapping("/buyer")	// url에서 /buyer로 시작하는 요청들을 처리하는 컨트롤러.
public class BuyerControllerImpl implements BuyerController {

	private static final Logger logger 
	= LoggerFactory.getLogger(BuyerControllerImpl.class);
	
	@Autowired
	private	BuyerDTO	buyerDTO;
	
	@Autowired
	private	BuyerService	buyerService;
	
	//-----------------------------------------------------------------------------------------------------------
		// 로그인 화면 띄우기
		//-----------------------------------------------------------------------------------------------------------
	@Override
	@RequestMapping(value="/loginForm.do", method=RequestMethod.GET)
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/buyer/loginForm");
		return mav;
	}

	@Override
	public ModelAndView login(BuyerDTO buyerDTO, RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView buyerForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView addBuyer(BuyerDTO buyerDTO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int idCheck(BuyerDTO buyerDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
