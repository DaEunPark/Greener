package com.greener.codegreen.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.greener.codegreen.dto.VisitCountDTO;

@Repository("visitCountDAO")
public class VisitCountDAO {
	
	@Inject
	private SqlSession sql;
	// 매퍼
	private static String namespace = "com.greener.codegreen.visitMapper";

	public int insertVisitor(VisitCountDTO dto) throws Exception{
            return sql.insert(namespace + ".insertVisitor", dto);
    }
}