package com.core.isonsoft.beans;

import java.util.List;

public class StagCcexGetMarketHistoryMainBean {
	
	public String success;
	public String message;
	public List<StagCcexGetMarketHistoryBean> result;
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
	public List<StagCcexGetMarketHistoryBean> getResult() {
		return result;
	}
	public void setResult(List<StagCcexGetMarketHistoryBean> result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "StagCcexGetMarketHistoryMainBean [success=" + success
				+ ", message=" + message + ", result=" + result + "]";
	}
	
	
	

}
