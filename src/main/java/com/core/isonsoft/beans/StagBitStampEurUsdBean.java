package com.core.isonsoft.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StagBitStampEurUsd")
public class StagBitStampEurUsdBean {

	public int id;
	public double sell;
	public double buy;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSell() {
		return sell;
	}

	public void setSell(double sell) {
		this.sell = sell;
	}

	public double getBuy() {
		return buy;
	}

	public void setBuy(double buy) {
		this.buy = buy;
	}

	@Override
	public String toString() {
		return "StagBitStampEurUsdBean [id=" + id + ", sell=" + sell + ", buy="
				+ buy + "]";
	}

	public StagBitStampEurUsdBean(int id, double sell, double buy) {
		super();
		this.id = id;
		this.sell = sell;
		this.buy = buy;
	}

	public StagBitStampEurUsdBean() {

	}

}
