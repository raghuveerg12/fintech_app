package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;

import com.core.isonsoft.beans.StagAllCoinDepthMainBean;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;


/**
 * 
 * @author raghu
 *
 */
public class AllCoinDepthHelper implements ConvertJsonToListObject{

	@Override
	public List<Object> convertJsonDataToList(String path)
			throws JsonProcessingException, IOException {
		final JsonNode jsonNode = new ObjectMapper().readValue(new File(
				path), JsonNode.class);
		List<Object> list= new ArrayList<Object>();
		for (final JsonNode askNode : jsonNode.get("bids")) {
			final StagAllCoinDepthMainBean stgAsks = new StagAllCoinDepthMainBean();
			stgAsks.setAsks("1");
			stgAsks.setBids("0");
			stgAsks.setPrice(askNode.get(0).toString());
			stgAsks.setVolume(askNode.get(1).toString());
		list.add(stgAsks);
		}

		for (final JsonNode bidNode : jsonNode.get("asks")) {
			final StagAllCoinDepthMainBean stgBids = new StagAllCoinDepthMainBean();
			stgBids.setAsks("0");
			stgBids.setBids("1");
			stgBids.setPrice(bidNode.get(0).toString());
			stgBids.setVolume(bidNode.get(1).toString());
			list.add(stgBids);	
		}

		return list;
	}

}
