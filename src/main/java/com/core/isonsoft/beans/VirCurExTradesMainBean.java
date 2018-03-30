package com.core.isonsoft.beans;

import java.util.List;

public class VirCurExTradesMainBean {

	public List<StagVircurExTradesBean> stagVircurExTradesBeans;

	public List<StagVircurExTradesBean> getStagVircurExTradesBeans() {
		return stagVircurExTradesBeans;
	}

	public void setStagVircurExTradesBeans(
			List<StagVircurExTradesBean> stagVircurExTradesBeans) {
		this.stagVircurExTradesBeans = stagVircurExTradesBeans;
	}

	@Override
	public String toString() {
		return "VirCurExTradesMainBean [stagVircurExTradesBeans="
				+ stagVircurExTradesBeans + "]";
	}

	public VirCurExTradesMainBean(
			List<StagVircurExTradesBean> stagVircurExTradesBeans) {
		super();
		this.stagVircurExTradesBeans = stagVircurExTradesBeans;
	}

	public VirCurExTradesMainBean() {

	}

}
