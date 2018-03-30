package com.core.isonsoft.hibernate.beans;

import java.util.List;

public class JsonTestBean {
	public List<JsonTestBeanForArray[]> btc_usd;
	
	
	

	public JsonTestBean(List<JsonTestBeanForArray[]> btc_usd) {
		super();
		this.btc_usd = btc_usd;
		
	}

		public List<JsonTestBeanForArray[]> getBtc_usd() {
		return btc_usd;
	}

	public void setBtc_usd(List<JsonTestBeanForArray[]> btc_usd) {
		this.btc_usd = btc_usd;
	}

	

	@Override
	public String toString() {
		return "JsonTestBean [btc_usd=" + btc_usd + "]";
	}

	
	
	public JsonTestBean(){
		
	}

}
