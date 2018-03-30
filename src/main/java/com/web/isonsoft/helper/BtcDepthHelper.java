package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;

import com.core.isonsoft.beans.StagBtcDepthBean;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;

public class BtcDepthHelper implements ConvertJsonToListObject{

	@Override
	public List<Object> convertJsonDataToList(String path)
			throws JsonProcessingException, IOException {
		List<Object> list=new ArrayList<Object>();
		
		JsonNode rootNode = new ObjectMapper().readTree(new File(path));

		if (rootNode.path("btc_usd").path("bids") != null) {

			for (JsonNode jsonNode : rootNode.path("btc_usd").path("bids")) {
				StagBtcDepthBean stagBtcDepthBids = new StagBtcDepthBean();

				stagBtcDepthBids.setAsks("0");
				stagBtcDepthBids.setBids("1");
				stagBtcDepthBids.setPrice(jsonNode.get(0).toString());
				stagBtcDepthBids.setVolume(jsonNode.get(1).toString());
				list.add(stagBtcDepthBids);
			}

		}

		if (rootNode.path("btc_usd").path("asks") != null) {

			for (JsonNode jsonNode : rootNode.path("btc_usd").path("asks")) {
				StagBtcDepthBean stagBtcDepthAsks = new StagBtcDepthBean();
				stagBtcDepthAsks.setAsks("1");
				stagBtcDepthAsks.setBids("0");
				stagBtcDepthAsks.setPrice(jsonNode.get(0).toString());
				stagBtcDepthAsks.setVolume(jsonNode.get(1).toString());
				list.add(stagBtcDepthAsks);
			}

		}
		return list;
	}

}
