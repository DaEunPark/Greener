package com.greener.codegreen.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

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
	
	}	// End - 판매자 리스트 조회
	
	@RequestMapping(value="/sellerDetail", method =RequestMethod.GET)
	public String sellerDetail (Model model , HttpServletRequest request) throws Exception{
		
		String s_id = request.getParameter("s_id");
		
		int flag = Integer.parseInt((String)request.getParameter("flag"));
		
		SellerDTO sellerDTO = sellerService.sellerDetail(s_id,flag);
		model.addAttribute("sellerDetail",sellerDTO);
		
		return "/seller/sellerDetail";
		
	}
	
}
