package com.greener.codegreen.dto;

import org.springframework.stereotype.Component;

@Component("productViewDTO")
public class ProductViewDTO {
	int p_number;		// 상품 번호
	String p_name;		// 상품 이름
	int p_price;		// 상품 가격
	String p_content;	// 상품 내용
	int p_stock;		// 재고
	int p_view;			// 상품글 조회수
	String p_made;		// 원산지
	String p_usedate;	// 유통/소비기한
	String p_img;
	String p_thumbImg;
	
	// Category
	int product_c_code;		// 카테고리 코드
	private int c_code_ref; // 카테고리 참조
	private String c_name;// 카테고리 이름
	
	// Seller
	String product_s_id;
	
	// Manager
	String product_m_id;

	public ProductViewDTO() {
	}

	public int getP_number() {
		return p_number;
	}

	public void setP_number(int p_number) {
		this.p_number = p_number;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public int getP_stock() {
		return p_stock;
	}

	public void setP_stock(int p_stock) {
		this.p_stock = p_stock;
	}

	public int getP_view() {
		return p_view;
	}

	public void setP_view(int p_view) {
		this.p_view = p_view;
	}

	public String getP_made() {
		return p_made;
	}

	public void setP_made(String p_made) {
		this.p_made = p_made;
	}

	public String getP_usedate() {
		return p_usedate;
	}

	public void setP_usedate(String p_usedate) {
		this.p_usedate = p_usedate;
	}

	public int getProduct_c_code() {
		return product_c_code;
	}

	public void setProduct_c_code(int product_c_code) {
		this.product_c_code = product_c_code;
	}

	public int getC_code_ref() {
		return c_code_ref;
	}

	public void setC_code_ref(int c_code_ref) {
		this.c_code_ref = c_code_ref;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getProduct_s_id() {
		return product_s_id;
	}

	public void setProduct_s_id(String product_s_id) {
		this.product_s_id = product_s_id;
	}

	public String getProduct_m_id() {
		return product_m_id;
	}

	public void setProduct_m_id(String product_m_id) {
		this.product_m_id = product_m_id;
	}
	
	

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public String getP_thumbImg() {
		return p_thumbImg;
	}

	public void setP_thumbImg(String p_thumbImg) {
		this.p_thumbImg = p_thumbImg;
	}

	@Override
	public String toString() {
		return "ProductViewDTO [p_number=" + p_number + ", p_name=" + p_name + ", p_price=" + p_price + ", p_content="
				+ p_content + ", p_stock=" + p_stock + ", p_view=" + p_view + ", p_made=" + p_made + ", p_usedate="
				+ p_usedate + ", p_img=" + p_img + ", p_thumbImg=" + p_thumbImg + ", product_c_code=" + product_c_code
				+ ", c_code_ref=" + c_code_ref + ", c_name=" + c_name + ", product_s_id=" + product_s_id
				+ ", product_m_id=" + product_m_id + "]";
	}

	


	
}
