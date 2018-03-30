package com.core.isonsoft.beans;

import java.util.List;

public class StagCcexgetMarketSummaries {

	private String success;
	private String message;
	private List<StagCcexgetMarktSummResult> result;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<StagCcexgetMarktSummResult> getResult() {
		return result;
	}

	public void setResult(List<StagCcexgetMarktSummResult> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "StagCcexgetMarketSummaries [success=" + success + ", message="
				+ message + ", result=" + result + "]";
	}

}
