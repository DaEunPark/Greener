package com.greener.codegreen.dto;

import org.springframework.stereotype.Component;

@Component("gradeDTO")
public class GradeDTO {
	String b_grade;
	int discount;	// 회원 등급에 따른 할인율
	public GradeDTO() {
	}
	public String getB_grade() {
		return b_grade;
	}
	public void setB_grade(String b_grade) {
		this.b_grade = b_grade;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "GradeDTO [b_grade=" + b_grade + ", discount=" + discount + "]";
	}
	
}
