package com.core.isonsoft.beans;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StagAllCoinsTicker")
public class StagAllCoinsTickerBean {

	public int id;
	public String buy;
	public String high;
	public String last;
	public String low;
	public String sell;
	public String vol;
	public Timestamp updated;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBuy() {
		return buy;
	}

	public void setBuy(String buy) {
		this.buy = buy;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getSell() {
		return sell;
	}

	public void setSell(String sell) {
		this.sell = sell;
	}

	public String getVol() {
		return vol;
	}

	public void setVol(String vol) {
		this.vol = vol;
	}

	@Override
	public String toString() {
		return "StagAllCoinsTickerBean [id=" + id + ", buy=" + buy + ", high="
				+ high + ", last=" + last + ", low=" + low + ", sell=" + sell
				+ ", vol=" + vol + ", date=" + updated + "]";
	}

	

	public StagAllCoinsTickerBean() {

	}

	

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public StagAllCoinsTickerBean(int id, String buy, String high, String last,
			String low, String sell, String vol, Timestamp updated) {
		super();
		this.id = id;
		this.buy = buy;
		this.high = high;
		this.last = last;
		this.low = low;
		this.sell = sell;
		this.vol = vol;
		this.updated = updated;
	}
	
	
	

}
