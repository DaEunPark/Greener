package com.greener.codegreen.dto;

import org.springframework.stereotype.Component;

@Component("managerDTO")
public class ManagerDTO {
	String m_id;
	String m_pwd;
	String m_name;
	String m_RRC;
	String m_email;
	public ManagerDTO() {
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pwd() {
		return m_pwd;
	}
	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_RRC() {
		return m_RRC;
	}
	public void setM_RRC(String m_RRC) {
		this.m_RRC = m_RRC;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	@Override
	public String toString() {
		return "ManagerDTO [m_id=" + m_id + ", m_pwd=" + m_pwd + ", m_name=" + m_name + ", m_RRC=" + m_RRC
				+ ", m_email=" + m_email + "]";
	}
	
}
