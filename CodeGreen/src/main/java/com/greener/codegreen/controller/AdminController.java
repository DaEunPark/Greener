package com.greener.codegreen.controller;

import java.util.List;

import javax.inject.Inject;

import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.greener.codegreen.dto.CategoryDTO;
import com.greener.codegreen.dto.ProductDTO;
import com.greener.codegreen.service.AdminService;

@Controller("adminController")
@RequestMapping("/admin/*")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService;
	/**
	 * Admin Index Page
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void getIndex() throws Exception {
		logger.info("get index");
	}
	
	/*
	 * Product List
	 */
	@RequestMapping(value = "/product/list")
	public String productList() throws Exception {
		
		return "/admin/product/list";
	}
	/*
	 * Admin Product Register
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
		adminService.register(dto);
		
		return "redirect:/";
	}
	
	// 상품 목록
	@RequestMapping(value = "/product/list", method = RequestMethod.GET)
	public void getProductList(Model model) throws Exception{
		logger.info("get product list");
		
		List<ProductDTO> list = adminService.productlist();
		model.addAttribute("list", list);
	}
	
	// 상품 상세 보기
	@RequestMapping(value = "/product/view", method = RequestMethod.GET)
	public void getProductview(@RequestParam("n") int p_number, Model model) throws Exception{
		logger.info("get product view");
		
		ProductDTO product = adminService.productView(p_number);
		
		model.addAttribute("product", product);
	}
}
