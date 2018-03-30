package com.core.isonsoft.beans;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "StagCcexDashBtc")
public class StagCcexDashBtcBean {

	public int id;

	public double high;
	public double low;
	public double avg;
	public double lastbuy;
	public double lastsell;
	public double buy;
	public double buysupport;
	public double sell;
	public double lastprice;
	public long updated;
	
	public Timestamp dateUpdated;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

		@Transient
	public long getUpdated() {
		return updated;
	}

	public void setUpdated(long updated) {
		this.updated = updated;
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

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public double getLastbuy() {
		return lastbuy;
	}

	public void setLastbuy(double lastbuy) {
		this.lastbuy = lastbuy;
	}

	public double getLastsell() {
		return lastsell;
	}

	public void setLastsell(double lastsell) {
		this.lastsell = lastsell;
	}

	public double getBuy() {
		return buy;
	}

	public void setBuy(double buy) {
		this.buy = buy;
	}

	public double getBuysupport() {
		return buysupport;
	}

	public void setBuysupport(double buysupport) {
		this.buysupport = buysupport;
	}

	public double getSell() {
		return sell;
	}

	public void setSell(double sell) {
		this.sell = sell;
	}

	public double getLastprice() {
		return lastprice;
	}

	public void setLastprice(double lastprice) {
		this.lastprice = lastprice;
	}

	public Timestamp getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Timestamp dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	
	
	public StagCcexDashBtcBean(){
		
	}

	@Override
	public String toString() {
		return "StagCcexDashBtcBean [id=" + id + ", high=" + high + ", low="
				+ low + ", avg=" + avg + ", lastbuy=" + lastbuy + ", lastsell="
				+ lastsell + ", buy=" + buy + ", buysupport=" + buysupport
				+ ", sell=" + sell + ", lastprice=" + lastprice + ", updated="
				+ updated + ", dateUpdated=" + dateUpdated + "]";
	}

	public StagCcexDashBtcBean(int id, double high, double low, double avg,
			double lastbuy, double lastsell, double buy, double buysupport,
			double sell, double lastprice, long updated, Timestamp dateUpdated) {
		super();
		this.id = id;
		this.high = high;
		this.low = low;
		this.avg = avg;
		this.lastbuy = lastbuy;
		this.lastsell = lastsell;
		this.buy = buy;
		this.buysupport = buysupport;
		this.sell = sell;
		this.lastprice = lastprice;
		this.updated = updated;
		this.dateUpdated = dateUpdated;
	}
	
	

}
