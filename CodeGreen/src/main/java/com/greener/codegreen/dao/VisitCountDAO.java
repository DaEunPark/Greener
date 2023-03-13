package com.greener.codegreen.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.greener.codegreen.dto.VisitCountDTO;

public class VisitCountDAO {
	
	@Inject
	private SqlSession sql;

	public int insertVisitor(VisitCountDTO dto) throws Exception{
            return sql.insert("insertVisitor", dto);
        }
}