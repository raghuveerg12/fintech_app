package com.core.isonsoft.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StagBitTrexGetMarketSummaries")
public class StagBitTrexGetMarketSummariesBean {

	public int id;
	public String MarketName;
	public double High;
	public double Low;
	public double Volume;
	public double Last;
	public double BaseVolume;
	public String TimeStamp;
	public String Created;
	public double Bid;
	public double Ask;
	public double OpenBuyOrders;
	public double OpenSellOrders;
	public double PrevDay;

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

	public double getHigh() {
		return High;
	}

	public void setHigh(double high) {
		High = high;
	}

	public double getLow() {
		return Low;
	}

	public void setLow(double low) {
		Low = low;
	}

	public double getVolume() {
		return Volume;
	}

	public void setVolume(double volume) {
		Volume = volume;
	}

	public double getLast() {
		return Last;
	}

	public void setLast(double last) {
		Last = last;
	}

	public double getBaseVolume() {
		return BaseVolume;
	}

	public void setBaseVolume(double baseVolume) {
		BaseVolume = baseVolume;
	}

	public String getTimeStamp() {
		return TimeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		TimeStamp = timeStamp;
	}

	public String getCreated() {
		return Created;
	}

	public void setCreated(String created) {
		Created = created;
	}

	public double getBid() {
		return Bid;
	}

	public void setBid(double bid) {
		Bid = bid;
	}

	public double getAsk() {
		return Ask;
	}

	public void setAsk(double ask) {
		Ask = ask;
	}

	public double getOpenBuyOrders() {
		return OpenBuyOrders;
	}

	public void setOpenBuyOrders(double openBuyOrders) {
		OpenBuyOrders = openBuyOrders;
	}

	public double getOpenSellOrders() {
		return OpenSellOrders;
	}

	public void setOpenSellOrders(double openSellOrders) {
		OpenSellOrders = openSellOrders;
	}

	public double getPrevDay() {
		return PrevDay;
	}

	public void setPrevDay(double prevDay) {
		PrevDay = prevDay;
	}

	@Override
	public String toString() {
		return "StagBitTrexGetMarketSummariesBean [id=" + id + ", MarketName="
				+ MarketName + ", High=" + High + ", Low=" + Low + ", Volume="
				+ Volume + ", Last=" + Last + ", BaseVolume=" + BaseVolume
				+ ", TimeStamp=" + TimeStamp + ", Created=" + Created
				+ ", Bid=" + Bid + ", Ask=" + Ask + ", OpenBuyOrders="
				+ OpenBuyOrders + ", OpenSellOrders=" + OpenSellOrders
				+ ", PrevDay=" + PrevDay + "]";
	}

	public StagBitTrexGetMarketSummariesBean(int id, String marketName,
			double high, double low, double volume, double last,
			double baseVolume, String timeStamp, String created, double bid,
			double ask, double openBuyOrders, double openSellOrders,
			double prevDay) {
		super();
		this.id = id;
		MarketName = marketName;
		High = high;
		Low = low;
		Volume = volume;
		Last = last;
		BaseVolume = baseVolume;
		TimeStamp = timeStamp;
		Created = created;
		Bid = bid;
		Ask = ask;
		OpenBuyOrders = openBuyOrders;
		OpenSellOrders = openSellOrders;
		PrevDay = prevDay;
	}

	public StagBitTrexGetMarketSummariesBean() {

	}

}
