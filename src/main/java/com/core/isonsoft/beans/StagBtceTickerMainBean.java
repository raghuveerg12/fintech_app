package com.core.isonsoft.beans;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StagBtceTicker")
public class StagBtceTickerMainBean {

	public int id;

	public String fieldName;

	public double high;
	public double low;
	public double vol;
	public double vol_cur;
	public double last;
	public double buy;
	public double sell;
	public Timestamp updated;
	public double avg;

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	/*public Map<String, String> btc_usd;
	public Map<String, String> btc_rur;
	public Map<String, String> btc_eur;
	public Map<String, String> ltc_btc;
	public Map<String, String> ltc_usd;
	public Map<String, String> ltc_rur;
	public Map<String, String> ltc_eur;
	public Map<String, String> nmc_btc;
	public Map<String, String> nmc_usd;
	public Map<String, String> nvc_btc;
	public Map<String, String> nvc_usd;
	public Map<String, String> usd_rur;
	
	
	public Map<String, String> eur_usd;
	public Map<String, String> eur_rur;
	public Map<String, String> ppc_btc;
	public Map<String, String> ppc_usd;
	public Map<String, String> dsh_btc;
	public Map<String, String> eth_btc;
	public Map<String, String> eth_usd;
	public Map<String, String> eth_ltc;
	public Map<String, String> eth_rur;
*/	

		@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getVol() {
		return vol;
	}

	public void setVol(double vol) {
		this.vol = vol;
	}

	public double getVol_cur() {
		return vol_cur;
	}

	public void setVol_cur(double vol_cur) {
		this.vol_cur = vol_cur;
	}

	public double getLast() {
		return last;
	}

	public void setLast(double last) {
		this.last = last;
	}

	public double getBuy() {
		return buy;
	}

	public void setBuy(double buy) {
		this.buy = buy;
	}

	public double getSell() {
		return sell;
	}

	public void setSell(double sell) {
		this.sell = sell;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	
	@Override
	public String toString() {
		return "StagBtceTickerMainBean [id=" + id + ", fieldName=" + fieldName
				+ ", high=" + high + ", low=" + low + ", vol=" + vol
				+ ", vol_cur=" + vol_cur + ", last=" + last + ", buy=" + buy
				+ ", sell=" + sell + ", updated=" + updated + ", avg=" + avg
				+ "]";
	}

	public StagBtceTickerMainBean(int id, String fieldName, double high,
			double low, double vol, double vol_cur, double last, double buy,
			double sell, Timestamp updated, double avg) {
		super();
		this.id = id;
		this.fieldName = fieldName;
		this.high = high;
		this.low = low;
		this.vol = vol;
		this.vol_cur = vol_cur;
		this.last = last;
		this.buy = buy;
		this.sell = sell;
		this.updated = updated;
		this.avg = avg;
	}

	public StagBtceTickerMainBean() {

	}

}
