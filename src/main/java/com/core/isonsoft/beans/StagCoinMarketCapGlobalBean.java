package com.core.isonsoft.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STAGCOINMARKETCAPGLOBAL")
public class StagCoinMarketCapGlobalBean {

	public int id;
	public double total_market_cap_usd;
	public double total_24h_volume_usd;
	public double bitcoin_percentage_of_market_cap;
	public double active_currencies;
	public double active_assets;
	public double active_markets;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "Totalmrktcapusd")
	public double getTotal_market_cap_usd() {
		return total_market_cap_usd;
	}

	public void setTotal_market_cap_usd(double total_market_cap_usd) {
		this.total_market_cap_usd = total_market_cap_usd;
	}

	@Column(name = "Total24hvolusd")
	public double getTotal_24h_volume_usd() {
		return total_24h_volume_usd;
	}

	public void setTotal_24h_volume_usd(double total_24h_volume_usd) {
		this.total_24h_volume_usd = total_24h_volume_usd;
	}

	@Column(name = "Bitcoinprctgofmrktcap")
	public double getBitcoin_percentage_of_market_cap() {
		return bitcoin_percentage_of_market_cap;
	}

	public void setBitcoin_percentage_of_market_cap(
			double bitcoin_percentage_of_market_cap) {
		this.bitcoin_percentage_of_market_cap = bitcoin_percentage_of_market_cap;
	}

	@Column(name = "activecurrencies")
	public double getActive_currencies() {
		return active_currencies;
	}

	public void setActive_currencies(double active_currencies) {
		this.active_currencies = active_currencies;
	}

	@Column(name = "activeassets")
	public double getActive_assets() {
		return active_assets;
	}

	public void setActive_assets(double active_assets) {
		this.active_assets = active_assets;
	}

	@Column(name = "activemarkets")
	public double getActive_markets() {
		return active_markets;
	}

	public void setActive_markets(double active_markets) {
		this.active_markets = active_markets;
	}

	@Override
	public String toString() {
		return "StagCoinMarketCapGlobalBean [id=" + id
				+ ", total_market_cap_usd=" + total_market_cap_usd
				+ ", total_24h_volume_usd=" + total_24h_volume_usd
				+ ", bitcoin_percentage_of_market_cap="
				+ bitcoin_percentage_of_market_cap + ", active_currencies="
				+ active_currencies + ", active_assets=" + active_assets
				+ ", active_markets=" + active_markets + "]";
	}

	public StagCoinMarketCapGlobalBean(int id, double total_market_cap_usd,
			double total_24h_volume_usd,
			double bitcoin_percentage_of_market_cap, double active_currencies,
			double active_assets, double active_markets) {
		super();
		this.id = id;
		this.total_market_cap_usd = total_market_cap_usd;
		this.total_24h_volume_usd = total_24h_volume_usd;
		this.bitcoin_percentage_of_market_cap = bitcoin_percentage_of_market_cap;
		this.active_currencies = active_currencies;
		this.active_assets = active_assets;
		this.active_markets = active_markets;
	}

	public StagCoinMarketCapGlobalBean() {

	}
}
