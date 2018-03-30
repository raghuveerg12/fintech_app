package com.core.isonsoft.beans;

import java.util.List;

public class StagAllCoinDepthBean {

	public List<StagAllCoinDepthMainBean> bids;
	public List<StagAllCoinDepthMainBean> asks;

	public List<StagAllCoinDepthMainBean> getBids() {
		return bids;
	}

	public void setBids(List<StagAllCoinDepthMainBean> bids) {
		this.bids = bids;
	}

	public List<StagAllCoinDepthMainBean> getAsks() {
		return asks;
	}

	public void setAsks(List<StagAllCoinDepthMainBean> asks) {
		this.asks = asks;
	}

	@Override
	public String toString() {
		return "StagAllCoinDepthBean [bids=" + bids + ", asks=" + asks + "]";
	}

	public StagAllCoinDepthBean(List<StagAllCoinDepthMainBean> bids,
			List<StagAllCoinDepthMainBean> asks) {
		super();
		this.bids = bids;
		this.asks = asks;
	}

	public StagAllCoinDepthBean() {

	}

}
