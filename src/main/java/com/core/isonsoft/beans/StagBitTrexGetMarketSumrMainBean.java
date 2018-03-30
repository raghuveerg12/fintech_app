package com.core.isonsoft.beans;

import java.util.List;

public class StagBitTrexGetMarketSumrMainBean {
	
	public String success;
	public String message;
	public List<StagBitTrexGetMarketSummariesBean> result;
	
	
	
	
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
	public List<StagBitTrexGetMarketSummariesBean> getResult() {
		return result;
	}
	public void setResult(List<StagBitTrexGetMarketSummariesBean> result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "StagBitTrexGetMarketSumrMainBean [success=" + success
				+ ", message=" + message + ", result=" + result + "]";
	}
	public StagBitTrexGetMarketSumrMainBean(String success, String message,
			List<StagBitTrexGetMarketSummariesBean> result) {
		super();
		this.success = success;
		this.message = message;
		this.result = result;
	}
	
	public StagBitTrexGetMarketSumrMainBean(){
		
	}

}
