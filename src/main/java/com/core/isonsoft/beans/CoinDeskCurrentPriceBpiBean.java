package com.core.isonsoft.beans;

import javax.persistence.Transient;

public class CoinDeskCurrentPriceBpiBean {

	@Transient
	public CoinDeskCurrentPriceBpiCodesBean USD;
	@Transient
	public CoinDeskCurrentPriceBpiCodesBean GBP;
	@Transient
	public CoinDeskCurrentPriceBpiCodesBean EUR;

	public CoinDeskCurrentPriceBpiCodesBean getUSD() {
		return USD;
	}

	public void setUSD(CoinDeskCurrentPriceBpiCodesBean uSD) {
		USD = uSD;
	}

	public CoinDeskCurrentPriceBpiCodesBean getGBP() {
		return GBP;
	}

	public void setGBP(CoinDeskCurrentPriceBpiCodesBean gBP) {
		GBP = gBP;
	}

	public CoinDeskCurrentPriceBpiCodesBean getEUR() {
		return EUR;
	}

	public void setEUR(CoinDeskCurrentPriceBpiCodesBean eUR) {
		EUR = eUR;
	}

	@Override
	public String toString() {
		return "CoinDeskCurrentPriceBpiBean [USD=" + USD + ", GBP=" + GBP
				+ ", EUR=" + EUR + "]";
	}

	public CoinDeskCurrentPriceBpiBean(CoinDeskCurrentPriceBpiCodesBean uSD,
			CoinDeskCurrentPriceBpiCodesBean gBP,
			CoinDeskCurrentPriceBpiCodesBean eUR) {
		super();
		USD = uSD;
		GBP = gBP;
		EUR = eUR;
	}

	public CoinDeskCurrentPriceBpiBean() {

	}

}
