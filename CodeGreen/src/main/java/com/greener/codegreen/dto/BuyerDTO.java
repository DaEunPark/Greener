package com.greener.codegreen.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("buyerDTO")
public class BuyerDTO {
	
	private	String	b_id;		 // 구매자 아이디
	private	String	b_pwd;		 // 구매자 비밀번호
	private	String	b_name;		 // 구매자 이름
	private	String	b_birth;	 // 구매자 생년월일
	private	String	b_email;	 // 구매자 이메일
	private	String	b_address1;	 // 구매자 주소1
	private	String	b_address2;	 // 구매자 주소2
	private	String	b_address3;	 // 구매자 주소3
	private	String	b_grade;	 // 구매자 등급
	private	Date	b_joindate;	 // 구매자 가입일자
	private	String	b_phone;	 //  구매자 핸드폰번호
	private	int	    b_amount;	 // 구매자 누적 금액
	
	public	BuyerDTO()	{}		// 기본생성자
	public	BuyerDTO
	(String b_id, String b_pwd, String b_name,String b_birth, String b_email, String b_address1,String b_address2,String b_address3, String b_grade,String b_phone,int b_amount)
	{
		this.b_id	    = b_id;
		this.b_pwd	    = b_pwd;
		this.b_name	    = b_name;
		this.b_birth	= b_birth;
		this.b_email	= b_email;
		this.b_address1	= b_address1;
		this.b_address2	= b_address2;
		this.b_address3	= b_address3;
		this.b_grade	= b_grade;
		this.b_phone    = b_phone;
		this.b_amount   = b_amount;
	}
	
	public String getB_id() {return b_id;}
	public void   setB_id(String b_id) {this.b_id = b_id;}
	public String getB_pwd() {return b_pwd;}
	public void   setB_pwd(String b_pwd) {this.b_pwd = b_pwd;}
	public String getB_name() {return b_name;}
	public void   setB_name(String b_name) {this.b_name = b_name;}
	public String getB_birth() {return b_birth;}
	public void   setB_birth(String b_birth) {this.b_birth = b_birth;}
	public String getB_email() {return b_email;}
	public void   setB_email(String b_email) {this.b_email = b_email;}
	public String getB_address1() {return b_address1;}
	public void   setB_address1(String b_address1) {this.b_address1 = b_address1;}
	public String getB_address2() {return b_address2;}
	public void   setB_address2(String b_address2) {this.b_address2 = b_address2;}
	public String getB_address3() {return b_address3;}
	public void   setB_address3(String b_address3) {this.b_address3 = b_address3;}
	public String getB_grade() {return b_grade;}
	public void   setB_grade(String b_grade) {this.b_grade = b_grade;}
	public Date   getB_joindate() {return b_joindate;}
	public void   setB_joindate(Date b_joindate) {this.b_joindate = b_joindate;}
	public String getB_phone() {return b_phone;}
	public void   setB_phone(String b_phone) {this.b_phone = b_phone;}
	public int    getB_amount() {return b_amount;}
	public void   setB_amount(int b_amount) {this.b_amount = b_amount;}
	
	@Override
	public String toString() {
		return "BuyerDTO [b_id=" + b_id + ", b_pwd=" + b_pwd + ", b_name=" + b_name + ", b_birth=" + b_birth
				+ ", b_email=" + b_email + ", b_address1=" + b_address1 + ", b_address2=" + b_address2 + ", b_address3="
				+ b_address3 + ", b_grade=" + b_grade + ", b_joindate=" + b_joindate + ", b_phone=" + b_phone
				+ ", b_amount=" + b_amount + "]";
	}
	
} // End - public class BuyerDTO

