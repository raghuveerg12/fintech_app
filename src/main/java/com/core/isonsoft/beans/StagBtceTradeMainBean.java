package com.core.isonsoft.beans;

import java.util.List;

public class StagBtceTradeMainBean {
	
	public List<StagBtceTradeBean> btc_usd;

	public List<StagBtceTradeBean> getBtc_usd() {
		return btc_usd;
	}

	public void setBtc_usd(List<StagBtceTradeBean> btc_usd) {
		this.btc_usd = btc_usd;
	}

	@Override
	public String toString() {
		return "StagBtceTradeMainBean [btc_usd=" + btc_usd + "]";
	}

	public StagBtceTradeMainBean(List<StagBtceTradeBean> btc_usd) {
		super();
		this.btc_usd = btc_usd;
	}
	
	public StagBtceTradeMainBean(){
		
	}

}
