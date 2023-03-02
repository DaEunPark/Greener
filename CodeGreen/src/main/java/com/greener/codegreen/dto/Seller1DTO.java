package com.greener.codegreen.dto;

import org.springframework.stereotype.Component;

/*
 * 개인 판매자
 */
@Component("seller1DTO")
public class Seller1DTO {
	String s1_id;
	String s1_pwd;
	String s1_name;
	String s1_RRC;	// 판매자 주민번호
	String s1_email;
	String s1_add;	// 판매자 주소
	String s1_joindate;
	String s1_phone;
	public Seller1DTO() {
	}
	public String getS1_id() {
		return s1_id;
	}
	public void setS1_id(String s1_id) {
		this.s1_id = s1_id;
	}
	public String getS1_pwd() {
		return s1_pwd;
	}
	public void setS1_pwd(String s1_pwd) {
		this.s1_pwd = s1_pwd;
	}
	public String getS1_name() {
		return s1_name;
	}
	public void setS1_name(String s1_name) {
		this.s1_name = s1_name;
	}
	public String getS1_RRC() {
		return s1_RRC;
	}
	public void setS1_RRC(String s1_RRC) {
		this.s1_RRC = s1_RRC;
	}
	public String getS1_email() {
		return s1_email;
	}
	public void setS1_email(String s1_email) {
		this.s1_email = s1_email;
	}
	public String getS1_add() {
		return s1_add;
	}
	public void setS1_add(String s1_add) {
		this.s1_add = s1_add;
	}
	public String getS1_joindate() {
		return s1_joindate;
	}
	public void setS1_joindate(String s1_joindate) {
		this.s1_joindate = s1_joindate;
	}
	public String getS1_phone() {
		return s1_phone;
	}
	public void setS1_phone(String s1_phone) {
		this.s1_phone = s1_phone;
	}
	@Override
	public String toString() {
		return "Seller1DTO [s1_id=" + s1_id + ", s1_pwd=" + s1_pwd + ", s1_name=" + s1_name + ", s1_RRC=" + s1_RRC
				+ ", s1_email=" + s1_email + ", s1_add=" + s1_add + ", s1_joindate=" + s1_joindate + ", s1_phone="
				+ s1_phone + "]";
	}
	
}
