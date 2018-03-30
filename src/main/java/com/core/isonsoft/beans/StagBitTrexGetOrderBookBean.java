package com.core.isonsoft.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StagBitTrexGetOrderBook")
public class StagBitTrexGetOrderBookBean {

	public int id;
	public String quantity;
	public String rate;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "StagBitTrexGetOrderBookBean [id=" + id + ", quantity="
				+ quantity + ", rate=" + rate + "]";
	}

	public StagBitTrexGetOrderBookBean(int id, String quantity, String rate) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.rate = rate;
	}

	public StagBitTrexGetOrderBookBean() {

	}

}
