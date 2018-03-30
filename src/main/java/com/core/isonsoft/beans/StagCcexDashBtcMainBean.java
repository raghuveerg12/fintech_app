package com.core.isonsoft.beans;

public class StagCcexDashBtcMainBean {
	
	public StagCcexDashBtcBean ticker;

	public StagCcexDashBtcBean getTicker() {
		return ticker;
	}

	public void setTicker(StagCcexDashBtcBean ticker) {
		this.ticker = ticker;
	}

	@Override
	public String toString() {
		return "StagCcexDashBtcMainBean [ticker=" + ticker + "]";
	}

	public StagCcexDashBtcMainBean(StagCcexDashBtcBean ticker) {
		super();
		this.ticker = ticker;
	}
	
	
	public StagCcexDashBtcMainBean(){
		
	}
}
