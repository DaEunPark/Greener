package com.greener.codegreen.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.greener.codegreen.common.SearchCriteria;
import com.greener.codegreen.controller.SellerController;
import com.greener.codegreen.dao.SellerDAO;
import com.greener.codegreen.dto.SellerDTO;

@Service("sellerService")
public class SellerServiceImpl implements SellerService {
	@Inject
	private SellerController sellerController;
	@Inject 
	private SellerDAO sellerDAO;

	@Override
	public List<SellerDTO> sellerList(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return sellerDAO.sellerList(scri);
	}

	@Override
	public int totalCount(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return sellerDAO.totalCount(scri);
	}

}
