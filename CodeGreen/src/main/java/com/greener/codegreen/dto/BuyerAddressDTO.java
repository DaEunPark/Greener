package com.greener.codegreen.dto;

import org.springframework.stereotype.Component;

@Component("buyerAddressDTO")
public class BuyerAddressDTO {	
	String ba_address;	// 우편번호
	String ba_address2;	// 주소
	String ba_address3;	// 상세주소
	
	// Buyer
	String ba_b_id;

	public BuyerAddressDTO() {
	}

	public BuyerAddressDTO(String ba_b_id) {
		this.ba_b_id = ba_b_id;
	}

	public String getBa_address() {
		return ba_address;
	}

	public void setBa_address(String ba_address) {
		this.ba_address = ba_address;
	}

	public String getBa_address2() {
		return ba_address2;
	}

	public void setBa_address2(String ba_address2) {
		this.ba_address2 = ba_address2;
	}

	public String getBa_address3() {
		return ba_address3;
	}

	public void setBa_address3(String ba_address3) {
		this.ba_address3 = ba_address3;
	}

	public String getBa_b_id() {
		return ba_b_id;
	}

	public void setBa_b_id(String ba_b_id) {
		this.ba_b_id = ba_b_id;
	}

	@Override
	public String toString() {
		return "BuyerAddressDTO [ba_address=" + ba_address + ", ba_address2=" + ba_address2 + ", ba_address3="
				+ ba_address3 + ", ba_b_id=" + ba_b_id + "]";
	}
	
	
}
