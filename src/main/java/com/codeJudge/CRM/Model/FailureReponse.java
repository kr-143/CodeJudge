package com.codeJudge.CRM.Model;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("myFilter")
public class FailureReponse {
	private String status;
	private String reason;
	private String communication;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getCommunication() {
		return communication;
	}
	public void setCommunication(String communication) {
		this.communication = communication;
	}
	
	
}
