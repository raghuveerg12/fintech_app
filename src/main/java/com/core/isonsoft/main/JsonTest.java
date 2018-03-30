package com.core.isonsoft.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.core.isonsoft.beans.StagBtcDepthBean;
import com.core.isonsoft.hibernate.beans.JsonTestBean;
import com.core.isonsoft.parsingJson.storeToDb.ConvertUrlToJsonFile;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {
	
	public static final Logger LOG=LoggerFactory.getLogger(JsonTest.class);
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		getNewCreatedJsonFile();
	}
	
	public static void getNewCreatedJsonFile() throws JsonParseException, JsonMappingException, IOException{
		LOG.info("INTO The NewCreatedJsonFile Method");
		
		
		RestTemplate rest=new RestTemplate();
		JsonTestBean json=rest.getForObject("https://btc-e.com/api/3/depth/btc_usd", JsonTestBean.class);
		LOG.info("json"+json);
		 /*List<StagBtcDepthBean> listStagBtc=new ArrayList<StagBtcDepthBean>();
		 String path=ConvertUrlToJsonFile.readJsonFromUrl("https://btc-e.com/api/3/depth/btc_usd", "20");
		 LOG.info(path);
	        JsonNode rootNode = new ObjectMapper().readTree(new File("src/main/filesPath/in/20170239/20.json"));
	        if (rootNode.path("btc_usd").path("bids") != null) {
				for (JsonNode jsonNode : rootNode.path("btc_usd").path("bids")) {

	        	StagBtcDepthBean stagBtcDepthBids = new StagBtcDepthBean();

				stagBtcDepthBids.setAsks("0");
				stagBtcDepthBids.setBids("1");
				stagBtcDepthBids.setPrice(jsonNode.get(0).toString());
				stagBtcDepthBids.setVolume(jsonNode.get(1).toString());
	        	listStagBtc.add(stagBtcDepthBids);
				}
				
				for (JsonNode jsonNode : rootNode.path("btc_usd").path("asks")) {

		        	StagBtcDepthBean stagBtcDepthBids = new StagBtcDepthBean();

					stagBtcDepthBids.setAsks("1");
					stagBtcDepthBids.setBids("0");
					stagBtcDepthBids.setPrice(jsonNode.get(0).toString());
					stagBtcDepthBids.setVolume(jsonNode.get(1).toString());
		        	listStagBtc.add(stagBtcDepthBids);
					}
				LOG.info(listStagBtc.toString());
	        }
*/	}

}
