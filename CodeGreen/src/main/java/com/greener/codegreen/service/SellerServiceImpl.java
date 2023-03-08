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
	
	//------------------------------------------------------------------------------------------------------------
	// 판매자 리스트 조회
	//------------------------------------------------------------------------------------------------------------
	@Override
	public List<SellerDTO> sellerList(SearchCriteria scri) throws Exception {
		
		return sellerDAO.sellerList(scri);
	}
	
	//------------------------------------------------------------------------------------------------------------
	// 판매자 회원 수 조회
	//------------------------------------------------------------------------------------------------------------
	@Override
	public int totalCount(SearchCriteria scri) throws Exception {

		return sellerDAO.totalCount(scri);
	}
	
	//------------------------------------------------------------------------------------------------------------
	// 판매자 회원 수 조회
	//------------------------------------------------------------------------------------------------------------
	@Override
	public SellerDTO sellerDetail(String s_id,int flag) throws Exception {

		return sellerDAO.sellerDetail(s_id);
	}
	
	

}
