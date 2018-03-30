package com.core.isonsoft.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StagVirCurExCurrency")
public class StagVirCurExCurrencyBean {

	public int id;

	public String base;
	public String alt;
	public Double lowest_ask;
	public Double highest_bid;
	public Double last_trade;
	public Double volume;
	public Double status;
	public String value;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Double getLowest_ask() {
		return lowest_ask;
	}

	public void setLowest_ask(Double lowest_ask) {
		this.lowest_ask = lowest_ask;
	}

	public Double getHighest_bid() {
		return highest_bid;
	}

	public void setHighest_bid(Double highest_bid) {
		this.highest_bid = highest_bid;
	}

	public Double getLast_trade() {
		return last_trade;
	}

	public void setLast_trade(Double last_trade) {
		this.last_trade = last_trade;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Double getStatus() {
		return status;
	}

	public void setStatus(Double status) {
		this.status = status;
	}

	public StagVirCurExCurrencyBean(int id, String base, String alt,
			Double lowest_ask, Double highest_bid, Double last_trade,
			Double volume, Double status, String value) {
		super();
		this.id = id;
		this.base = base;
		this.alt = alt;
		this.lowest_ask = lowest_ask;
		this.highest_bid = highest_bid;
		this.last_trade = last_trade;
		this.volume = volume;
		this.status = status;
		this.value = value;
	}

	@Override
	public String toString() {
		return "StagVirCurExCurrencyBean [id=" + id + ", base=" + base
				+ ", alt=" + alt + ", lowest_ask=" + lowest_ask
				+ ", highest_bid=" + highest_bid + ", last_trade=" + last_trade
				+ ", volume=" + volume + ", status=" + status + ", value="
				+ value + "]";
	}

	public StagVirCurExCurrencyBean() {

	}

}
