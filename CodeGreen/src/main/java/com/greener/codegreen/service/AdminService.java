package com.greener.codegreen.service;

import java.util.List;

import com.greener.codegreen.dto.CategoryDTO;
import com.greener.codegreen.dto.ProductDTO;
import com.greener.codegreen.dto.ProductViewDTO;

public interface AdminService {
	
	
	// ---------------------------------------------------------------------------------------
	// 누적판매량 상위 10개 상품 전시(시훈)
	// ---------------------------------------------------------------------------------------
	public List<ProductDTO> top10products() throws Exception;
	
	
	
	// 移댄뀒怨좊━ �샇異�
	public List<CategoryDTO> category() throws Exception;
	
	// �긽�뭹 �벑濡�
	public void productRegister(ProductDTO dto) throws Exception;
	
	// �긽�뭹 紐⑸줉
	public List<ProductViewDTO> productList() throws Exception;
	
	// �긽�뭹 �긽�꽭 蹂닿린
	public ProductViewDTO productView(int p_number) throws Exception;
	
	// �긽�뭹 �닔�젙
	public void productModify(ProductDTO dto) throws Exception;
	
	// �긽�뭹 �궘�젣
	public void productDelete(int p_number) throws Exception;

	public void register(ProductDTO dto) throws Exception;
}
