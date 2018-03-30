package com.core.isonsoft.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stagbtcedepth")
public class StagBtcDepthBean {

	public int id;
	public String asks;
	public String bids;

	public String price;
	public String volume;

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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "StagAllCoinDepthMainBean [asks=" + asks + ", bids=" + bids
				+ ", price=" + price + ", volume=" + volume + "]";
	}

	public StagBtcDepthBean(String asks, String bids, String price,
			String volume) {
		super();
		this.asks = asks;
		this.bids = bids;
		this.price = price;
		this.volume = volume;
	}

	public StagBtcDepthBean() {

	}

}
