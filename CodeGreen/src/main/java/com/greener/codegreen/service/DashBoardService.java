package com.greener.codegreen.service;

import java.util.List;
import java.util.Map;

public interface DashBoardService {
	
	//-----------------------------------------------------------------------------------------------------------
    // 월별 가입자수 차트 (정하)
	//-----------------------------------------------------------------------------------------------------------
	public List<Map<String, Object>> getChart(Map<String, Object> map) throws Exception ;
		

	
}
