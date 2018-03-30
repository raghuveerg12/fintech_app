package com.core.isonsoft.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STAGCOINMARKETCAPTICKER")
public class StagCoinMarketCapTickerBean {

	public String id;
	public int name_id;
	public String name;
	public String symbol;
	public long rank;
	public double price_usd;
	public double price_btc;
	public double h_volume_usd;
	public double market_cap_usd;
	public double available_supply;
	public double total_supply;
	public double percent_change_1h;
	public double percent_change_24h;
	public double percent_change_7d;
	public Timestamp last_updated;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getName_id() {
		return name_id;
	}

	public void setName_id(int name_id) {
		this.name_id = name_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public long getRank() {
		return rank;
	}

	public void setRank(long rank) {
		this.rank = rank;
	}

	public double getPrice_usd() {
		return price_usd;
	}

	public void setPrice_usd(double price_usd) {
		this.price_usd = price_usd;
	}

	public double getPrice_btc() {
		return price_btc;
	}

	public void setPrice_btc(double price_btc) {
		this.price_btc = price_btc;
	}

	@Column(name = "Volume24hUsd")
	public double getH_volume_usd() {
		return h_volume_usd;
	}

	public void setH_volume_usd(double h_volume_usd) {
		this.h_volume_usd = h_volume_usd;
	}

	@Column(name = "MrktCapUSD")
	public double getMarket_cap_usd() {
		return market_cap_usd;
	}

	public void setMarket_cap_usd(double market_cap_usd) {
		this.market_cap_usd = market_cap_usd;
	}

	@Column(name = "avblSupply")
	public double getAvailable_supply() {
		return available_supply;
	}

	public void setAvailable_supply(double available_supply) {
		this.available_supply = available_supply;
	}

	public double getTotal_supply() {
		return total_supply;
	}

	public void setTotal_supply(double total_supply) {
		this.total_supply = total_supply;
	}

	@Column(name = "prcntchng1h")
	public double getPercent_change_1h() {
		return percent_change_1h;
	}

	public void setPercent_change_1h(double percent_change_1h) {
		this.percent_change_1h = percent_change_1h;
	}

	@Column(name = "prcntchng24h")
	public double getPercent_change_24h() {
		return percent_change_24h;
	}

	public void setPercent_change_24h(double percent_change_24h) {
		this.percent_change_24h = percent_change_24h;
	}

	@Column(name = "prcntchng7d")
	public double getPercent_change_7d() {
		return percent_change_7d;
	}

	public void setPercent_change_7d(double percent_change_7d) {
		this.percent_change_7d = percent_change_7d;
	}

	@Column(name = "updated")
	public Timestamp getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(Timestamp last_updated) {
		this.last_updated = last_updated;
	}

	public StagCoinMarketCapTickerBean(String id, int name_id, String name,
			String symbol, long rank, double price_usd, double price_btc,
			double h_volume_usd, double market_cap_usd,
			double available_supply, double total_supply,
			double percent_change_1h, double percent_change_24h,
			double percent_change_7d, Timestamp last_updated) {
		super();
		this.id = id;
		this.name_id = name_id;
		this.name = name;
		this.symbol = symbol;
		this.rank = rank;
		this.price_usd = price_usd;
		this.price_btc = price_btc;
		this.h_volume_usd = h_volume_usd;
		this.market_cap_usd = market_cap_usd;
		this.available_supply = available_supply;
		this.total_supply = total_supply;
		this.percent_change_1h = percent_change_1h;
		this.percent_change_24h = percent_change_24h;
		this.percent_change_7d = percent_change_7d;
		this.last_updated = last_updated;
	}

	public StagCoinMarketCapTickerBean() {

	}

}
