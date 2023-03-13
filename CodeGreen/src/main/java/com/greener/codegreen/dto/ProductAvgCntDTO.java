package com.greener.codegreen.dto;

public class ProductAvgCntDTO {
	private float product_order_avg;
	private String p_name;
	private int order_p_number;
	public ProductAvgCntDTO() {
	}
	public ProductAvgCntDTO(float product_order_avg, String p_name, int order_p_number) {
		this.product_order_avg = product_order_avg;
		this.p_name = p_name;
		this.order_p_number = order_p_number;
	}
	public float getProduct_order_avg() {
		return product_order_avg;
	}
	public void setProduct_order_avg(float product_order_avg) {
		this.product_order_avg = product_order_avg;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getOrder_p_number() {
		return order_p_number;
	}
	public void setOrder_p_number(int order_p_number) {
		this.order_p_number = order_p_number;
	}
	@Override
	public String toString() {
		return "ProductAvgCntDTO [product_order_avg=" + product_order_avg + ", p_name=" + p_name + ", order_p_number="
				+ order_p_number + "]";
	}
	
	
}
