package com.greener.codegreen.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.PaymentCartDTO;

public interface PaymentDAO {

	/*
	 * 구매자 정보
	 */
	BuyerDTO getBuyerInfo(BuyerDTO buyerId) throws DataAccessException;

	/*
	 * 구매할 상품 정보
	 */
	List<PaymentCartDTO> getPaymentCartList(BuyerDTO buyerId) throws DataAccessException;

}
