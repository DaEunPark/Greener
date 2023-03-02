package com.greener.codegreen.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.greener.codegreen.common.PageMaker;
import com.greener.codegreen.common.SearchCriteria;
import com.greener.codegreen.dto.SellerDTO;
import com.greener.codegreen.service.SellerService;

@Controller("sellerController")
@RequestMapping(value="/seller/*")
public class SellerController {
	@Inject
	private SellerDTO sellerDTO;
	@Inject
	private SellerService sellerService;

	//----------------------------------------------------------------------------------------------------
	// 판매자 리스트 불러오기
	//----------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/sellerList.do", method = RequestMethod.GET)
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
}
