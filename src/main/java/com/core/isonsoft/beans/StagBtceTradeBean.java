package com.core.isonsoft.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "StagBtceTrade")
public class StagBtceTradeBean {

	public int id;
	public String type;
	public Double price;
	public Double amount;
	public Double tid;
	public long timestamp;
	public Timestamp updated;

	
	@Column(name="timestamp")
	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getTid() {
		return tid;
	}

	public void setTid(Double tid) {
		this.tid = tid;
	}

	@Transient
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "StagBtceTradeBean [id=" + id + ", type=" + type + ", price="
				+ price + ", amount=" + amount + ", tid=" + tid
				+ ", timestamp=" + timestamp + "]";
	}

	public StagBtceTradeBean(int id, String type, Double price, Double amount,
			Double tid, long timestamp) {
		super();
		this.id = id;
		this.type = type;
		this.price = price;
		this.amount = amount;
		this.tid = tid;
		this.timestamp = timestamp;
	}

	public StagBtceTradeBean() {

	}

}
