package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;

import com.core.isonsoft.beans.StagBitTrexGetMarketSummariesBean;
import com.core.isonsoft.beans.StagBitTrexGetMarketSumrMainBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;


/**
 * 
 * @author raghu
 *
 */
public class BitTrexGetMarktSumriesHelper{

	/**
	 * 
	 */
	
	public List<StagBitTrexGetMarketSummariesBean> convertJsonDataToList(String path)
			throws JsonProcessingException, IOException {
		
		StagBitTrexGetMarketSumrMainBean stagBitTrexGetMarketSumrMainBean=new ObjectMapper().readValue(new File(path), com.core.isonsoft.beans.StagBitTrexGetMarketSumrMainBean.class);
				return stagBitTrexGetMarketSumrMainBean.getResult();
	}
	
	
	public static void main(String[] args) {
		try {
			new BitTrexGetMarktSumriesHelper().convertJsonDataToList("C:\\Users\\raghu\\Desktop\\faliure\\32.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
	
}
