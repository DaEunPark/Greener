package com.greener.codegreen.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.greener.codegreen.dao.PaymentDAO;
import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.CartDTO;
import com.greener.codegreen.dto.PaymentCartDTO;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

	private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
	
	@Autowired
	private PaymentDAO paymentDAO;
	
	@Override
	public BuyerDTO getBuyerInfo(CartDTO buyerId) throws DataAccessException {
		// TODO Auto-generated method stub
		return paymentDAO.getBuyerInfo(buyerId);
	}

	@Override
	public List<PaymentCartDTO> getPaymentCartList(CartDTO buyerId) throws DataAccessException {
		// TODO Auto-generated method stub
		return paymentDAO.getPaymentCartList(buyerId);
	}

	@Override
	public int addTocart(CartDTO cartDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return paymentDAO.addTocart(cartDTO);
	}

	@Override
	public int getCartCount() throws DataAccessException {
		// TODO Auto-generated method stub
		return paymentDAO.getCartCount();
	}

	@Override
	public int deleteThisProduct(CartDTO cartDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return paymentDAO.deleteThisProduct(cartDTO);
	}
	
	
	
}
