package com.greener.codegreen.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.inject.Inject;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.greener.codegreen.dto.CategoryDTO;
import com.greener.codegreen.dto.ProductDTO;
import com.greener.codegreen.dto.ProductViewDTO;
import com.greener.codegreen.service.AdminService;

@Controller("adminController")
@RestController
@RequestMapping("/admin/*")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	/**
	 * 관리자 페이지
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndex(			
		@RequestHeader(value="Accept") String accept,
		@RequestHeader(value="Accept-Language") String acceptLanguage,
		@RequestHeader(value="User-Agent", defaultValue="myBrowser") String userAgent,
		@RequestHeader(value="Host") String host
		) throws Exception {
		logger.info("get index");
		
		System.out.println("Accept: " + accept);
        System.out.println("Accept-Language: " + acceptLanguage);
        System.out.println("User-Agent: " + userAgent);
        System.out.println("Host: " + host);

		return "admin/index";
	}
	
	@RequestMapping(value = "/index")
	public ModelAndView chart1() {
		return new ModelAndView("admin/index");
	}

	/*
	 * 상품 등록
	 */
	@RequestMapping(value = "/product/register", method = RequestMethod.GET)
	public void getProductRegister(Model model) throws Exception {
		logger.info("get product register");
		
		List<CategoryDTO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}
	
	// 상품 등록
	@RequestMapping(value = "/product/register", method = RequestMethod.POST)
	public String postProductRegister(ProductDTO dto) throws Exception{
		
		System.out.println("=================");
		
		System.out.println("1 = " + dto.getP_name());
		System.out.println("1 = " + dto.getP_price());
		System.out.println("1 = " + dto.getP_content());
		System.out.println("1 = " + dto.getP_img());
		System.out.println("=================");
							
		adminService.productRegister(dto);
		
		return "redirect:/admin/product/list";
	}
	
	// 상품 목록
	@RequestMapping(value = "/product/list", method = RequestMethod.GET)
	public void getProductList(Model model) throws Exception{
		logger.info("get product list");
		
		List<ProductViewDTO> list = adminService.productList();
		
		model.addAttribute("list", list);
	}
	
	// 상품 상세 보기
	@RequestMapping(value = "/product/view", method = RequestMethod.GET)
	public void getProductView(@RequestParam("n") int p_number, Model model) throws Exception{
		logger.info("get product view");
		
		ProductViewDTO product = adminService.productView(p_number);
		
		model.addAttribute("product", product);
	}
	
	// 상품 수정 
	@RequestMapping(value = "/product/modify", method = RequestMethod.GET)
	public void getProductModify(@RequestParam("n") int p_number, Model model) throws Exception {
	// @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 p_number에 저장
		
		logger.info("get product modify");
		
		ProductViewDTO product = adminService.productView(p_number);  // productViewDTO 형태 변수 product에 상품 정보 저장
		model.addAttribute("product", product);
		
		List<CategoryDTO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}
	
	// 상품 수정
	@RequestMapping(value = "/product/modify", method = RequestMethod.POST)
	public String postProductModify(ProductDTO dto) throws Exception{
		logger.info("post product modify");
		
		adminService.productModify(dto);
		
		return "redirect:/admin/product/list";
	}
	
	// 상품 삭제
	@RequestMapping(value = "/product/delete", method = RequestMethod.POST)
	public String postProductDelete(@RequestParam("n") int p_number) throws Exception{
		logger.info("post product delete");
		
		adminService.productDelete(p_number);
		
		return "redirect:/admin/product/list";
	}
	
}
