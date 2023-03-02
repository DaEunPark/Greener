package com.greener.codegreen.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

/*
 * 개인 판매자
 */
@Component("sellerDTO")
public class SellerDTO {
	private String s_id;
	private String s_pwd;
	private String s_name;
	private String s_RRC;
	private String s_BRN;
	private String s_email;
	private String s_address1;
	private String s_address2;
	private String s_address3;
	private Date s_joindate;
	private String s_phone;

	public SellerDTO() {}
	public SellerDTO(String s_id,String s_pwd,String s_name,String s_RRC,String s_BRN,String s_email,String s_address1,String s_address2,String s_address3,String s_phone) {
	this.s_id = s_id;
	this.s_pwd = s_pwd;
	this.s_name = s_name;
	this.s_BRN = s_RRC;
	this.s_BRN = s_BRN;
	this.s_email = s_email;
	this.s_address1 =  s_address1;
	this.s_address2 =  s_address2;
	this.s_address3 =  s_address3;
	this.s_phone = s_phone;
	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getS_pwd() {
		return s_pwd;
	}
	public void setS_pwd(String s_pwd) {
		this.s_pwd = s_pwd;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_RRC() {
		return s_RRC;
	}
	public void setS_RRC(String s_RRC) {
		this.s_RRC = s_RRC;
	}
	public String getS_BRN() {
		return s_BRN;
	}
	public void setS_BRN(String s_BRN) {
		this.s_BRN = s_BRN;
	}
	public String getS_email() {
		return s_email;
	}
	public void setS_email(String s_email) {
		this.s_email = s_email;
	}

	public String getS_address1() {
		return s_address1;
	}
	public void setS_address1(String s_address1) {
		this.s_address1 = s_address1;
	}
	public String getS_address2() {
		return s_address2;
	}
	public void setS_address2(String s_address2) {
		this.s_address2 = s_address2;
	}
	public String getS_address3() {
		return s_address3;
	}
	public void setS_address3(String s_address3) {
		this.s_address3 = s_address3;
	}
	public Date getS_joindate() {
		return s_joindate;
	}
	public void setS_joindate(Date s_joindate) {
		this.s_joindate = s_joindate;
	}
	public String getS_phone() {
		return s_phone;
	}
	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}
	@Override
	public String toString() {
		return "SellerDTO [s_id=" + s_id + ", s_pwd=" + s_pwd + ", s_name=" + s_name + ", s_RRC=" + s_RRC + ", s_BRN="
				+ s_BRN + ", s_email=" + s_email + ", s_address1=" + s_address1 + ", s_address2=" + s_address2
				+ ", s_address3=" + s_address3 + ", s_joindate=" + s_joindate + ", s_phone=" + s_phone + "]";
	}

	
}
