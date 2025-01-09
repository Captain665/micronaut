package com.example.commons.response;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class ErrorCode {
	public String traceId;
	public String code;
	public String error;

	public ErrorCode() {
	}

	public ErrorCode(String traceId, String code, String error) {
		this.traceId = traceId;
		this.code = code;
		this.error = error;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}