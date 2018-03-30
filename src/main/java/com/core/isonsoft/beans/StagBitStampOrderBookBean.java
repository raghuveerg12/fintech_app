package com.core.isonsoft.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StagBitStampOrderBook")
public class StagBitStampOrderBookBean {

	public int id;
	public String asks;
	public String bids;

	public double price;
	public double volume;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAsks() {
		return asks;
	}

	public void setAsks(String asks) {
		this.asks = asks;
	}

	public String getBids() {
		return bids;
	}

	public void setBids(String bids) {
		this.bids = bids;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "StagAllCoinDepthMainBean [asks=" + asks + ", bids=" + bids
				+ ", price=" + price + ", volume=" + volume + "]";
	}

	public StagBitStampOrderBookBean(String asks, String bids, double price,
			double volume) {
		super();
		this.asks = asks;
		this.bids = bids;
		this.price = price;
		this.volume = volume;
	}

	public StagBitStampOrderBookBean() {

	}

}
