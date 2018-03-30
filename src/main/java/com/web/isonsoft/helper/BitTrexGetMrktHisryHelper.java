package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;

import com.core.isonsoft.beans.StagBitTrexGetMarketHistoryBean;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;

public class BitTrexGetMrktHisryHelper implements ConvertJsonToListObject{

	@Override
	public List<Object> convertJsonDataToList(String path)
			throws JsonProcessingException, IOException {
		List<Object> list=new ArrayList<Object>();
		
		JsonNode rootNode = new ObjectMapper().readTree(new File(path));

		for (JsonNode jsonNode : rootNode.path("result")) {
			StagBitTrexGetMarketHistoryBean stagBitTrexGetMarketHistoryBean = new StagBitTrexGetMarketHistoryBean();
			stagBitTrexGetMarketHistoryBean.setTimeStamp(jsonNode.path(
					"TimeStamp").asText());
			stagBitTrexGetMarketHistoryBean.setIdFeed(Long
					.parseLong(jsonNode.path("Id").asText()));
			stagBitTrexGetMarketHistoryBean.setQuatity(Double
					.parseDouble(jsonNode.path("Quantity").asText()));
			stagBitTrexGetMarketHistoryBean.setPrice(Double
					.parseDouble(jsonNode.path("Price").asText()));
			stagBitTrexGetMarketHistoryBean.setTotal(Double
					.parseDouble(jsonNode.path("Total").asText()));
			stagBitTrexGetMarketHistoryBean.setFillType(jsonNode.path(
					"FillType").asText());
			stagBitTrexGetMarketHistoryBean.setOrderType(jsonNode.path(
					"OrderType").asText());
		list.add(stagBitTrexGetMarketHistoryBean);
		}

		return list;
	}

}
