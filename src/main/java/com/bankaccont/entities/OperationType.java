package com.bankaccont.entities;

public enum OperationType {

	DEBIT("DEBIT"),
	CREDIT("CREDIT");

	private final String code;

	OperationType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
