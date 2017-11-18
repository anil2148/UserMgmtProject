package com.intellect.validationMessage;

public class ValidationMessage {
	private String field;
	private String validationMsg;

	public String getField() {
		return field;
	}
	public ValidationMessage(String fld, String validation){
		this.field = fld;
		this.validationMsg= validation;
	}
	public void setField(String field) {
		this.field = field;
	}

	public String getValidationMsg() {
		return validationMsg;
	}

	public void setValidationMsg(String validationMsg) {
		this.validationMsg = validationMsg;
	}
}
