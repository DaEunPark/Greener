package com.greener.codegreen.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "main";
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 메인 화면 불러오기
	//-----------------------------------------------------------------------------------------------------------
	@RequestMapping(value = {"/main", "/main.do"}, method = RequestMethod.GET)
	public String main( 
			) {
		

		
		System.out.println("HomeController의 main.do를 거쳐갑니다.");
		return "main";
		
	} // End - public String main()
	
	//-----------------------------------------------------------------------------------------------------------
	//관리자 페이지 메인 화면 불러오기
	//-----------------------------------------------------------------------------------------------------------
	@RequestMapping(value = {"/managerMain.do", "/managerMain"}, method = RequestMethod.GET)
	public String managerMain(
			@RequestHeader(value="Accept") String accept,
			@RequestHeader(value="Accept-Language") String acceptLanguage,
			@RequestHeader(value="User-Agent", defaultValue="myBrowser") String userAgent,
			@RequestHeader(value="Host") String host   ) {
	
		System.out.println("Accept: " + accept);
        System.out.println("Accept-Language: " + acceptLanguage);
        System.out.println("User-Agent: " + userAgent);
        System.out.println("Host: " + host);
		
		System.out.println("HomeController의 manager_main.do를 거쳐갑니다.");
		return "managerMain";
		

		
	} // End - public String  manager_main()
	
	
	
}
