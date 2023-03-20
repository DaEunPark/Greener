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
	
	
	
	private int jan22;
	private int feb22;
	private int mar22;
	private int apr22;
	private int may22;
	private int jun22;
	private int jul22;
	private int aug22;
	private int sep22;
	private int oct22;
	private int nov22;
	private int dec22;
	public int getJan22() {
		return jan22;
	}
	public void setJan22(int jan22) {
		this.jan22 = jan22;
	}
	public int getFeb22() {
		return feb22;
	}
	public void setFeb22(int feb22) {
		this.feb22 = feb22;
	}
	public int getMar22() {
		return mar22;
	}
	public void setMar22(int mar22) {
		this.mar22 = mar22;
	}
	public int getApr22() {
		return apr22;
	}
	public void setApr22(int apr22) {
		this.apr22 = apr22;
	}
	public int getMay22() {
		return may22;
	}
	public void setMay22(int may22) {
		this.may22 = may22;
	}
	public int getJun22() {
		return jun22;
	}
	public void setJun22(int jun22) {
		this.jun22 = jun22;
	}
	public int getJul22() {
		return jul22;
	}
	public void setJul22(int jul22) {
		this.jul22 = jul22;
	}
	public int getAug22() {
		return aug22;
	}
	public void setAug22(int aug22) {
		this.aug22 = aug22;
	}
	public int getSep22() {
		return sep22;
	}
	public void setSep22(int sep22) {
		this.sep22 = sep22;
	}
	public int getOct22() {
		return oct22;
	}
	public void setOct22(int oct22) {
		this.oct22 = oct22;
	}
	public int getNov22() {
		return nov22;
	}
	public void setNov22(int nov22) {
		this.nov22 = nov22;
	}
	public int getDec22() {
		return dec22;
	}
	public void setDec22(int dec22) {
		this.dec22 = dec22;
	}
	@Override
	public String toString() {
		return "DashboardAgeDTO [jan22=" + jan22 + ", feb22=" + feb22 + ", mar22=" + mar22 + ", apr22=" + apr22
				+ ", may22=" + may22 + ", jun22=" + jun22 + ", jul22=" + jul22 + ", aug22=" + aug22 + ", sep22=" + sep22
				+ ", oct22=" + oct22 + ", nov22=" + nov22 + ", dec22=" + dec22 + "]";
	}
	
}
