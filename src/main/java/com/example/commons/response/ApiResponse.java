package com.example.commons.response;

import com.example.commons.enums.Status;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"status", "message", "result", "error"})
public class ApiResponse {
	public Status status;
	public String message;
	public Object result;
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