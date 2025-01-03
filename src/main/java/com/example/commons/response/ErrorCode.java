package com.example.commons.response;

public class ErrorCode {
	public String traceId;
	public String companyId;
	public String error;

	public ErrorCode() {
	}

	public ErrorCode(String traceId, String companyId, String error) {
		this.traceId = traceId;
		this.companyId = companyId;
		this.error = error;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}