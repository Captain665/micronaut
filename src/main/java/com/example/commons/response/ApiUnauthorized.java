package com.example.commons.response;

import com.example.commons.enums.Status;

public class ApiUnauthorized extends ApiResponse {
	public ApiUnauthorized() {
		super(Status.unauthorized, "not authorized to access this", null, null);
	}
}