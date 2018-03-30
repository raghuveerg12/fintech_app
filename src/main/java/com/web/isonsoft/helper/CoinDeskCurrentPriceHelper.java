package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;

import com.core.isonsoft.beans.CoinDeskCurrentPriceMainBean;
import com.core.isonsoft.beans.CoinDeskCurrentPriceTableDataBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;

public class CoinDeskCurrentPriceHelper implements ConvertJsonToListObject {

	@Override
	public List<Object> convertJsonDataToList(String path)
			throws JsonProcessingException, IOException {
		List<Object> list = new ArrayList<Object>();
		CoinDeskCurrentPriceMainBean coinDeskCurrentPriceMainBean = new ObjectMapper()
				.readValue(new File(path), CoinDeskCurrentPriceMainBean.class);
		CoinDeskCurrentPriceTableDataBean tableData = new CoinDeskCurrentPriceTableDataBean();
		tableData.setEurCode(coinDeskCurrentPriceMainBean.getBpi().getEUR()
				.getCode());
		tableData.setDisclaimer(coinDeskCurrentPriceMainBean.getDisclaimer());
		tableData.setEurDescription(coinDeskCurrentPriceMainBean.getBpi()
				.getEUR().getDescription());
		tableData.setEurRate(coinDeskCurrentPriceMainBean.getBpi().getEUR()
				.getRate());
		tableData.setEurRate_float(coinDeskCurrentPriceMainBean.getBpi()
				.getEUR().getRate_float());
		tableData.setEurSymbol(coinDeskCurrentPriceMainBean.getBpi().getEUR()
				.getSymbol());
		tableData.setGbpCode(coinDeskCurrentPriceMainBean.getBpi().getGBP()
				.getCode());
		tableData.setGbpDescription(coinDeskCurrentPriceMainBean.getBpi()
				.getGBP().getDescription());
		tableData.setGbpRate(coinDeskCurrentPriceMainBean.getBpi().getGBP()
				.getRate());
		tableData.setGbpRate_float(coinDeskCurrentPriceMainBean.getBpi()
				.getGBP().getRate_float());
		tableData.setGbpSymbol(coinDeskCurrentPriceMainBean.getBpi().getGBP()
				.getSymbol());
		tableData.setUsdCode(coinDeskCurrentPriceMainBean.getBpi().getUSD()
				.getCode());
		tableData.setUsdDescription(coinDeskCurrentPriceMainBean.getBpi()
				.getUSD().getDescription());
		tableData.setUsdRate(coinDeskCurrentPriceMainBean.getBpi().getUSD()
				.getRate());
		tableData.setUsdRate_float(coinDeskCurrentPriceMainBean.getBpi()
				.getUSD().getRate_float());
		tableData.setUsdSymbol(coinDeskCurrentPriceMainBean.getBpi().getUSD()
				.getSymbol());
		tableData.setUpdated(coinDeskCurrentPriceMainBean.getTime()
				.getUpdated());
		tableData.setUpdatedISO(coinDeskCurrentPriceMainBean.getTime()
				.getUpdatedISO());
		tableData.setUpdateduk(coinDeskCurrentPriceMainBean.getTime()
				.getUpdateduk());
		list.add(tableData);

		return list;
	}

}
