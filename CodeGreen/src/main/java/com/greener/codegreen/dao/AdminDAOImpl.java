package com.greener.codegreen.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.greener.codegreen.dto.CategoryDTO;
import com.greener.codegreen.dto.ProductDTO;
import com.greener.codegreen.dto.ProductViewDTO;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO {

	@Inject
	private SqlSession sql;
	// 매퍼
	private static String namespace = "com.greener.codegreen.adminMapper";
	
	// 카테고리 호출
	@Override
	public List<CategoryDTO> category() throws Exception {
		return sql.selectList(namespace + ".category");
	}

	// 상품 등록
	@Override
	public void productRegister(ProductDTO dto) throws Exception {
		sql.insert(namespace+".register", dto);

	}

	// 상품 목록
	@Override
	public List<ProductViewDTO> productList() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".productList");
	}

	// 상품 상세 보기
	@Override
	public ProductViewDTO productView(int p_number) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".productView", p_number);
	}

	// 상품 수정
	@Override
	public void productModify(ProductDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sql.update(namespace+".productModify", dto);
	}

	@Override
	public void productDelete(int p_number) throws Exception {
		// TODO Auto-generated method stub
		sql.delete(namespace+ ".productDelete", p_number);
		
	}

	// 상품등록
	@Override
	public void register(ProductDTO dto) throws Exception {
		sql.insert(namespace+".register", dto);

	}
	
	
	
	
	// DashProductView 목록
	@Override
	public List<ProductViewDTO> DashProductview() {
		return sql.selectList(namespace+".dashproductview");
	}

	
	
	
}
