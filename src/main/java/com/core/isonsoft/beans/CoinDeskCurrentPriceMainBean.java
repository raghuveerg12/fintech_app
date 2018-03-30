package com.core.isonsoft.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "StagCoinDeskCurrentPrice")
public class CoinDeskCurrentPriceMainBean {

	public int id;

	public CoinDeskCurrentPriceTimeBean time;
	public String disclaimer;

	public CoinDeskCurrentPriceBpiBean bpi;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Transient
	public CoinDeskCurrentPriceTimeBean getTime() {
		return time;
	}

	public void setTime(CoinDeskCurrentPriceTimeBean time) {
		this.time = time;
	}

	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

	@Transient
	public CoinDeskCurrentPriceBpiBean getBpi() {
		return bpi;
	}

	public void setBpi(CoinDeskCurrentPriceBpiBean bpi) {
		this.bpi = bpi;
	}

	@Override
	public String toString() {
		return "CoinDeskCurrentPriceMainBean [time=" + time + ", disclaimer="
				+ disclaimer + ", bpi=" + bpi + "]";
	}

	public CoinDeskCurrentPriceMainBean(CoinDeskCurrentPriceTimeBean time,
			String disclaimer, CoinDeskCurrentPriceBpiBean bpi) {
		super();
		this.time = time;
		this.disclaimer = disclaimer;
		this.bpi = bpi;
	}

	public CoinDeskCurrentPriceMainBean() {

	}

}
