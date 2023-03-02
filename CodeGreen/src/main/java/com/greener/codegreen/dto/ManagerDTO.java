package com.greener.codegreen.dto;

import org.springframework.stereotype.Component;

@Component("managerDTO")
public class ManagerDTO {
	private String m_id;				// 관리자 아이디
	private String m_pwd;			//	관리자 비밀번호
	private String m_name;			// 관리자 이름
	private String m_RRC;			// 관리자 주민번호
	private String m_email;			// 관리자 이메일
	private String m_phone;		// 관리자 핸드폰 번호

	public ManagerDTO() {}
	public ManagerDTO(String m_id, String m_pwd,String m_name,String m_RRC,String m_email,String m_phone) {
		this.m_id 	= m_id;
		this.m_pwd 	= m_pwd;
		this.m_name 	= m_name;
		this.m_RRC 	= m_RRC;
		this.m_email 	= m_email;
		this.m_phone 	= m_phone;
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
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	
	@Override
	public String toString() {
		return "ManagerDTO [m_id=" + m_id + ", m_pwd=" + m_pwd + ", m_name=" + m_name + ", m_RRC=" + m_RRC
				+ ", m_email=" + m_email + ", m_phone=" + m_phone + "]";
	}
	
	
}
