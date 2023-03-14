package com.greener.codegreen.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component("dashboardAgeDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardAgeDTO {

	private int total;
	private String age_group;
	
}
