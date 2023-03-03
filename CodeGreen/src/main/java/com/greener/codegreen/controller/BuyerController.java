package com.greener.codegreen.controller;

import java.util.List;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greener.codegreen.common.PageMaker;
import com.greener.codegreen.common.SearchCriteria;
import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.service.BuyerService;

//-----------------------------------------------------------------------------------------------------------
//회원 정보 컨트롤러
//-----------------------------------------------------------------------------------------------------------
@Controller
@RequestMapping("/buyer")	// url에서 /buyer로 시작하는 요청들을 처리하는 컨트롤러.
public class BuyerController  {
	
	private static final Logger logger 
		= LoggerFactory.getLogger(BuyerController.class);

	//-----------------------------------------------------------------------------------------------------------
	//	@Inject		: Java에서 지원하는 어노테이션. 특정 Framework에 종속적이지 않다.
	//	@Autowired	: Spring에서 지원하는 어노테이션.
	//-----------------------------------------------------------------------------------------------------------
	@Inject
	private	BuyerDTO	buyerDTO;
	
	@Autowired
	private	BuyerService	buyerService;
	

	// *********************************************************************************************************** //
 // 로그인 : vue.js로부터 입력받은 ID/PW를 Spring MVC로 전송 / 데이터 조회 - 일치하는 데이터 정보 반환
	// *********************************************************************************************************** //
	@PostMapping(value="/login")
	@CrossOrigin(origins="http://localhost:8080")
	public BuyerDTO sendMemberInfoToVue(@RequestBody BuyerDTO buyer) throws Exception {
		BuyerDTO buyerInfo = buyerService.login(buyer);
		return buyerInfo;
	} // sendMemberInfoToVue()
	
	//-----------------------------------------------------------------------------------------------------------
	// 로그아웃 처리
	//-----------------------------------------------------------------------------------------------------------
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 로그아웃 버튼을 누르면 세션정보를 없애고, 메인페이지로 이동하게 한다.
		HttpSession session = request.getSession();
		session.removeAttribute("buyer");
		session.removeAttribute("isLogOn");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/main.do");	// 메인페이지로 이동
		
		return mav;
		
	} // End - 로그아웃 처리
	

	//-----------------------------------------------------------------------------------------------------------
	// 회원가입 처리하기
	//-----------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/addBuyer.do", method = RequestMethod.POST)
	public ModelAndView addBuyer(BuyerDTO buyerDTO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		int result	= 0;	// 데이터 처리 완료 건수를 저장할 변수
		
		// 사용자가 입력한 회원정보를 서비스에게 넘겨주어서 처리하게 한다.
		result = buyerService.addBuyer(buyerDTO);
		
		// 회원가입 처리후 로그인 화면으로 넘어간다.
		ModelAndView mav = new ModelAndView("redirect:/buyer/loginForm.do");

		return mav;
	}  // End - 회원가입 처리하기

	// *********************************************************************************************************** //
 // vue.js 로그인 처리
	// *********************************************************************************************************** //
	@PostMapping(value="/loginByVue")
	@CrossOrigin(origins="http://localhost:8080")
	public BuyerDTO login(@RequestBody BuyerDTO buyerDTO) throws Exception {
		
		BuyerDTO buyerInfo = buyerService.login(buyerDTO);
		return buyerInfo;
		
	}
	// *********************************************************************************************************** //
	// 회원가입 화면으로 이동
	// *********************************************************************************************************** //
	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public ModelAndView signIn(HttpServletRequest request, HttpServletResponse response) throws Exception {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("/buyer/signIn1Start");
			
		return mav;
	}
	// *********************************************************************************************************** //
	// 약관 동의 페이지로 이동
	// *********************************************************************************************************** //
	@RequestMapping(value="/Agreement", method=RequestMethod.GET)
	public ModelAndView toAgreementPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/buyer/signIn2Agree");
		
		return mav;
	}
	// *********************************************************************************************************** //
	// 정보 입력 페이지로 이동
	// *********************************************************************************************************** //
	@RequestMapping(value="/Info", method=RequestMethod.GET)
	public ModelAndView toMemberInfoPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/buyer/signIn3Information");
		
		return mav;
	}
	
	// *********************************************************************************************************** //
	// 정보 입력 페이지에서 DB로 자료전송 후 가입완료 화면 이동
	// *********************************************************************************************************** //
	@RequestMapping(value="/done", method=RequestMethod.POST)
	public ModelAndView signInFinish(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/buyer/signIn4Finish");
		return mav;
	}

	//-----------------------------------------------------------------------------------------------------------
	// 아이디 중복 검사
	//-----------------------------------------------------------------------------------------------------------
	@ResponseBody
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public int idCheck(BuyerDTO buyerDTO) throws Exception {


		int result = buyerService.idCheck(buyerDTO);
		
		return result;
	} // End - 아이디 중복 검사
	
	//-----------------------------------------------------------------------------------------------------------
	// 아이디 상세 조회
	//-----------------------------------------------------------------------------------------------------------
	@RequestMapping(value ="/buyerDetail", method = RequestMethod.GET)
	public String buyerDetail(Model model, HttpServletRequest request) throws Exception{
	
		String b_id = 	request.getParameter("b_id");
		logger.info("b_id =>"+b_id);
		int flag = Integer.parseInt((String)request.getParameter("flag"));
		
		BuyerDTO buyerDTO = buyerService.buyerDetail(b_id,flag);
		model.addAttribute("buyerDetail", buyerDTO);
		
		return "/buyer/buyerDetail";
		
	}
	
	
	//-----------------------------------------------------------------------------------------------------------
	// 소비자 리스트 조회
	//-----------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/buyerList", method = RequestMethod.GET)
	public ModelAndView buyerList(SearchCriteria scri) throws Exception {
		
		ModelAndView mav = new ModelAndView("/buyer/buyerList");
		mav.addObject("keyword",scri.getKeyword());
		mav.addObject("searchType",scri.getSearchType());
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(buyerService.totalCount(scri));
		
		List<BuyerDTO> buyerList = buyerService.buyerList(scri);
		
		mav.addObject("buyerList",buyerList);
		mav.addObject("pageMaker",pageMaker);
		
		
		return mav;
	
	}	// End - 소비자 리스트 조회
	
}
