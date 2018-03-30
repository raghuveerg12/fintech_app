package com.core.isonsoft.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StagBitTrexGetCurrencies")
public class StagBitTrexGetCurrenciesBean {

	public int id;
	public String currency;
	public String currencyLong;
	public String minConfirmation;
	public double txFee;
	public boolean active;
	public String cointype;
	public String baseAddress;
	public String notice;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	

	public void setId(int id) {
		this.id = id;
	}
	
	
	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrencyLong() {
		return currencyLong;
	}

	public void setCurrencyLong(String currencyLong) {
		this.currencyLong = currencyLong;
	}

	public String getMinConfirmation() {
		return minConfirmation;
	}

	public void setMinConfirmation(String minConfirmation) {
		this.minConfirmation = minConfirmation;
	}

	public double getTxFee() {
		return txFee;
	}

	public void setTxFee(double txFee) {
		this.txFee = txFee;
	}

	public String getCointype() {
		return cointype;
	}

	public void setCointype(String cointype) {
		this.cointype = cointype;
	}

	public String getBaseAddress() {
		return baseAddress;
	}

	public void setBaseAddress(String baseAddress) {
		this.baseAddress = baseAddress;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public StagBitTrexGetCurrenciesBean(int id, String currency,
			String currencyLong, String minConfirmation, double txFee,
			boolean isActive, String cointype, String baseAddress, String notice) {
		super();
		this.id = id;
		this.currency = currency;
		this.currencyLong = currencyLong;
		this.minConfirmation = minConfirmation;
		this.txFee = txFee;
		this.active = isActive;
		this.cointype = cointype;
		this.baseAddress = baseAddress;
		this.notice = notice;
	}

	public StagBitTrexGetCurrenciesBean() {

	}

}
