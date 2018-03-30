package com.core.isonsoft.beans;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "STAGCCEXGETMARKETSUMMARIES")
public class StagCcexgetMarktSummResult {

	private int id;

	public String MarketName;
	public String High;
	public String Low;
	public String Volume;
	public String Last;
	public String BaseVolume;
	public long TimeStamp;
	public String Bid;
	public String Ask;
	public String OpenBuyOrders;
	public String OpenSellOrders;
	public String PrevDay;
	public String Created;
	public String DisplayMarketName;
	
	public Timestamp updated;

	public StagCcexgetMarktSummResult() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarketName() {
		return MarketName;
	}

	public void setMarketName(String marketName) {
		MarketName = marketName;
	}

	public String getHigh() {
		return High;
	}

	public void setHigh(String high) {
		High = high;
	}

	public String getLow() {
		return Low;
	}

	public void setLow(String low) {
		Low = low;
	}

	public String getVolume() {
		return Volume;
	}

	public void setVolume(String volume) {
		Volume = volume;
	}

	public String getLast() {
		return Last;
	}

	public void setLast(String last) {
		Last = last;
	}

	public String getBaseVolume() {
		return BaseVolume;
	}

	public void setBaseVolume(String baseVolume) {
		BaseVolume = baseVolume;
	}
	@javax.persistence.Transient
	public long getTimeStamp() {
		return TimeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		TimeStamp = timeStamp;
	}

	public String getBid() {
		return Bid;
	}

	public void setBid(String bid) {
		Bid = bid;
	}

	public String getAsk() {
		return Ask;
	}

	public void setAsk(String ask) {
		Ask = ask;
	}

	public String getOpenBuyOrders() {
		return OpenBuyOrders;
	}

	public void setOpenBuyOrders(String openBuyOrders) {
		OpenBuyOrders = openBuyOrders;
	}

	public String getOpenSellOrders() {
		return OpenSellOrders;
	}

	public void setOpenSellOrders(String openSellOrders) {
		OpenSellOrders = openSellOrders;
	}

	public String getPrevDay() {
		return PrevDay;
	}

	public void setPrevDay(String prevDay) {
		PrevDay = prevDay;
	}

	@javax.persistence.Transient
	public String getCreated() {

		return Created;
	}

	public void setCreated(String created) {
		Created = created;
	}

	public String getDisplayMarketName() {
		return DisplayMarketName;
	}

	public void setDisplayMarketName(String displayMarketName) {
		DisplayMarketName = displayMarketName;
	}

	@Override
	public String toString() {
		return "StagCcexgetMarktSummResult [id=" + id + ", MarketName="
				+ MarketName + ", High=" + High + ", Low=" + Low + ", Volume="
				+ Volume + ", Last=" + Last + ", BaseVolume=" + BaseVolume
				+ ", TimeStamp=" + TimeStamp + ", Bid=" + Bid + ", Ask=" + Ask
				+ ", OpenBuyOrders=" + OpenBuyOrders + ", OpenSellOrders="
				+ OpenSellOrders + ", PrevDay=" + PrevDay + ", Created="
				+ Created + ", DisplayMarketName=" + DisplayMarketName
				+ ", updated=" + updated + "]";
	}

	

	public Timestamp getUpdated() {

		return new Timestamp(getTimeStamp()*1000L);
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public StagCcexgetMarktSummResult(int id, String marketName, String high,
			String low, String volume, String last, String baseVolume,
			long timeStamp, String bid, String ask, String openBuyOrders,
			String openSellOrders, String prevDay, String created,
			String displayMarketName, Timestamp updated) {
		super();
		this.id = id;
		MarketName = marketName;
		High = high;
		Low = low;
		Volume = volume;
		Last = last;
		BaseVolume = baseVolume;
		TimeStamp = timeStamp;
		Bid = bid;
		Ask = ask;
		OpenBuyOrders = openBuyOrders;
		OpenSellOrders = openSellOrders;
		PrevDay = prevDay;
		Created = created;
		DisplayMarketName = displayMarketName;
		this.updated = updated;
	}
	
	

}
