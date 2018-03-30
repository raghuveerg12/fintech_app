package com.core.isonsoft.hibernate.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StaggingTable")
public class VircurExTradesHiberBean {

	public int id;
	public String feedDate;
	public String tx_id;
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

	public String getFeedDate() {
		return feedDate;
	}

	public void setFeedDate(String date) {
		this.feedDate = date;
	}

	public String getTx_id() {
		return tx_id;
	}

	public void setTx_id(String tx_id) {
		this.tx_id = tx_id;
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
		return "StagVircurExTradesBean [date=" + feedDate + ", tid=" + tx_id
				+ ", amount=" + amount + ", price=" + price + "]";
	}

	public VircurExTradesHiberBean(String date, String tid, String amount,
			String price) {
		super();
		this.feedDate = date;
		this.tx_id = tid;
		this.amount = amount;
		this.price = price;
	}

	public VircurExTradesHiberBean() {

	}
}
