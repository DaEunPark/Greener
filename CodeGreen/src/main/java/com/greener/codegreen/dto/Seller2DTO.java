package com.greener.codegreen.dto;

import org.springframework.stereotype.Component;

/*
 * 사업자
 */
@Component("seller2DTO")
public class Seller2DTO {
	String s2_id;
	String s2_pwd;
	String s2_name;
	String s2_BRN;	// 사업자 번호
	String s2_email;
	String s2_add;	// 사업자 주소
	String s2_joindate;
	String s2_phone;
	public Seller2DTO() {
	}
	public String getS2_id() {
		return s2_id;
	}
	public void setS2_id(String s2_id) {
		this.s2_id = s2_id;
	}
	public String getS2_pwd() {
		return s2_pwd;
	}
	public void setS2_pwd(String s2_pwd) {
		this.s2_pwd = s2_pwd;
	}
	public String getS2_name() {
		return s2_name;
	}
	public void setS2_name(String s2_name) {
		this.s2_name = s2_name;
	}
	public String getS2_BRN() {
		return s2_BRN;
	}
	public void setS2_BRN(String s2_BRN) {
		this.s2_BRN = s2_BRN;
	}
	public String getS2_email() {
		return s2_email;
	}
	public void setS2_email(String s2_email) {
		this.s2_email = s2_email;
	}
	public String getS2_add() {
		return s2_add;
	}
	public void setS2_add(String s2_add) {
		this.s2_add = s2_add;
	}
	public String getS2_joindate() {
		return s2_joindate;
	}
	public void setS2_joindate(String s2_joindate) {
		this.s2_joindate = s2_joindate;
	}
	public String getS2_phone() {
		return s2_phone;
	}
	public void setS2_phone(String s2_phone) {
		this.s2_phone = s2_phone;
	}
	@Override
	public String toString() {
		return "Seller2DTO [s2_id=" + s2_id + ", s2_pwd=" + s2_pwd + ", s2_name=" + s2_name + ", s2_BRN=" + s2_BRN
				+ ", s2_email=" + s2_email + ", s2_add=" + s2_add + ", s2_joindate=" + s2_joindate + ", s2_phone="
				+ s2_phone + "]";
	}
	
}
