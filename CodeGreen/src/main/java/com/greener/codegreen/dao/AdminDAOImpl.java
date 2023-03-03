package com.greener.codegreen.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.greener.codegreen.dto.CategoryDTO;
import com.greener.codegreen.dto.ProductDTO;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO {

	@Inject
	private SqlSession sql;
	// 매퍼
	private static String namespace = "com.greener.codegreen.adminMapper";
	
	@Override
	public List<CategoryDTO> category() throws Exception {
		return sql.selectList(namespace + ".category");
	}

	@Override
	public void register(ProductDTO dto) throws Exception {
		sql.insert(namespace+".register", dto);

	}

	@Override
	public List<ProductDTO> productlist() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".productlist");
	}

	@Override
	public ProductDTO productView(int p_number) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".productView", p_number);
	}

}
