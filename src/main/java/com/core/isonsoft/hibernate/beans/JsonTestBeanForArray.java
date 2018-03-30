package com.core.isonsoft.hibernate.beans;

import java.util.Arrays;

public class JsonTestBeanForArray {
	public Object[] asks;
	public Object[] bids;
	public Object[] getBids() {
		return bids;
	}
	public void setBids(Object[] bids) {
		this.bids = bids;
	}

	

	public void setAsks(Object[] asks) {
		this.asks = asks;
	}

	public Object[] getAsks() {
		return asks;
	}
	@Override
	public String toString() {
		return "JsonTestBeanForArray [asks=" + Arrays.toString(asks)
				+ ", bids=" + Arrays.toString(bids) + "]";
	}
	public JsonTestBeanForArray(Object[] asks, Object[] bids) {
		super();
		this.asks = asks;
		this.bids = bids;
	}
	public JsonTestBeanForArray(){
		
	}
	
	
}
