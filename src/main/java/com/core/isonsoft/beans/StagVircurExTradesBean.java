package com.core.isonsoft.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StagVircurExTrades")
public class StagVircurExTradesBean {

	public int id;
	public String date;
	public String tid;
	public String amount;
	public String price;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "StagVircurExTradesBean [date=" + date + ", tid=" + tid
				+ ", amount=" + amount + ", price=" + price + "]";
	}

	public StagVircurExTradesBean(String date, String tid, String amount,
			String price) {
		super();
		this.date = date;
		this.tid = tid;
		this.amount = amount;
		this.price = price;
	}

	public StagVircurExTradesBean() {

	}
}
