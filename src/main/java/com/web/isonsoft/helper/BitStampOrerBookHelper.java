package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;

import com.core.isonsoft.beans.StagBitStampOrderBookBean;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;


/**
 * 
 * @author raghu
 *
 */
public class BitStampOrerBookHelper implements ConvertJsonToListObject{

	@Override
	public List<Object> convertJsonDataToList(String path)
			throws JsonProcessingException, IOException {
		
		List<Object> list=new ArrayList<Object>();
		JsonNode rootNode = new ObjectMapper().readTree(new File(path));
		if (rootNode.path("bids") != null) {

			for (JsonNode jsonNode : rootNode.path("bids")) {
				StagBitStampOrderBookBean stagBtcDepthBids = new StagBitStampOrderBookBean();

				stagBtcDepthBids.setAsks("0");
				stagBtcDepthBids.setBids("1");
				stagBtcDepthBids.setPrice(Double.parseDouble(jsonNode.get(0).textValue()));
				stagBtcDepthBids.setVolume(Double.parseDouble(jsonNode.get(1).textValue()));
				list.add(stagBtcDepthBids);
			}

		}

		if (rootNode.path("asks") != null) {

			for (JsonNode jsonNode : rootNode.path("asks")) {
				StagBitStampOrderBookBean stagBtcDepthAsks = new StagBitStampOrderBookBean();
				stagBtcDepthAsks.setAsks("1");
				stagBtcDepthAsks.setBids("0");
				stagBtcDepthAsks.setPrice(Double.parseDouble(jsonNode.get(0).textValue()));
				stagBtcDepthAsks.setVolume(Double.parseDouble(jsonNode.get(1).textValue()));
				list.add(stagBtcDepthAsks);

			}

		}

		


		return list;
	}

	
	
}
