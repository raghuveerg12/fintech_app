package com.core.isonsoft.beans;

import java.util.List;

public class StagBitTrexGetCurrcieMainBean {
	
	public String success;
	public String message;
	public List<StagBitTrexGetCurrencieBean> result;
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
	public List<StagBitTrexGetCurrencieBean> getResult() {
		return result;
	}
	public void setResult(List<StagBitTrexGetCurrencieBean> result) {
		this.result = result;
	}
	public StagBitTrexGetCurrcieMainBean(String success, String message,
			List<StagBitTrexGetCurrencieBean> result) {
		super();
		this.success = success;
		this.message = message;
		this.result = result;
	}
	@Override
	public String toString() {
		return "StagBitTrexGetCurrcieMainBean [success=" + success
				+ ", message=" + message + ", result=" + result + "]";
	}
	
	public StagBitTrexGetCurrcieMainBean(){
		
	}

}
