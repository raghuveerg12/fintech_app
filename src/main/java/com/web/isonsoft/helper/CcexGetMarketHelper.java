package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.core.isonsoft.beans.StagCcexGetMarketsBean;
import com.core.isonsoft.main.EpochDateConverter;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;


/**
 * 
 * @author raghu
 *
 */
public class CcexGetMarketHelper implements ConvertJsonToListObject {

	@Override
	public List<Object> convertJsonDataToList(String path)
			throws JsonProcessingException, IOException {
		List<Object> list=new ArrayList<Object>();
		
		JsonNode rootNode = new ObjectMapper().readTree(new File(path));
		Iterator<String> fieldNames = rootNode.getFieldNames();

		while (fieldNames.hasNext()) {

			String fieldName = fieldNames.next();

			if (fieldName.equals("result")) {
				for (JsonNode jsonNode : rootNode.get(fieldName)) {
					StagCcexGetMarketsBean stagCcexGetMarketsBean = new StagCcexGetMarketsBean();

					stagCcexGetMarketsBean.setMarketCurrency(jsonNode.get(
							"MarketCurrency").asText());
					stagCcexGetMarketsBean.setBaseCurrencyLong(jsonNode.get(
							"BaseCurrencyLong").asText());
					stagCcexGetMarketsBean.setBaseCurrency(jsonNode.get(
							"BaseCurrency").asText());
					stagCcexGetMarketsBean.setMarketCurrencyLong(jsonNode
							.get("MarketCurrencyLong").asText());
					stagCcexGetMarketsBean.setMinTradeSize(Double
							.parseDouble(jsonNode.get("MinTradeSize")
									.asText()));
					stagCcexGetMarketsBean.setMarketName(jsonNode.get(
							"MarketName").asText());
					stagCcexGetMarketsBean.setActive((jsonNode.get("IsActive").asText()));

					try {
						stagCcexGetMarketsBean.setCreated(new Timestamp(
								EpochDateConverter.convertingSimpleDate(
										jsonNode.get("Created").asText())
										.getTime()));
					} catch (ParseException e) {
						e.printStackTrace();
					}

					list.add(stagCcexGetMarketsBean);

				}

			}
		}

		
		return list;
	}
	
	

}
