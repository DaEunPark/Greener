package com.greener.codegreen.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.greener.codegreen.dao.AdminDAO;
import com.greener.codegreen.dto.CategoryDTO;
import com.greener.codegreen.dto.ProductDTO;
import com.greener.codegreen.dto.ProductViewDTO;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Inject
	private AdminDAO dao;

	
	// ---------------------------------------------------------------------------------------
	// �����Ǹŷ� ��� 10�� ��ǰ ���(����)
	// ---------------------------------------------------------------------------------------
	@Override
	public List<ProductDTO> top10products() throws Exception {
		return dao.top10products();
	} // top10products()
	
	
	
	
	@Override
	public List<CategoryDTO> category() throws Exception {
		// TODO Auto-generated method stub
		return dao.category();
	}

	@Override
	public void productRegister(ProductDTO dto) throws Exception {
		// TODO Auto-generated method stub
		dao.productRegister(dto);
	}

	@Override
	public List<ProductViewDTO> productList() throws Exception {
		// TODO Auto-generated method stub
		return dao.productList();
	}

	@Override
	public ProductViewDTO productView(int p_number) throws Exception {
		// TODO Auto-generated method stub
		return dao.productView(p_number);
	}

	@Override
	public void productModify(ProductDTO dto) throws Exception {
		// TODO Auto-generated method stub
		dao.productModify(dto);
		
	}

	@Override
	public void productDelete(int p_number) throws Exception {
		// TODO Auto-generated method stub
		dao.productDelete(p_number);
		
	}
  
	// DashProductView 목록
	@Override
	public List<ProductViewDTO> DashProductview() throws Exception {
		return dao.DashProductview();
	}


}
