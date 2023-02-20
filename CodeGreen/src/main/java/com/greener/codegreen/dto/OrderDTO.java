package com.greener.codegreen.dto;

import org.springframework.stereotype.Component;

@Component("orderDTO")
public class OrderDTO {
	int o_number;	
	int o_count;
	String o_address1;	// 배송지 우편번호
	String o_address2;	// 배송지 주소
	String o_address3;	// 배송지 상세주소
	String o_receiver_name;
	String o_receiver_phone;
	int o_price;
	
	// Product
	int order_p_number;
	
	// Buyer
	String order_b_id;

	public OrderDTO() {
	}

	public OrderDTO(int order_p_number, String order_b_id) {
		this.order_p_number = order_p_number;
		this.order_b_id = order_b_id;
	}

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

	public int getOrder_p_number() {
		return order_p_number;
	}

	public void setOrder_p_number(int order_p_number) {
		this.order_p_number = order_p_number;
	}

	public String getOrder_b_id() {
		return order_b_id;
	}

	public void setOrder_b_id(String order_b_id) {
		this.order_b_id = order_b_id;
	}

	@Override
	public String toString() {
		return "OrderDTO [o_number=" + o_number + ", o_count=" + o_count + ", o_address1=" + o_address1
				+ ", o_address2=" + o_address2 + ", o_address3=" + o_address3 + ", o_receiver_name=" + o_receiver_name
				+ ", o_receiver_phone=" + o_receiver_phone + ", o_price=" + o_price + ", order_p_number="
				+ order_p_number + ", order_b_id=" + order_b_id + "]";
	}
	
	
}
