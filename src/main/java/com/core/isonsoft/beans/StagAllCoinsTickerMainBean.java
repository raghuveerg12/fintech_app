package com.core.isonsoft.beans;

import java.sql.Timestamp;

import javax.persistence.Transient;

public class StagAllCoinsTickerMainBean {

	public long date;
	public StagAllCoinsTickerBean ticker;
	public Timestamp updated;
	
	@Transient
	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public StagAllCoinsTickerBean getTicker() {
		return ticker;
	}

	public void setTicker(StagAllCoinsTickerBean ticker) {
		this.ticker = ticker;
	}

	

	@Override
	public String toString() {
		return "StagAllCoinsTickerMainBean [date=" + date + ", ticker="
				+ ticker + ", updated=" + updated + "]";
	}

	public StagAllCoinsTickerMainBean() {

	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public StagAllCoinsTickerMainBean(long date, StagAllCoinsTickerBean ticker,
			Timestamp updated) {
		super();
		this.date = date;
		this.ticker = ticker;
		this.updated = updated;
	}

	
	
}
