package com.codeJudge.CRM.Model;

public class CustomerLeadModel {

	private Integer id;
	private String first_name;
	private String last_name;
	private String mobile;
	private long email;
	private String location_type;
	private String location_string;
	private String status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public long getEmail() {
		return email;
	}
	public void setEmail(long email) {
		this.email = email;
	}
	public String getLocation_type() {
		return location_type;
	}
	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}
	public String getLocation_string() {
		return location_string;
	}
	public void setLocation_string(String location_string) {
		this.location_string = location_string;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
