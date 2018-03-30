package com.core.isonsoft.beans;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "StagAllCoinTrades")
public class StagAllCoinTradesBean {

	public int id;
	public Timestamp dateFeed;
	public Timestamp dateFeed_ms;
	
	
	

	public double amount;
	public double price;
	public String type;
	public long tid;
	public long date;
	public long date_ms;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDateFeed() {

		return new Timestamp(getDate());
	}

	

	public Timestamp getDateFeed_ms() {
		return new Timestamp(getDate_ms());
	}

	

	
	public void setDateFeed(Timestamp dateFeed) {
		this.dateFeed = new Timestamp(getDate()*1000L);
	}

	public void setDateFeed_ms(Timestamp dateFeed_ms) {

		this.dateFeed_ms = new Timestamp(getDate_ms());
	}
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	@Override
	public String toString() {
		return "StagAllCoinTradesBean [id=" + id + ", dateFeed=" + dateFeed
				+ ", dateFeed_ms=" + dateFeed_ms + ", amount=" + amount
				+ ", price=" + price + ", type=" + type + ", tid=" + tid
				+ ", date=" + date + ", date_ms=" + date_ms + "]";
	}

	

	public StagAllCoinTradesBean(int id, Timestamp dateFeed,
			Timestamp dateFeed_ms, double amount, double price, String type,
			long tid, long date, long date_ms) {
		super();
		this.id = id;
		this.dateFeed = dateFeed;
		this.dateFeed_ms = dateFeed_ms;
		this.amount = amount;
		this.price = price;
		this.type = type;
		this.tid = tid;
		this.date = date;
		this.date_ms = date_ms;
	}

	public StagAllCoinTradesBean() {

	}

	@Transient
	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}
	@Transient
	public long getDate_ms() {
		return date_ms;
	}

	public void setDate_ms(long date_ms) {
		this.date_ms = date_ms;
	}
	
	

}
