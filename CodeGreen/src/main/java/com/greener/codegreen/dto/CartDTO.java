package com.greener.codegreen.dto;

import org.springframework.stereotype.Component;

@Component("cartDTO")
public class CartDTO {
	int cart_number;
	int cart_o_count;
	
	// Product
	int cart_p_number;
	
	// Buyer
	String cart_b_id;
	
	private int cart_selected;

	public CartDTO() {
	}

	public CartDTO(int cart_p_number, String cart_b_id) {
		this.cart_p_number = cart_p_number;
		this.cart_b_id = cart_b_id;
	}

	public int getCart_number() {
		return cart_number;
	}

	public void setCart_number(int cart_number) {
		this.cart_number = cart_number;
	}

	public int getCart_o_count() {
		return cart_o_count;
	}

	public void setCart_o_count(int cart_o_count) {
		this.cart_o_count = cart_o_count;
	}

	public int getCart_p_number() {
		return cart_p_number;
	}

	public void setCart_p_number(int cart_p_number) {
		this.cart_p_number = cart_p_number;
	}

	public String getCart_b_id() {
		return cart_b_id;
	}

	public void setCart_b_id(String cart_b_id) {
		this.cart_b_id = cart_b_id;
	}

	public int getCart_selected() {
		return cart_selected;
	}

	public void setCart_selected(int cart_selected) {
		this.cart_selected = cart_selected;
	}

	@Override
	public String toString() {
		return "CartDTO [cart_number=" + cart_number + ", cart_o_count=" + cart_o_count + ", cart_p_number="
				+ cart_p_number + ", cart_b_id=" + cart_b_id + ", cart_selected=" + cart_selected + "]";
	}
	
	
}
