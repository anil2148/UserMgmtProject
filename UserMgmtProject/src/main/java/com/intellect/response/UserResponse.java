package com.intellect.response;

import java.util.ArrayList;
import java.util.List;

import com.intellect.validationMessage.ValidationMessage;

public class UserResponse {
	private String responseMsg;
	private String msg;
	private String userId;
	private List<ValidationMessage> validationError = new ArrayList<>();

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<ValidationMessage> getValidationError() {
		return validationError;
	}

	public void setValidationError(List<ValidationMessage> validationError) {
		this.validationError = validationError;
	}

}
