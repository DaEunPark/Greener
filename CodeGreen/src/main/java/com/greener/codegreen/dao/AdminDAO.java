package com.greener.codegreen.dao;

import java.util.List;

import com.greener.codegreen.dto.CategoryDTO;
import com.greener.codegreen.dto.ProductDTO;

public interface AdminDAO {
	// 카테고리 호출
	public List<CategoryDTO> category() throws Exception;
	
	// 상품 등록
	public void register(ProductDTO dto) throws Exception;

	// 상품 목록
	public List<ProductDTO> productlist() throws Exception;

	// 상품 상세 보기
	public ProductDTO productView(int p_number) throws Exception;
}
