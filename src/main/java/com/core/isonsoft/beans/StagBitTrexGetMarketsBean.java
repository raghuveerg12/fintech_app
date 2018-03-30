package com.core.isonsoft.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "StagBitTrexGetMarkets")
public class StagBitTrexGetMarketsBean {

	public int id;
	public String MarketCurrency;
	public String BaseCurrency;
	public String MarketCurrencyLong;
	public String BaseCurrencyLong;
	public double MinTradeSize;
	public String MarketName;
	public String IsActive;
	public String Created;
	public String Notice;
	public String IsSponsored;
	public String LogoUrl;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	public String getMarketCurrency() {
		return MarketCurrency;
	}

	public void setMarketCurrency(String marketCurrency) {
		MarketCurrency = marketCurrency;
	}

	public String getBaseCurrency() {
		return BaseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		BaseCurrency = baseCurrency;
	}

	public String getMarketCurrencyLong() {
		return MarketCurrencyLong;
	}

	public void setMarketCurrencyLong(String marketCurrencyLong) {
		MarketCurrencyLong = marketCurrencyLong;
	}

	public String getBaseCurrencyLong() {
		return BaseCurrencyLong;
	}

	public void setBaseCurrencyLong(String baseCurrencyLong) {
		BaseCurrencyLong = baseCurrencyLong;
	}

	public double getMinTradeSize() {
		return MinTradeSize;
	}

	public void setMinTradeSize(double minTradeSize) {
		MinTradeSize = minTradeSize;
	}

	public String getMarketName() {
		return MarketName;
	}

	public void setMarketName(String marketName) {
		MarketName = marketName;
	}

	public String getIsActive() {
		return IsActive;
	}

	public void setIsActive(String isActive) {
		IsActive = isActive;
	}

	public String getCreated() {
		return Created;
	}

	public void setCreated(String created) {
		Created = created;
	}

	@Lob
	public String getNotice() {
		return Notice;
	}

	public void setNotice(String notice) {
		Notice = notice;
	}

	public String getIsSponsored() {
		return IsSponsored;
	}

	public void setIsSponsored(String isSponsored) {
		IsSponsored = isSponsored;
	}

	public String isLogoUrl() {
		return LogoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		LogoUrl = logoUrl;
	}

	
	
	
	public StagBitTrexGetMarketsBean(int id, String marketCurrency,
			String baseCurrency, String marketCurrencyLong,
			String baseCurrencyLong, double minTradeSize, String marketName,
			String isActive, String created, String notice, String isSponsored,
			String logoUrl) {
		super();
		this.id = id;
		MarketCurrency = marketCurrency;
		BaseCurrency = baseCurrency;
		MarketCurrencyLong = marketCurrencyLong;
		BaseCurrencyLong = baseCurrencyLong;
		MinTradeSize = minTradeSize;
		MarketName = marketName;
		IsActive = isActive;
		Created = created;
		Notice = notice;
		IsSponsored = isSponsored;
		LogoUrl = logoUrl;
	}

	@Override
	public String toString() {
		return "StagBitTrexGetMarketsBean [id=" + id + ", MarketCurrency="
				+ MarketCurrency + ", BaseCurrency=" + BaseCurrency
				+ ", MarketCurrencyLong=" + MarketCurrencyLong
				+ ", BaseCurrencyLong=" + BaseCurrencyLong + ", MinTradeSize="
				+ MinTradeSize + ", MarketName=" + MarketName + ", IsActive="
				+ IsActive + ", Created=" + Created + ", Notice=" + Notice
				+ ", IsSponsored=" + IsSponsored + ", LogoUrl=" + LogoUrl + "]";
	}

	public StagBitTrexGetMarketsBean() {

	}

}
