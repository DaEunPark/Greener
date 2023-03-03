package com.greener.codegreen.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.greener.codegreen.dao.AdminDAO;
import com.greener.codegreen.dto.CategoryDTO;
import com.greener.codegreen.dto.ProductDTO;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Inject
	private AdminDAO dao;

	@Override
	public List<CategoryDTO> category() throws Exception {
		// TODO Auto-generated method stub
		return dao.category();
	}

	@Override
	public void register(ProductDTO dto) throws Exception {
		// TODO Auto-generated method stub
		dao.register(dto);
	}

	@Override
	public List<ProductDTO> productlist() throws Exception {
		// TODO Auto-generated method stub
		return dao.productlist();
	}

	@Override
	public ProductDTO productView(int p_number) throws Exception {
		// TODO Auto-generated method stub
		return dao.productView(p_number);
	}

}
