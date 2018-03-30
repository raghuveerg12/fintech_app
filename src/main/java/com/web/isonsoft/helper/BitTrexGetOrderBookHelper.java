package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;

import com.core.isonsoft.beans.StagBitTrexGetOrderBookBean;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;


/**
 * 
 * @author raghu
 *
 */
public class BitTrexGetOrderBookHelper implements ConvertJsonToListObject{

	@Override
	public List<Object> convertJsonDataToList(String path)
			throws JsonProcessingException, IOException {
		List<Object> list=new ArrayList<Object>();
		JsonNode rootNode = new ObjectMapper().readTree(new File(path));
		JsonNode resultNode = rootNode.path("result").path("buy");
		for (JsonNode jsonNode : resultNode) {
			StagBitTrexGetOrderBookBean stagBitTrexGetOrderBookBean = new StagBitTrexGetOrderBookBean();
			stagBitTrexGetOrderBookBean.setQuantity(jsonNode.path(
					"Quantity").asText());
			stagBitTrexGetOrderBookBean.setRate(jsonNode.path("Rate")
					.asText());
			list.add(stagBitTrexGetOrderBookBean);
		}
		return list;
	}

}
