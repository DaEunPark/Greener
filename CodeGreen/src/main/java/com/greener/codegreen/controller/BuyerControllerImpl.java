package com.greener.codegreen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/buyer/loginForm");
		return mav;
	}
	
	// *********************************************************************************************************** //
    // 로그인(vue.js)
	// *********************************************************************************************************** //	
	@Override
	@PostMapping(value="/login")
	@CrossOrigin(origins="http://localhost:8080")	
	public @ResponseBody BuyerDTO login(@RequestBody BuyerDTO buyerIdPwd) throws Exception {
		
		BuyerDTO buyerInfo = buyerService.login(buyerIdPwd);
		logger.info("*** login *** " + buyerInfo);
		return buyerInfo;
	}
	
	// *********************************************************************************************************** //
	// 회원가입 화면으로 이동
	// *********************************************************************************************************** //	
	@Override
	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public ModelAndView signIn(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/buyer/signIn1Start");
		return mav;
	}
	
	
	// *********************************************************************************************************** //
	// 약관 동의 페이지로 이동
	// *********************************************************************************************************** //
	@Override
	@RequestMapping(value="/Agreement", method=RequestMethod.GET)
	public ModelAndView toAgreementPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/buyer/signIn2Agree");
		return mav;
	}
	
	// *********************************************************************************************************** //
	// 정보 입력 페이지로 이동
	// *********************************************************************************************************** //
	@Override
	@RequestMapping(value="/Info", method=RequestMethod.GET)
	public ModelAndView toMemberInfoPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/buyer/signIn3Information");
		return mav;
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 회원가입 처리하기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	@RequestMapping(value = "/addBuyer", method = RequestMethod.POST)
	public int addBuyer(BuyerDTO buyerDTO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("MemberControllerImpl 회원가입 처리하기() 시작");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		return buyerService.addBuyer(buyerDTO); // 데이터 처리 완료 건수를 저장할 변수
	}
	
	// *********************************************************************************************************** //
	// 정보 입력 페이지에서 DB로 자료전송 후 가입완료 화면 이동
	// *********************************************************************************************************** //
	@Override
	@RequestMapping(value="/done", method=RequestMethod.POST)
	public ModelAndView signInFinish(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/buyer/signIn4Finish");
		return mav;
	}

	//-----------------------------------------------------------------------------------------------------------
	// 로그아웃 처리
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 로그아웃 버튼을 누르면 세션정보를 없애고, 메인페이지로 이동하게 한다.
		HttpSession session = request.getSession();
		session.removeAttribute("buyer");
		session.removeAttribute("isLogOn");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/main.do");	// 메인페이지로 이동
		
		return mav;
	}
	//-----------------------------------------------------------------------------------------------------------
	// 회원가입 화면 불러오기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	@RequestMapping(value="/buyerForm.do", method=RequestMethod.GET)
	public ModelAndView buyerForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/buyer/buyerForm");	// 회원가입화면
		return mav;
	}

	

	//-----------------------------------------------------------------------------------------------------------
	// 아이디 중복 검사
	//-----------------------------------------------------------------------------------------------------------
	@Override
	@ResponseBody
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public int idCheck(BuyerDTO buyerDTO) throws Exception {
		int result = buyerService.idCheck(buyerDTO);
		
		return result;
	}

}
