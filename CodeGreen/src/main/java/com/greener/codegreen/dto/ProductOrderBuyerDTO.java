package com.greener.codegreen.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("productOrderBuyerDTO")
public class ProductOrderBuyerDTO {
	int o_number;	
	int o_count;
	String o_address1;	// 배송지 우편번호
	String o_address2;	// 배송지 주소
	String o_address3;	// 배송지 상세주소
	String o_receiver_name;
	String o_receiver_phone;
	int o_price;
	Date o_date;
	String b_id;
	String b_pwd;
	String b_name;
	String b_birth;
	String b_email;
	String b_add;	// 회원 주소
	String b_grade;	// 회원 등급
	String b_joindate;
	String b_phone;
	String b_amount;	// 구매 누적 금액
	int b_num;			// 회원 번호
	String pay_how;		// 결제 방식
	String pay_about;	// 카드 결제 시 카드 번확 저장될 공간
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
	
	public int getO_number() {
		return o_number;
	}

	public void setO_number(int o_number) {
		this.o_number = o_number;
	}

	public int getO_count() {
		return o_count;
	}

	public void setO_count(int o_count) {
		this.o_count = o_count;
	}

	public String getO_address1() {
		return o_address1;
	}

	public void setO_address1(String o_address1) {
		this.o_address1 = o_address1;
	}

	public String getO_address2() {
		return o_address2;
	}

	public void setO_address2(String o_address2) {
		this.o_address2 = o_address2;
	}

	public String getO_address3() {
		return o_address3;
	}

	public void setO_address3(String o_address3) {
		this.o_address3 = o_address3;
	}

	public String getO_receiver_name() {
		return o_receiver_name;
	}

	public void setO_receiver_name(String o_receiver_name) {
		this.o_receiver_name = o_receiver_name;
	}

	public String getO_receiver_phone() {
		return o_receiver_phone;
	}

	public void setO_receiver_phone(String o_receiver_phone) {
		this.o_receiver_phone = o_receiver_phone;
	}

	public int getO_price() {
		return o_price;
	}

	public void setO_price(int o_price) {
		this.o_price = o_price;
	}

	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public String getB_pwd() {
		return b_pwd;
	}

	public void setB_pwd(String b_pwd) {
		this.b_pwd = b_pwd;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getB_birth() {
		return b_birth;
	}

	public void setB_birth(String b_birth) {
		this.b_birth = b_birth;
	}

	public String getB_email() {
		return b_email;
	}

	public void setB_email(String b_email) {
		this.b_email = b_email;
	}

	public String getB_add() {
		return b_add;
	}

	public void setB_add(String b_add) {
		this.b_add = b_add;
	}

	public String getB_grade() {
		return b_grade;
	}

	public void setB_grade(String b_grade) {
		this.b_grade = b_grade;
	}

	public String getB_joindate() {
		return b_joindate;
	}

	public void setB_joindate(String b_joindate) {
		this.b_joindate = b_joindate;
	}

	public String getB_phone() {
		return b_phone;
	}

	public void setB_phone(String b_phone) {
		this.b_phone = b_phone;
	}

	public String getB_amount() {
		return b_amount;
	}

	public void setB_amount(String b_amount) {
		this.b_amount = b_amount;
	}

	public int getB_num() {
		return b_num;
	}

	public void setB_num(int b_num) {
		this.b_num = b_num;
	}

	public String getPay_how() {
		return pay_how;
	}

	public void setPay_how(String pay_how) {
		this.pay_how = pay_how;
	}

	public String getPay_about() {
		return pay_about;
	}

	public void setPay_about(String pay_about) {
		this.pay_about = pay_about;
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

	public String getS2_id() {
		return s2_id;
	}

	public void setS2_id(String s2_id) {
		this.s2_id = s2_id;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	// Seller1
	String s1_id;
	
	// Seller2
	String s2_id;
	
	// Manager
	String m_id;
}
