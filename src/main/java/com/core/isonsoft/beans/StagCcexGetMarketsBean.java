package com.core.isonsoft.beans;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STAGCCEXGETMARKETS")
public class StagCcexGetMarketsBean {

	public int id;
	public String marketCurrency;
	public String baseCurrency;
	public String marketCurrencyLong;
	public String baseCurrencyLong;
	public double minTradeSize;
	public String marketName;
	public String isActive;
	public Timestamp created;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarketCurrency() {
		return marketCurrency;
	}

	public void setMarketCurrency(String marketCurrency) {
		this.marketCurrency = marketCurrency;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getMarketCurrencyLong() {
		return marketCurrencyLong;
	}

	public void setMarketCurrencyLong(String marketCurrencyLong) {
		this.marketCurrencyLong = marketCurrencyLong;
	}

	public String getBaseCurrencyLong() {
		return baseCurrencyLong;
	}

	public void setBaseCurrencyLong(String baseCurrencyLong) {
		this.baseCurrencyLong = baseCurrencyLong;
	}

	public double getMinTradeSize() {
		return minTradeSize;
	}

	public void setMinTradeSize(double minTradeSize) {
		this.minTradeSize = minTradeSize;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String isActive() {
		return isActive;
	}

	public void setActive(String isActive) {
		this.isActive = isActive;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "StagCcexGetMarketsBean [id=" + id + ", marketCurrency="
				+ marketCurrency + ", baseCurrency=" + baseCurrency
				+ ", marketCurrencyLong=" + marketCurrencyLong
				+ ", baseCurrencyLong=" + baseCurrencyLong + ", minTradeSize="
				+ minTradeSize + ", marketName=" + marketName + ", isActive="
				+ isActive + ", created=" + created + "]";
	}

}
