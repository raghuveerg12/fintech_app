package com.core.isonsoft.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StagBitTrexGetMarketHistory")
public class StagBitTrexGetMarketHistoryBean {
	public int id;
	public String timeStamp;
	public long idFeed;
	public double quatity;
	public double price;
	public double total;
	public String fillType;
	public String orderType;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public long getIdFeed() {
		return idFeed;
	}

	public void setIdFeed(long idFeed) {
		this.idFeed = idFeed;
	}

	public double getQuatity() {
		return quatity;
	}

	public void setQuatity(double quatity) {
		this.quatity = quatity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getFillType() {
		return fillType;
	}

	public void setFillType(String fillType) {
		this.fillType = fillType;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	@Override
	public String toString() {
		return "StagBitTrexGetMarketHistoryBean [id=" + id + ", timeStamp="
				+ timeStamp + ", idFeed=" + idFeed + ", quatity=" + quatity
				+ ", price=" + price + ", total=" + total + ", fillType="
				+ fillType + ", orderType=" + orderType + "]";
	}

	public StagBitTrexGetMarketHistoryBean(int id, String timeStamp,
			long idFeed, double quatity, double price, double total,
			String fillType, String orderType) {
		super();
		this.id = id;
		this.timeStamp = timeStamp;
		this.idFeed = idFeed;
		this.quatity = quatity;
		this.price = price;
		this.total = total;
		this.fillType = fillType;
		this.orderType = orderType;
	}

	public StagBitTrexGetMarketHistoryBean() {

	}

}
