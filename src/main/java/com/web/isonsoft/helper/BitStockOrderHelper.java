package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.core.isonsoft.beans.StagBitStockOrderBean;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;

public class BitStockOrderHelper implements ConvertJsonToListObject{

	@Override
	public List<Object> convertJsonDataToList(String path)
			throws JsonProcessingException, IOException {
		List<Object> list=new ArrayList<Object>();
		JsonNode rootNode = new ObjectMapper().readTree(new File(path));
		if (rootNode.path("bids") != null) {

			for (JsonNode jsonNode : rootNode.path("bids")) {
				StagBitStockOrderBean stagBitStockOrderBean = new StagBitStockOrderBean();
				stagBitStockOrderBean.setAsks("0");
				stagBitStockOrderBean.setBids("1");
				stagBitStockOrderBean.setPrice(Double.parseDouble(jsonNode
						.get(0).asText()));
				stagBitStockOrderBean.setVolume(Double.parseDouble(jsonNode
						.get(1).asText()));
				stagBitStockOrderBean.setValue(Double.parseDouble(jsonNode
						.get(2).asText()));
				list.add(stagBitStockOrderBean);
			}
		}

		if (rootNode.path("asks") != null) {

			for (JsonNode jsonNode : rootNode.path("asks")) {
				StagBitStockOrderBean stagBitStockOrderBean = new StagBitStockOrderBean();
				stagBitStockOrderBean.setAsks("0");
				stagBitStockOrderBean.setBids("1");
				stagBitStockOrderBean.setPrice(Double.parseDouble(jsonNode
						.get(0).asText()));
				stagBitStockOrderBean.setVolume(Double.parseDouble(jsonNode
						.get(1).asText()));
				stagBitStockOrderBean.setValue(Double.parseDouble(jsonNode
						.get(2).asText()));
				list.add(stagBitStockOrderBean);
			}
		}

		return list;
	}

	
	
}
