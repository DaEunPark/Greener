package com.greener.codegreen.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.CartDTO;
import com.greener.codegreen.dto.PaymentCartDTO;

public interface PaymentDAO {

	/*
	 * 구매자 정보
	 */
	BuyerDTO getBuyerInfo(CartDTO buyerId) throws DataAccessException;

	/*
	 * 구매할 상품 정보
	 */
	List<PaymentCartDTO> getPaymentCartList(CartDTO buyerId) throws DataAccessException;

	/*
	 * 장바구니 추가
	 */
	int addTocart(CartDTO cartDTO) throws DataAccessException;

	/*
	 * 장바구니 상품 개수
	 */
	int getCartCount(CartDTO cartDTO) throws DataAccessException;

	/*
	 * 장바구니에서 상품 삭제
	 */
	int deleteThisProduct(CartDTO cartDTO) throws DataAccessException;

	int deleteBuyerProduct(CartDTO cartDTO) throws DataAccessException;

}
