package com.greener.codegreen.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.PaymentCartDTO;

public interface PaymentService {

	/*
	 * 구매자 정보 
	 */
	BuyerDTO getBuyerInfo(BuyerDTO buyerId) throws DataAccessException;

	/*
	 * 구매 예정 장바구니 정보
	 */
	List<PaymentCartDTO> getPaymentCartList(BuyerDTO buyerId) throws DataAccessException;

}
