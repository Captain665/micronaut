package com.example.commons.response;

import com.example.commons.enums.Status;


public class ApiSuccess extends ApiResponse {
	public ApiSuccess(Object result) {
		super(Status.success, "", result, null);
	}
}