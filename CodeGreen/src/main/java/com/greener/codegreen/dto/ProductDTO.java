package com.greener.codegreen.dto;

import org.springframework.stereotype.Component;

@Component("productDTO")
public class ProductDTO {
	int p_number;		// 상품 번호
	String p_name;		// 상품 이름
	int p_price;		// 상품 가격
	String p_content;	// 상품 내용
	int p_stock;		// 재고
	int p_view;			// 상품글 조회수
	String p_made;		// 원산지
	String p_usedate;	// 유통/소비기한
	
	// Category
	String c_code;		// 카테고리 코드
	
	// Seller1
	String s1_id;
	
	// Seller2
	String s22_id;
	
	// Manager
	String m_id;

	public ProductDTO() {

	}

	public ProductDTO(String c_code, String s1_id, String s22_id, String m_id) {
		this.c_code = c_code;
		this.s1_id = s1_id;
		this.s22_id = s22_id;
		this.m_id = m_id;
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

	public String getC_code() {
		return c_code;
	}

	public void setC_code(String c_code) {
		this.c_code = c_code;
	}

	public String getS1_id() {
		return s1_id;
	}

	public void setS1_id(String s1_id) {
		this.s1_id = s1_id;
	}

	public String getS22_id() {
		return s22_id;
	}

	public void setS22_id(String s22_id) {
		this.s22_id = s22_id;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	@Override
	public String toString() {
		return "ProductDTO [p_number=" + p_number + ", p_name=" + p_name + ", p_price=" + p_price + ", p_content="
				+ p_content + ", p_stock=" + p_stock + ", p_view=" + p_view + ", p_made=" + p_made + ", p_usedate="
				+ p_usedate + ", c_code=" + c_code + ", s1_id=" + s1_id + ", s22_id=" + s22_id + ", m_id=" + m_id + "]";
	}
	
	
}
