package com.core.isonsoft.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StagBitTrexGetCurrencies")
public class StagBitTrexGetCurrencieBean {
	
	public int id;
	public String Currency;
	public String CurrencyLong;
	public String MinConfirmation;
	public double TxFee;
	public String IsActive;
	public String CoinType;
	public String BaseAddress;
	public String Notice;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String currency) {
		Currency = currency;
	}
	public String getCurrencyLong() {
		return CurrencyLong;
	}
	public void setCurrencyLong(String currencyLong) {
		CurrencyLong = currencyLong;
	}
	public String getMinConfirmation() {
		return MinConfirmation;
	}
	public void setMinConfirmation(String minConfirmation) {
		MinConfirmation = minConfirmation;
	}
	public double getTxFee() {
		return TxFee;
	}
	public void setTxFee(double txFee) {
		TxFee = txFee;
	}
	public String isIsActive() {
		return IsActive;
	}
	public void setIsActive(String isActive) {
		IsActive = isActive;
	}
	public String getCoinType() {
		return CoinType;
	}
	public void setCoinType(String coinType) {
		CoinType = coinType;
	}
	public String getBaseAddress() {
		return BaseAddress;
	}
	public void setBaseAddress(String baseAddress) {
		BaseAddress = baseAddress;
	}
	public String getNotice() {
		return Notice;
	}
	public void setNotice(String notice) {
		Notice = notice;
	}
	@Override
	public String toString() {
		return "StagBitTrexGetCurrencieBean [id=" + id + ", Currency="
				+ Currency + ", CurrencyLong=" + CurrencyLong
				+ ", MinConfirmation=" + MinConfirmation + ", TxFee=" + TxFee
				+ ", IsActive=" + IsActive + ", CoinType=" + CoinType
				+ ", BaseAddress=" + BaseAddress + ", Notice=" + Notice + "]";
	}
	public StagBitTrexGetCurrencieBean(int id, String currency,
			String currencyLong, String minConfirmation, double txFee,
			String isActive, String coinType, String baseAddress, String notice) {
		super();
		this.id = id;
		Currency = currency;
		CurrencyLong = currencyLong;
		MinConfirmation = minConfirmation;
		TxFee = txFee;
		IsActive = isActive;
		CoinType = coinType;
		BaseAddress = baseAddress;
		Notice = notice;
	}
	
	
	public StagBitTrexGetCurrencieBean(){
		
	}

}
