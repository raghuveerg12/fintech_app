package com.core.isonsoft.hibernate.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STAGCCEXGETMARKETSUMMARIES")
public class StagCcexgetMarktSummBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StagCcexgetMarktSummBean() {

	}

	private int id;
	private String marketName;
	private String high;
	private String low;
	private String volume;
	private String last;
	private String baseVolume;
	private String timeStamp;
	private String bid;
	private String ask;
	private String openBuyOrders;
	private String openSellOrders;
	private String prevDay;
	private String created;
	private String displayMarketName;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getBaseVolume() {
		return baseVolume;
	}

	public void setBaseVolume(String baseVolume) {
		this.baseVolume = baseVolume;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getAsk() {
		return ask;
	}

	public void setAsk(String ask) {
		this.ask = ask;
	}

	public String getOpenBuyOrders() {
		return openBuyOrders;
	}

	public void setOpenBuyOrders(String openBuyOrders) {
		this.openBuyOrders = openBuyOrders;
	}

	public String getOpenSellOrders() {
		return openSellOrders;
	}

	public void setOpenSellOrders(String openSellOrders) {
		this.openSellOrders = openSellOrders;
	}

	public String getPrevDay() {
		return prevDay;
	}

	public void setPrevDay(String prevDay) {
		this.prevDay = prevDay;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getDisplayMarketName() {
		return displayMarketName;
	}

	public void setDisplayMarketName(String displayMarketName) {
		this.displayMarketName = displayMarketName;
	}

	@Override
	public String toString() {
		return "StagCcexgetMarktSummBean [marketName=" + marketName + ", high="
				+ high + ", low=" + low + ", volume=" + volume + ", last="
				+ last + ", baseVolume=" + baseVolume + ", timeStamp="
				+ timeStamp + ", bid=" + bid + ", ask=" + ask
				+ ", openBuyOrders=" + openBuyOrders + ", openSellOrders="
				+ openSellOrders + ", prevDay=" + prevDay + ", created="
				+ created + ", displayMarketName=" + displayMarketName + "]";
	}

	public StagCcexgetMarktSummBean(String marketName, String high, String low,
			String volume, String last, String baseVolume, String timeStamp,
			String bid, String ask, String openBuyOrders,
			String openSellOrders, String prevDay, String created,
			String displayMarketName) {
		super();
		this.marketName = marketName;
		this.high = high;
		this.low = low;
		this.volume = volume;
		this.last = last;
		this.baseVolume = baseVolume;
		this.timeStamp = timeStamp;
		this.bid = bid;
		this.ask = ask;
		this.openBuyOrders = openBuyOrders;
		this.openSellOrders = openSellOrders;
		this.prevDay = prevDay;
		this.created = created;
		this.displayMarketName = displayMarketName;
	}

}
