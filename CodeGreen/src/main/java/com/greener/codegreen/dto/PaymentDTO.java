package com.greener.codegreen.dto;

import org.springframework.stereotype.Component;

@Component("paymentDTO")
public class PaymentDTO {	
	String pay_how;		// 결제 방식
	String pay_about;	// 카드 결제 시 카드 번확 저장될 공간
	
	// Order
	int o_number;
	int o_price;		// 주문 가격
	public PaymentDTO() {
	}
	public PaymentDTO(int o_number, int o_price) {
		this.o_number = o_number;
		this.o_price = o_price;
	}
	public String getPay_how() {
		return pay_how;
	}
	public void setPay_how(String pay_how) {
		this.pay_how = pay_how;
	}
	public String getPay_about() {
		return pay_about;
	}
	public void setPay_about(String pay_about) {
		this.pay_about = pay_about;
	}
	public int getO_number() {
		return o_number;
	}
	public void setO_number(int o_number) {
		this.o_number = o_number;
	}
	public int getO_price() {
		return o_price;
	}
	public void setO_price(int o_price) {
		this.o_price = o_price;
	}
	@Override
	public String toString() {
		return "PaymentDTO [pay_how=" + pay_how + ", pay_about=" + pay_about + ", o_number=" + o_number + ", o_price="
				+ o_price + "]";
	}
	
	
	
}
