package com.greener.codegreen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greener.codegreen.dto.VisitCountDTO;
import com.greener.codegreen.service.VisitCountService;

@Controller
public class VisitCountController {

	@Autowired
	private VisitCountService mapper;
	
	@RequestMapping("visitor.do")
	public @ResponseBody List<VisitCountDTO> visitList(Model model, VisitCountDTO dto) throws Exception{
		List<VisitCountDTO> visitor = mapper.visitList(dto);
		model.addAttribute("visitor", visitor);
		return visitor;
	}
}
