package com.core.isonsoft.beans;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STAGCCEXPRICES")
public class StagCcexPricesBean {

	public int id;
	public String name;
	public double high;
	public double low;
	public double avg;
	public double lastBuy;
	public double lastSell;
	public double buy;
	public double sell;
	public double lastPrice;
	public Timestamp updated;

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

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public double getLastBuy() {
		return lastBuy;
	}

	public void setLastBuy(double lastBuy) {
		this.lastBuy = lastBuy;
	}

	public double getLastSell() {
		return lastSell;
	}

	public void setLastSell(double lastSell) {
		this.lastSell = lastSell;
	}

	public double getBuy() {
		return buy;
	}

	public void setBuy(double buy) {
		this.buy = buy;
	}

	public double getSell() {
		return sell;
	}

	public void setSell(double sell) {
		this.sell = sell;
	}

	public double getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StagCcexPricesBean [id=" + id + ", name=" + name + ", high="
				+ high + ", low=" + low + ", avg=" + avg + ", lastBuy="
				+ lastBuy + ", lastSell=" + lastSell + ", buy=" + buy
				+ ", sell=" + sell + ", lastPrice=" + lastPrice + ", updated="
				+ updated + "]";
	}

}
