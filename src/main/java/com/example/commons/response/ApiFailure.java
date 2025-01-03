package com.example.commons.response;

import com.example.commons.enums.Status;

public class ApiFailure extends ApiResponse {
	public ApiFailure(String message, Object error) {
		super(Status.failure, message, null, error);
	}
}