package com.core.isonsoft.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "StagCoinDeskCurrentPrice")
public class CoinDeskCurrentPriceTimeBean {

	public String updated;

	public String updatedISO;

	public String updateduk;

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getUpdatedISO() {
		return updatedISO;
	}

	public void setUpdatedISO(String updatedISO) {
		this.updatedISO = updatedISO;
	}

	public String getUpdateduk() {
		return updateduk;
	}

	public void setUpdateduk(String updateduk) {
		this.updateduk = updateduk;
	}

	@Override
	public String toString() {
		return "CoinDeskCurrentPriceTimeBean [updated=" + updated
				+ ", updatedISO=" + updatedISO + ", updateduk=" + updateduk
				+ "]";
	}

	public CoinDeskCurrentPriceTimeBean(String updated, String updatedISO,
			String updateduk) {
		super();
		this.updated = updated;
		this.updatedISO = updatedISO;
		this.updateduk = updateduk;
	}

	public CoinDeskCurrentPriceTimeBean() {

	}

}
