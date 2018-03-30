package com.core.isonsoft.beans;

public class CcexOrderBookSubResultBean {
	
	public double Quantity;
	public double Rate;
	public double getQuantity() {
		return Quantity;
	}
	public void setQuantity(double quantity) {
		Quantity = quantity;
	}
	public double getRate() {
		return Rate;
	}
	public void setRate(double rate) {
		Rate = rate;
	}
	@Override
	public String toString() {
		return "CcexOrderBookSubResultBean [Quantity=" + Quantity + ", Rate="
				+ Rate + "]";
	}
	
	

}
