package com.core.isonsoft.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STAGBITSTOCKORDER")
public class StagBitStockOrderBean {
	public int id;
	public String asks;
	public String bids;
	public double price;
	public double volume;
	public double value;

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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "StagBitStockOrderBean [id=" + id + ", asks=" + asks + ", bids="
				+ bids + ", price=" + price + ", volume=" + volume + ", value="
				+ value + "]";
	}

}
