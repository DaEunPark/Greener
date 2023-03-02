package com.greener.codegreen.dto;

import org.springframework.stereotype.Component;

@Component("categoryDTO")
public class CategoryDTO {
	String c_code;
	String c_name;
	public CategoryDTO() {
	}
	public String getC_code() {
		return c_code;
	}
	public void setC_code(String c_code) {
		this.c_code = c_code;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	@Override
	public String toString() {
		return "CategoryDTO [c_code=" + c_code + ", c_name=" + c_name + "]";
	}
	
}
