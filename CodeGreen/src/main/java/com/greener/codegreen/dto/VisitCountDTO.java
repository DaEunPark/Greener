package com.greener.codegreen.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("VisitCountDTO")
public class VisitCountDTO {

	private String v_time;


}

