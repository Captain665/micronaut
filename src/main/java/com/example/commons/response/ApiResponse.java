package com.example.commons.response;

import com.example.commons.enums.Status;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.io.Serializable;

@Serdeable
public class ApiResponse implements Serializable {
	public Status status;
	public String message;
	@Nullable
	public Object result;
	@Nullable
	public Object error;

	public ApiResponse() {
	}

	public ApiResponse(Status status, String message, Object result, Object error) {
		this.status = status;
		this.message = message;
		this.result = result;
		this.error = error;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}
}