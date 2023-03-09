package com.greener.codegreen.service;

import org.springframework.dao.DataAccessException;

import com.greener.codegreen.dto.BuyerDTO;

public interface PaymentService {

	/*
	 * 구매자 정보 
	 */
	BuyerDTO getBuyerInfo(BuyerDTO buyerId) throws DataAccessException;

}
