package com.greener.codegreen.dao;

import java.util.List;

import com.greener.codegreen.dto.CategoryDTO;
import com.greener.codegreen.dto.ProductDTO;
import com.greener.codegreen.dto.ProductViewDTO;

public interface AdminDAO {
	
	// ---------------------------------------------------------------------------------------
	// 누적판매량 상위 10개 상품 전시(시훈)
	// ---------------------------------------------------------------------------------------
	public List<ProductDTO> top10products() throws Exception;
	
	
	// 카테고리 호출
	public List<CategoryDTO> category() throws Exception;
	
	// 상품 등록
	public void productRegister(ProductDTO dto) throws Exception;

	// 상품 목록
	public List<ProductViewDTO> productList() throws Exception;

	// 상품 상세 보기
	public ProductViewDTO productView(int p_number) throws Exception;
	
	// 상품 수정
	public void productModify(ProductDTO dto) throws Exception;
	
	// 상품 삭제
	public void productDelete(int p_number) throws Exception;
	
	
	
	// DashProductView 목록
	public List<ProductViewDTO> DashProductview() throws Exception ;
}
