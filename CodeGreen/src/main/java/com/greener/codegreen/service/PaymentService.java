package com.greener.codegreen.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.CartDTO;
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

	/*
	 * 장바구니에 추가
	 */
	int addTocart(CartDTO cartDTO) throws DataAccessException;

	/*
	 * 장바구니 상품 개수
	 */
	int getCartCount() throws DataAccessException;

	/*
	 * 장바구니에서 상품 삭제
	 */
	int deleteThisProduct(CartDTO cartDTO) throws DataAccessException;

}
