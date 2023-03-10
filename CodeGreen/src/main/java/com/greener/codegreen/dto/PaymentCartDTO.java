package com.greener.codegreen.dto;

import org.springframework.stereotype.Component;

@Component("paymentCartDTO")
public class PaymentCartDTO {
	private String p_name;
	private int p_price;
	private String p_img;
	private int o_count;
	private int o_total_price;

	public PaymentCartDTO() {
	}

	public PaymentCartDTO(String p_name, int p_price, String p_img, int o_count, int o_total_price) {
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_img = p_img;
		this.o_count = o_count;
		this.o_total_price = o_total_price;
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

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public int getO_count() {
		return o_count;
	}

	public void setO_count(int o_count) {
		this.o_count = o_count;
	}

	public int getO_total_price() {
		return o_total_price;
	}

	public void setO_total_price(int o_total_price) {
		this.o_total_price = o_total_price;
	}

	@Override
	public String toString() {
		return "PaymentCartDTO [p_name=" + p_name + ", p_price=" + p_price + ", p_img=" + p_img + ", o_count=" + o_count
				+ ", o_total_price=" + o_total_price + "]";
	}

	
	
	
}
