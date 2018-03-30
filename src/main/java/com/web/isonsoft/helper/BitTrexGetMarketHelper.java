package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;

import com.core.isonsoft.beans.StagBitTrexGetMarketsBean;
import com.core.isonsoft.beans.StagBitTrexGetMarketsMainBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;


/**
 * 
 * @author raghu
 *
 */
public class BitTrexGetMarketHelper{

	
	/**
	 * 
	 */
	
	public List<StagBitTrexGetMarketsBean> convertJsonDataToList(String path)
			throws JsonProcessingException, IOException {
		StagBitTrexGetMarketsMainBean stagBitTrexGetMarketsMainBean=new ObjectMapper().readValue(new File(path), StagBitTrexGetMarketsMainBean.class);

				return stagBitTrexGetMarketsMainBean.getResult();
	}
	
	public static void main(String[] args) {
		try {
			new BitTrexGetMarketHelper().convertJsonDataToList("C:\\Users\\raghu\\Desktop\\faliure\\30.json");
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
