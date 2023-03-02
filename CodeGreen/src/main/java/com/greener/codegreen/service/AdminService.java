package com.greener.codegreen.service;

import java.util.List;

import com.greener.codegreen.dto.CategoryDTO;
import com.greener.codegreen.dto.ProductDTO;

public interface AdminService {
	// 카테고리 호출
	public List<CategoryDTO> category() throws Exception;
	
	// 상품 등록
	public void register(ProductDTO dto) throws Exception;
}
