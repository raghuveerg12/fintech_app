package com.core.isonsoft.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StagCoinDeskCurrentPrice")
public class CoinDeskCurrentPriceTableDataBean {

	public String updated;

	public String updatedISO;

	public String updateduk;

	public int id;

	public String disclaimer;

	public String usdCode;
	public String usdSymbol;
	public String usdRate;
	public String usdDescription;
	public String usdRate_float;

	public String gbpCode;
	public String gbpSymbol;
	public String gbpRate;
	public String gbpDescription;
	public String gbpRate_float;

	public String eurCode;
	public String eurSymbol;
	public String eurRate;
	public String eurDescription;
	public String eurRate_float;

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

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

	public String getUsdCode() {
		return usdCode;
	}

	public void setUsdCode(String usdCode) {
		this.usdCode = usdCode;
	}

	public String getUsdSymbol() {
		return usdSymbol;
	}

	public void setUsdSymbol(String usdSymbol) {
		this.usdSymbol = usdSymbol;
	}

	public String getUsdRate() {
		return usdRate;
	}

	public void setUsdRate(String usdRate) {
		this.usdRate = usdRate;
	}

	public String getUsdDescription() {
		return usdDescription;
	}

	public void setUsdDescription(String usdDescription) {
		this.usdDescription = usdDescription;
	}

	public String getUsdRate_float() {
		return usdRate_float;
	}

	public void setUsdRate_float(String usdRate_float) {
		this.usdRate_float = usdRate_float;
	}

	public String getGbpCode() {
		return gbpCode;
	}

	public void setGbpCode(String gbpCode) {
		this.gbpCode = gbpCode;
	}

	public String getGbpSymbol() {
		return gbpSymbol;
	}

	public void setGbpSymbol(String gbpSymbol) {
		this.gbpSymbol = gbpSymbol;
	}

	public String getGbpRate() {
		return gbpRate;
	}

	public void setGbpRate(String gbpRate) {
		this.gbpRate = gbpRate;
	}

	public String getGbpDescription() {
		return gbpDescription;
	}

	public void setGbpDescription(String gbpDescription) {
		this.gbpDescription = gbpDescription;
	}

	public String getGbpRate_float() {
		return gbpRate_float;
	}

	public void setGbpRate_float(String gbpRate_float) {
		this.gbpRate_float = gbpRate_float;
	}

	public String getEurCode() {
		return eurCode;
	}

	public void setEurCode(String eurCode) {
		this.eurCode = eurCode;
	}

	public String getEurSymbol() {
		return eurSymbol;
	}

	public void setEurSymbol(String eurSymbol) {
		this.eurSymbol = eurSymbol;
	}

	public String getEurRate() {
		return eurRate;
	}

	public void setEurRate(String eurRate) {
		this.eurRate = eurRate;
	}

	public String getEurDescription() {
		return eurDescription;
	}

	public void setEurDescription(String eurDescription) {
		this.eurDescription = eurDescription;
	}

	public String getEurRate_float() {
		return eurRate_float;
	}

	public void setEurRate_float(String eurRate_float) {
		this.eurRate_float = eurRate_float;
	}

}
