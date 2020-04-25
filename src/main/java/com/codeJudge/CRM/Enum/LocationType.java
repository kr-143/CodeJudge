package com.codeJudge.CRM.Enum;

public enum LocationType {
	COUNTRY("Country"), CITY("City"), ZIP("Zip");
	
	private String type;

	private LocationType(String type) {
		this.type = type;
	}
	
	
	
}
