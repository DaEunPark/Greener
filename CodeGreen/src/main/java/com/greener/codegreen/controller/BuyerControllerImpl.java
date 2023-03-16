package com.greener.codegreen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.greener.codegreen.common.PageMaker;
import com.greener.codegreen.common.SearchCriteria;
import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.service.BuyerService;

import java.text.DateFormat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//-----------------------------------------------------------------------------------------------------------
// 회원 정보 컨트롤러
//-----------------------------------------------------------------------------------------------------------


@Controller("buyerController")
@RequestMapping("/buyer/*")	// url에서 /buyer로 시작하는 요청들을 처리하는 컨트롤러.
public class BuyerControllerImpl implements BuyerController {
	private static final Logger logger = LoggerFactory.getLogger(BuyerControllerImpl.class);
	@Autowired
	private	BuyerDTO	buyerDTO;
	@Autowired
	private	BuyerService	buyerService;
	
	
	//-----------------------------------------------------------------------------------------------------------
    // 월별 가입자수 차트 (정하)
	//-----------------------------------------------------------------------------------------------------------
	@Override
	@RequestMapping(value="/SignUpChart", method=RequestMethod.GET)
	public ModelAndView getchart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> result = buyerService.getChart();
		
		mav.addObject("result", result);
		mav.addObject("map", map);
		mav.setViewName("buyer/SignUpChart");
		return mav;
	}
	//-----------------------------------------------------------------------------------------------------------
    // 로그인(vue.js에서 입력값 DB로 전송, 결과 조회)(시훈)
	//-----------------------------------------------------------------------------------------------------------
	@PostMapping(value="/login")
	@CrossOrigin(origins="http://localhost:8080")
	@ResponseBody
	@Override
	public BuyerDTO login(@RequestBody BuyerDTO buyerIdPwd) throws Exception {
		BuyerDTO buyerInfo = buyerService.login(buyerIdPwd);
		return buyerInfo;
	} // login()
	
	//-----------------------------------------------------------------------------------------------------------
	// 회원가입 화면으로 이동(시훈)
	//-----------------------------------------------------------------------------------------------------------
	@Override
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public ModelAndView signUp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/buyer/signUp1Start");
		return mav;
	} // singIn()
	
	//-----------------------------------------------------------------------------------------------------------
	// 약관 동의 페이지로 이동(시훈)
	//-----------------------------------------------------------------------------------------------------------
	@Override
	@RequestMapping(value="/Agreement", method=RequestMethod.GET)
	public ModelAndView toAgreementPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/buyer/signUp2Agree");
		return mav;
	} // toAgreementPage()
	
	//-----------------------------------------------------------------------------------------------------------
	// 정보 입력 페이지로 이동(시훈)
	//-----------------------------------------------------------------------------------------------------------
	@Override
	@RequestMapping(value="/Info", method=RequestMethod.GET)
	public ModelAndView toMemberInfoPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/buyer/signUp3Information");
		return mav;
	} // toMemberInfoPage()
	
	//-----------------------------------------------------------------------------------------------------------
	// 아이디 중복 검사(민준)
	//-----------------------------------------------------------------------------------------------------------
	@Override
	@ResponseBody
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public int idCheck(BuyerDTO buyerDTO) throws Exception {
		logger.info("MemberControllerImpl �븘�씠�뵒 以묐났 寃��궗 (Ajax) �떆�옉");
		int result = buyerService.idCheck(buyerDTO);
		logger.info("MemberControllerImpl �븘�씠�뵒 以묐났 寃��궗 (Ajax) �썑 諛쏆� 媛� : " + result);
		return result;
	} // idCheck()
	
	//-----------------------------------------------------------------------------------------------------------
	// 회원가입 처리하기(민준)
	//-----------------------------------------------------------------------------------------------------------
	@Override
	@RequestMapping(value = "/addBuyer", method = RequestMethod.POST)
	public int addBuyer(BuyerDTO buyerDTO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("MemberControllerImpl �쉶�썝媛��엯 泥섎━�븯湲�() �떆�옉");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		return buyerService.addBuyer(buyerDTO); // �뜲�씠�꽣 泥섎━ �셿猷� 嫄댁닔瑜� ���옣�븷 蹂��닔
	} // addBuyer()
	
	//-----------------------------------------------------------------------------------------------------------
	// 회원가입 완료 페이지로 이동(시훈)
	//-----------------------------------------------------------------------------------------------------------
	@Override
	@RequestMapping(value="/done", method=RequestMethod.POST)
	public ModelAndView signUpFinish(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/buyer/signUp4Finish");
		return mav;
	} // singInFinish()
	
	//-----------------------------------------------------------------------------------------------------------
	// 소비자 리스트 조회
	//-----------------------------------------------------------------------------------------------------------
	@Override
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
		logger.info("buyerList() => " + buyerList);
		return mav;

	} // buyerList()


	//-----------------------------------------------------------------------------------------------------------
	// 소비자 상세 조회
	//-----------------------------------------------------------------------------------------------------------
	@RequestMapping(value ="/buyerDetail", method = RequestMethod.GET)
	@Override
	public String buyerDetail(Model model, HttpServletRequest request) throws Exception {
		String b_id = 	request.getParameter("b_id");
		logger.info("b_id =>"+b_id);
		int flag = Integer.parseInt((String)request.getParameter("flag"));
		
		BuyerDTO buyerDTO = buyerService.buyerDetail(b_id,flag);
		model.addAttribute("buyerDetail", buyerDTO);
		
		return "/buyer/buyerDetail";
	} // buyerDetail()

} // End - public class BuyerControllerImpl
