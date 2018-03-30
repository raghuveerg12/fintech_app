package com.core.isonsoft.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STAGCCEXGETMARKETHISTORY")
public class StagCcexGetMarketHistoryBean {

	public int Id;
	public long feedId;
	public String TimeStamp;
	public double Quantity;
	public double Price;
	public double Total;
	public String FillType;
	public String OrderType;

	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public long getFeedId() {
		return feedId;
	}

	public void setFeedId(long feedId) {
		this.feedId = feedId;
	}

	public String getTimeStamp() {
		return TimeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		TimeStamp = timeStamp;
	}

	public double getQuantity() {
		return Quantity;
	}

	public void setQuantity(double quantity) {
		Quantity = quantity;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		Total = total;
	}

	public String getFillType() {
		return FillType;
	}

	public void setFillType(String fillType) {
		FillType = fillType;
	}

	public String getOrderType() {
		return OrderType;
	}

	public void setOrderType(String orderType) {
		OrderType = orderType;
	}

	@Override
	public String toString() {
		return "StagCcexGetMarketHistoryBean [Id=" + Id + ", feedId=" + feedId
				+ ", TimeStamp=" + TimeStamp + ", Quantity=" + Quantity
				+ ", Price=" + Price + ", Total=" + Total + ", FillType="
				+ FillType + ", OrderType=" + OrderType + "]";
	}
	
	

	}
