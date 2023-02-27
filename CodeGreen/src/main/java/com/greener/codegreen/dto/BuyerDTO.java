package com.greener.codegreen.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("buyerDTO")
public class BuyerDTO {
	private String b_id;
	private String b_pwd;
	private String b_name;
	private String b_birth;
	private String b_email;
	private String b_add;	// 회원 주소
	private String b_grade;	// 회원 등급
	private Date b_joindate;
	private String b_phone;
	private int b_amount;	// 구매 누적 금액
	
	public BuyerDTO() {
	}
	
	
	public BuyerDTO(String b_id, String b_pwd, String b_name, String b_birth, String b_email, String b_add,
			String b_grade, String b_phone, int b_amount) {
		this.b_id = b_id;
		this.b_pwd = b_pwd;
		this.b_name = b_name;
		this.b_birth = b_birth;
		this.b_email = b_email;
		this.b_add = b_add;
		this.b_grade = b_grade;
		this.b_phone = b_phone;
		this.b_amount = b_amount;
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
	public Date getB_joindate() {
		return b_joindate;
	}
	public void setB_joindate(Date b_joindate) {
		this.b_joindate = b_joindate;
	}
	public String getB_phone() {
		return b_phone;
	}
	public void setB_phone(String b_phone) {
		this.b_phone = b_phone;
	}
	public int getB_amount() {
		return b_amount;
	}
	public void setB_amount(int b_amount) {
		this.b_amount = b_amount;
	}
	@Override
	public String toString() {
		return "BuyerDTO [b_id=" + b_id + ", b_pwd=" + b_pwd + ", b_name=" + b_name + ", b_birth=" + b_birth
				+ ", b_email=" + b_email + ", b_add=" + b_add + ", b_grade=" + b_grade + ", b_joindate=" + b_joindate
				+ ", b_phone=" + b_phone + ", b_amount=" + b_amount + "]";
	}
	
}
