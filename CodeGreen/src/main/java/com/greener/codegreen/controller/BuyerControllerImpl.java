package com.greener.codegreen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	@RequestMapping(value="/loginForm.do", method=RequestMethod.GET)
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/buyer/loginForm");
		return mav;
	}

	@Override
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("buyer") BuyerDTO buyer, RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			System.out.println("로그인 정보 => " + buyer.getB_id() + " : " + buyer.getB_pwd());
		
		ModelAndView mav = new ModelAndView();
		
		// 아이디 값이 없이 넘어온 경우에는 돌려보낸다.
		if(buyer.getB_id().equals("") || buyer.getB_id() == null) {
			rAttr.addAttribute("result", "loginIdEmpty");
			mav.setViewName("redirect:/buyer/loginForm.do");
			return mav;
		}
		
		// 로그인한 정보를 가지고 데이터베이스에 존재하는지 처리를 하고, 그 결과를 가져온다.
		buyerDTO = buyerService.login(buyer);
		System.out.println("로그인 처리 결과 ==> " + buyerDTO);
		
		// 로그인한 정보가 데이터베이스에 존재하는지에 따라 처리를 다르게 한다.
		if(buyerDTO != null) {	// 로그인 정보에 해당하는 자료가 있으면
			
			if(buyer.getB_pwd().equals(buyerDTO.getB_pwd())) {
				
				// 아이디와 비밀번호가 일치하면 세션을 발급한다.
				HttpSession session = request.getSession();
				session.setAttribute("buyer",buyer);
				session.setAttribute("isLogOn", true);
				mav.setViewName("redirect:/main.do");	// 메인화면으로 이동한다.
				
			} else { 	// 아이디는 있는데 비밀번호가 틀린 경우
						// 메시지를 가지고 로그인 화면으로 이동한다.
				rAttr.addAttribute("result", "PasswordFailed");
				mav.setViewName("redirect:/buyer/loginForm.do");
			}
			
		} else {	// 로그인한 아이디가 존재하지 않으면 
					// 로그인 실패 메시지를 가지고 로그인 화면으로 이동한다.
			rAttr.addAttribute("result", "loginFailed");
			mav.setViewName("redirect:/buyer/loginForm.do");
		}
		
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
	// 회원가입 처리하기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	@RequestMapping(value = "/addBuyer.do", method = RequestMethod.POST)
	public ModelAndView addBuyer(BuyerDTO buyerDTO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		int result	= 0;	// 데이터 처리 완료 건수를 저장할 변수
		
		// 사용자가 입력한 회원정보를 서비스에게 넘겨주어서 처리하게 한다.
		result = buyerService.addBuyer(buyerDTO);
		
		// 회원가입 처리후 회원전체목록 페이지로 이동한다.
		ModelAndView mav = new ModelAndView("redirect:/buyer/loginForm.do");

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
