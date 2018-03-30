package com.core.isonsoft.beans;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "StagBitStampTransactions")
public class StagBitStampTransactionsBean {

	public int id;
	public Timestamp feedDate;
	public double tid;
	public double price;
	public String type;
	public double amount;
	public long date;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Timestamp getFeedDate() {
		return feedDate;
	}

	public void setFeedDate(Timestamp date) {
		this.feedDate = date;
	}

	public double getTid() {
		return tid;
	}

	public void setTid(double tid) {
		this.tid = tid;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "StagBitStampTransactionsBean [id=" + id + ", feedDate="
				+ feedDate + ", tid=" + tid + ", price=" + price + ", type="
				+ type + ", amount=" + amount + ", date=" + date + "]";
	}

	public StagBitStampTransactionsBean(int id, Timestamp date, double tid,
			double price, String type, double amount) {
		super();
		this.id = id;
		this.feedDate = date;
		this.tid = tid;
		this.price = price;
		this.type = type;
		this.amount = amount;
	}

	public StagBitStampTransactionsBean() {

	}

	@Transient
	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public StagBitStampTransactionsBean(int id, Timestamp feedDate, double tid,
			double price, String type, double amount, long date) {
		super();
		this.id = id;
		this.feedDate = feedDate;
		this.tid = tid;
		this.price = price;
		this.type = type;
		this.amount = amount;
		this.date = date;
	}
	
	

}
