package com.core.isonsoft.beans;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "StagBitStampTicker")
public class StagBitStampTickerBean {

	public int id;
	public double high;
	public double last;
	public long timestamp;
	public double bid;
	public double vwap;
	public double volume;
	public double low;
	public double ask;
	public double open;
	public Timestamp updated;
	
	
	
	

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLast() {
		return last;
	}

	public void setLast(double last) {
		this.last = last;
	}

	@Transient
	public long getTimeStamp() {
		return timestamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timestamp = timeStamp;
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

	public double getVwap() {
		return vwap;
	}

	public void setVwap(double vwap) {
		this.vwap = vwap;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getAsk() {
		return ask;
	}

	public void setAsk(double ask) {
		this.ask = ask;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	
	public StagBitStampTickerBean(int id, double high, double last,
			long timestamp, double bid, double vwap, double volume, double low,
			double ask, double open, Timestamp updated) {
		super();
		this.id = id;
		this.high = high;
		this.last = last;
		this.timestamp = timestamp;
		this.bid = bid;
		this.vwap = vwap;
		this.volume = volume;
		this.low = low;
		this.ask = ask;
		this.open = open;
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "StagBitStampTickerBean [id=" + id + ", high=" + high
				+ ", last=" + last + ", timestamp=" + timestamp + ", bid="
				+ bid + ", vwap=" + vwap + ", volume=" + volume + ", low="
				+ low + ", ask=" + ask + ", open=" + open + ", updated="
				+ updated + "]";
	}

	public StagBitStampTickerBean() {

	}

}
