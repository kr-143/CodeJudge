package com.codeJudge.CRM.Enum;

public enum StatusEnum {
	CREATED("Created"), CONTACTED("Contracted");

	private String value;

	private StatusEnum(String value) {
		this.value = value;
	}
}
