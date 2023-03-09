package com.greener.codegreen.dao;

import org.springframework.dao.DataAccessException;

import com.greener.codegreen.dto.BuyerDTO;

public interface PaymentDAO {

	/*
	 * 구매자 정보
	 */
	BuyerDTO getBuyerInfo(BuyerDTO buyerId) throws DataAccessException;

}
