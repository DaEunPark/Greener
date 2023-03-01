package com.greener.codegreen.controller;
import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greener.codegreen.dto.BuyerDTO;

//-----------------------------------------------------------------------------------------------------------
// public interface BuyerController
//-----------------------------------------------------------------------------------------------------------
public interface BuyerController {
	
	//-----------------------------------------------------------------------------------------------------------
	// 로그인 폼
	//-----------------------------------------------------------------------------------------------------------
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// *********************************************************************************************************** //
    // 로그인(vue.js에서 입력값 DB로 전송, 결과 조회)
	// *********************************************************************************************************** //
	public BuyerDTO login(@RequestBody BuyerDTO buyerDTO) throws Exception;
	
	// *********************************************************************************************************** //
	// 회원가입 화면으로 이동
	// *********************************************************************************************************** //
	public ModelAndView signIn
	(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
	// *********************************************************************************************************** //
	// 약관 동의 페이지로 이동
	// *********************************************************************************************************** //
	public ModelAndView toAgreementPage
	(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// *********************************************************************************************************** //
	// 정보 입력 페이지로 이동
	// *********************************************************************************************************** //
	public ModelAndView toMemberInfoPage
	(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//-----------------------------------------------------------------------------------------------------------
	// 로그아웃 처리
	//-----------------------------------------------------------------------------------------------------------
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//-----------------------------------------------------------------------------------------------------------
	// 회원가입 화면 불러오기
	//-----------------------------------------------------------------------------------------------------------
	public ModelAndView buyerForm(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//-----------------------------------------------------------------------------------------------------------
	// 회원가입 처리하기
	//-----------------------------------------------------------------------------------------------------------
	public int addBuyer(@ModelAttribute("buyer") BuyerDTO buyerDTO,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception;
	
	// *********************************************************************************************************** //
	// 회원가입 완료 페이지로 이동
	// *********************************************************************************************************** //
	public ModelAndView signInFinish
	(HttpServletRequest request, HttpServletResponse response) throws Exception;	
	
	//-----------------------------------------------------------------------------------------------------------
	// 아이디 중복 검사 
	//-----------------------------------------------------------------------------------------------------------
	 public int idCheck(BuyerDTO buyerDTO) throws Exception;
	
	
	
	
	
} // End - public interface BuyerController
