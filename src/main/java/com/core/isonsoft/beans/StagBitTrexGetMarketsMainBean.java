package com.core.isonsoft.beans;

import java.util.List;

public class StagBitTrexGetMarketsMainBean {
	
	public String success;
	public String message;
	public List<StagBitTrexGetMarketsBean> result;
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
	public List<StagBitTrexGetMarketsBean> getResult() {
		return result;
	}
	public void setResult(List<StagBitTrexGetMarketsBean> result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "StagBitTrexGetMarketsMainBean [success=" + success
				+ ", message=" + message + ", result=" + result + "]";
	}
	public StagBitTrexGetMarketsMainBean(String success, String message,
			List<StagBitTrexGetMarketsBean> result) {
		super();
		this.success = success;
		this.message = message;
		this.result = result;
	}
	
	public StagBitTrexGetMarketsMainBean(){
		
	}
	

}
