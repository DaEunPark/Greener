package com.greener.codegreen.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.greener.codegreen.common.PageMaker;
import com.greener.codegreen.common.SearchCriteria;
import com.greener.codegreen.dto.SellerDTO;
import com.greener.codegreen.service.SellerService;

@Controller
@RequestMapping(value="/seller")
public class SellerController {
	@Inject
	private SellerDTO sellerDTO;
	@Inject
	private SellerService sellerService;

	
	
	//----------------------------------------------------------------------------------------------------
	// 사업자 판매회원 인증 페이지로 이동(시훈)
	//----------------------------------------------------------------------------------------------------
	@RequestMapping(value="corpSellerVerif", method = RequestMethod.GET)
	public ModelAndView corpSellerSignUp1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/seller/cSellSignUp1Verify");
		return mav;
	} // corpSellerSignUp1()
	
	//----------------------------------------------------------------------------------------------------
	// 개인 판매회원 인증 페이지로 이동(시훈)
	//----------------------------------------------------------------------------------------------------	
	@RequestMapping(value="privSellerVerif", method = RequestMethod.GET)
	public ModelAndView privSellerSignUp1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/seller/pSellSignUp1Verify");
		return mav;
	} // corpSellerSignUp1()
	
	
	
	
	//----------------------------------------------------------------------------------------------------
	// 판매자 리스트 불러오기
	//----------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/sellerList", method = RequestMethod.GET)
	public ModelAndView sellerList(SearchCriteria scri) throws Exception {
		
		ModelAndView mav = new ModelAndView("/seller/sellerList");
		mav.addObject("keyword",scri.getKeyword());
		mav.addObject("searchType",scri.getSearchType());
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(sellerService.totalCount(scri));
		
		List<SellerDTO> sellerList = sellerService.sellerList(scri);
		
		mav.addObject("sellerList",sellerList);
		mav.addObject("pageMaker",pageMaker);
		
		return mav;
	} // sellerList()
	
	//----------------------------------------------------------------------------------------------------
	// 판매자 상세 조회
	//----------------------------------------------------------------------------------------------------
	@RequestMapping(value="/sellerDetail", method =RequestMethod.GET)
	public String sellerDetail (Model model , HttpServletRequest request) throws Exception{
		
		String s_id = request.getParameter("s_id");
		
		int flag = Integer.parseInt((String)request.getParameter("flag"));
		
		SellerDTO sellerDTO = sellerService.sellerDetail(s_id,flag);
		model.addAttribute("sellerDetail",sellerDTO);
		
		return "/seller/sellerDetail";
	} // sellerDetail() 
	
	
} // SellerController
