package com.greener.codegreen.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.greener.codegreen.dao.PaymentDAO;
import com.greener.codegreen.dto.BuyerDTO;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

	private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
	
	@Autowired
	private PaymentDAO paymentDAO;
	
	@Override
	public BuyerDTO getBuyerInfo(BuyerDTO buyerId) throws DataAccessException {
		// TODO Auto-generated method stub
		return paymentDAO.getBuyerInfo(buyerId);
	}
	
}
