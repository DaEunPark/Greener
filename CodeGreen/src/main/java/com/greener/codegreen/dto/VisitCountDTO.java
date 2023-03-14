package com.greener.codegreen.dto;

import org.springframework.stereotype.Component;

@Component("VisitCountDTO")
public class VisitCountDTO {

	private String v_id;
	private String v_ip;
	private String v_time;
	private String v_refer;
	private String v_agent;
	public String getV_id() {
		return v_id;
	}
	public void setV_id(String v_id) {
		this.v_id = v_id;
	}
	public String getV_ip() {
		return v_ip;
	}
	public void setV_ip(String v_ip) {
		this.v_ip = v_ip;
	}
	public String getV_time() {
		return v_time;
	}
	public void setV_time(String v_time) {
		this.v_time = v_time;
	}
	public String getV_refer() {
		return v_refer;
	}
	public void setV_refer(String v_refer) {
		this.v_refer = v_refer;
	}
	public String getV_agent() {
		return v_agent;
	}
	public void setV_agent(String v_agent) {
		this.v_agent = v_agent;
	}
	@Override
	public String toString() {
		return "VisitCountDTO [v_id=" + v_id + ", v_ip=" + v_ip + ", v_time=" + v_time + ", v_refer=" + v_refer
				+ ", v_agent=" + v_agent + "]";
	}

}

