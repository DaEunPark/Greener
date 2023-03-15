package com.greener.codegreen.service;

import java.util.List;

import com.greener.codegreen.dto.VisitCountDTO;

public interface VisitCountService {

	public List<VisitCountDTO> visitList(VisitCountDTO dto) throws Exception;
}
