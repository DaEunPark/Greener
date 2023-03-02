package com.greener.codegreen.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greener.codegreen.dto.ManagerDTO;
import com.greener.codegreen.service.ManagerService;

@Controller("managerController")
@RequestMapping("/manager/*")
public class ManagerController {
	private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	
	@Inject
	private ManagerDTO managerDTO;
	@Inject
	private ManagerService managerService;	

	//--------------------------------------------------------------------------------------------
	//로그인 화면 불러오기
	//--------------------------------------------------------------------------------------------
	@RequestMapping(value = "/manager_loginForm.do", method = RequestMethod.GET)
	public String ManagerLoginForm(HttpServletRequest request, HttpServletResponse response) throws Exception{


			return "/manager/manager_loginForm";
	}	
	
	//--------------------------------------------------------------------------------------------
	//로그인 하기
	//--------------------------------------------------------------------------------------------
	@RequestMapping(value="/manager_login.do",method = RequestMethod.POST	)
	public ModelAndView ManagerLogin(@ModelAttribute("manager") ManagerDTO manager, RedirectAttributes rAttr
																				,HttpServletRequest request, HttpServletResponse response ) throws Exception {

		System.out.println("로그인 정보 => " + manager.getM_id() + " : " + manager.getM_pwd());
		
		ModelAndView mav = new ModelAndView();
		
		
		
		// 아이디 값이 없이 넘어온 경우에는 돌려보낸다.
		if(manager.getM_id().equals("") || manager.getM_id() == null) {
			rAttr.addAttribute("result", "loginIdEmpty");
			mav.setViewName("redirect:/manager/manager_loginForm.do");
			return mav;
		}
		
		// 로그인한 정보를 가지고 데이터베이스에 존재하는지 처리를 하고, 그 결과를 가져온다.
		managerDTO = managerService.login(manager);
		System.out.println("로그인 처리 결과 ==> " + managerDTO);
		
		// 로그인한 정보가 데이터베이스에 존재하는지에 따라 처리를 다르게 한다.
		if(managerDTO != null) {	// 로그인 정보에 해당하는 자료가 있으면
			
			if(manager.getM_pwd().equals(managerDTO.getM_pwd())) {
				
				// 아이디와 비밀번호가 일치하면 세션을 발급한다.
				HttpSession session = request.getSession();
				session.setAttribute("manager", managerDTO);
				session.setAttribute("isLogOn", true);
				mav.setViewName("redirect:/managerMain.do");	// 메인화면으로 이동한다.
				
			} else { 	// 아이디는 있는데 비밀번호가 틀린 경우
						// 메시지를 가지고 로그인 화면으로 이동한다.
				rAttr.addAttribute("result", "PasswordFailed");
				mav.setViewName("redirect:/manager/manager_loginForm.do");
			}
			
		} else {	// 로그인한 아이디가 존재하지 않으면 
					// 로그인 실패 메시지를 가지고 로그인 화면으로 이동한다.
			rAttr.addAttribute("result", "loginFailed");
			mav.setViewName("redirect:/manager/manager_loginForm.do");
		}
		
		return mav;			
	}
	//---------------------------------------------------------------------------------------------------------------------------------
	// 로그아웃 하기
	//---------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value="/logout.do", method = RequestMethod.GET)
	public ModelAndView ManagerLogout(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		session.removeAttribute("manager");
		session.removeAttribute("isLogOn");
		mav.setViewName("redirect:/managerMain.do");	// 메인화면으로 이동한다.

		return mav;
	}
}
