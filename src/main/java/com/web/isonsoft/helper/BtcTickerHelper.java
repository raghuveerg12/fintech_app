package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.core.isonsoft.beans.StagBtceTickerMainBean;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;

/**
 * 
 * @author raghu
 *
 */
public class BtcTickerHelper implements ConvertJsonToListObject{
	private final static Logger logger = LoggerFactory
			.getLogger(BtcTickerHelper.class);
	/**
	 * 
	 * @param path
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	@Override
	public List<Object> convertJsonDataToList(String path) throws JsonProcessingException, IOException{
		logger.info("<<<<<<<<<<<<<Into the convertJsonDataToList method of helper class>>>>>>>>>>>>");
		List<Object> list=new ArrayList<Object>();

		JsonNode rootNode = new ObjectMapper().readTree(new File(path));
		

		Iterator<String> fieldName = rootNode.getFieldNames();
		
		//StagBtceTickerMainBean stagBtceTickerMainBeans=new ObjectMapper().readValue(new File(path),StagBtceTickerMainBean.class);

		while (fieldName.hasNext()) {
			StagBtceTickerMainBean stagBtceTickerMainBean = new StagBtceTickerMainBean();

			String fieldNames = fieldName.next();
			stagBtceTickerMainBean.setFieldName(fieldNames);
			if (rootNode.get(fieldNames) != null) {

				stagBtceTickerMainBean.setHigh(Double.parseDouble(rootNode
						.get(fieldNames).path("high").asText()));
				stagBtceTickerMainBean.setLow(Double.parseDouble(rootNode
						.get(fieldNames).path("low").asText()));
				stagBtceTickerMainBean.setAvg(Double.parseDouble(rootNode
						.get(fieldNames).path("avg").asText()));
				stagBtceTickerMainBean.setVol(Double.parseDouble(rootNode
						.get(fieldNames).path("vol").asText()));
				stagBtceTickerMainBean.setVol_cur(Double
						.parseDouble(rootNode.get(fieldNames)
								.path("vol_cur").asText()));
				stagBtceTickerMainBean.setLast(Double.parseDouble(rootNode
						.get(fieldNames).path("last").asText()));
				stagBtceTickerMainBean.setBuy(Double.parseDouble(rootNode
						.get(fieldNames).path("buy").asText()));
				stagBtceTickerMainBean.setSell(Double.parseDouble(rootNode
						.get(fieldNames).path("sell").asText()));
				stagBtceTickerMainBean.setUpdated(new Timestamp(Long.parseLong(rootNode
						.get(fieldNames).path("updated").asText())*1000L));
			}
			list.add(stagBtceTickerMainBean);



	}
		System.out.println(list);
		return list;

	}
	
	public static void main(String[] args) {
		try {
			new BtcTickerHelper().convertJsonDataToList("C:\\Users\\raghu\\Desktop\\faliure\\22.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
