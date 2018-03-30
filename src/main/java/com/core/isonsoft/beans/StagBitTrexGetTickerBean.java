package com.core.isonsoft.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StagBitTrexGetTicker")
public class StagBitTrexGetTickerBean {

	public int id;
	public double asks;
	public double bids;
	public double last;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAsks() {
		return asks;
	}

	public void setAsks(double asks) {
		this.asks = asks;
	}

	public double getBids() {
		return bids;
	}

	public void setBids(double bids) {
		this.bids = bids;
	}

	public double getLast() {
		return last;
	}

	public void setLast(double last) {
		this.last = last;
	}

	@Override
	public String toString() {
		return "StagBitTrexGetTickerBean [id=" + id + ", asks=" + asks
				+ ", bids=" + bids + ", last=" + last + "]";
	}

	public StagBitTrexGetTickerBean(int id, double asks, double bids,
			double last) {
		super();
		this.id = id;
		this.asks = asks;
		this.bids = bids;
		this.last = last;
	}

	public StagBitTrexGetTickerBean() {

	}

}
