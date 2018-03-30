package com.core.isonsoft.beans;

import java.util.List;

public class CcexOrderBookResultBean {
	
	public List<CcexOrderBookSubResultBean> buy;
	public List<CcexOrderBookSubResultBean> sell;
	public List<CcexOrderBookSubResultBean> getBuy() {
		return buy;
	}
	public void setBuy(List<CcexOrderBookSubResultBean> buy) {
		this.buy = buy;
	}
	public List<CcexOrderBookSubResultBean> getSell() {
		return sell;
	}
	public void setSell(List<CcexOrderBookSubResultBean> sell) {
		this.sell = sell;
	}
	@Override
	public String toString() {
		return "CcexOrderBookResultBean [buy=" + buy + ", sell=" + sell + "]";
	}
	
	

}
