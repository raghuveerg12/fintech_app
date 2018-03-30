package com.core.isonsoft.beans;


public class CcexOrderBookMainBean {
	
	public String success;
	public String message;
	public CcexOrderBookResultBean result;
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
	public CcexOrderBookResultBean getResult() {
		return result;
	}
	public void setResult(CcexOrderBookResultBean result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "CcexOrderBookMainBean [success=" + success + ", message="
				+ message + ", result=" + result + "]";
	}
	
	
	

}
