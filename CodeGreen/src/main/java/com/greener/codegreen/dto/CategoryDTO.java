package com.greener.codegreen.dto;

import org.springframework.stereotype.Component;

@Component("categoryDTO")
public class CategoryDTO {
	private int c_code;
	private String c_name;
	private int c_code_ref;
	private int c_level;
	public int getC_code() {
		return c_code;
	}
	public void setC_code(int c_code) {
		this.c_code = c_code;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public int getC_code_ref() {
		return c_code_ref;
	}
	public void setC_code_ref(int c_code_ref) {
		this.c_code_ref = c_code_ref;
	}
	public int getC_level() {
		return c_level;
	}
	public void setC_level(int c_level) {
		this.c_level = c_level;
	}
	@Override
	public String toString() {
		return "CategoryDTO [c_code=" + c_code + ", c_name=" + c_name + ", c_code_ref=" + c_code_ref + ", c_level="
				+ c_level + "]";
	}
	
}
