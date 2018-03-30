package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.core.isonsoft.beans.StagCcexGetMarketHistoryBean;
import com.core.isonsoft.beans.StagCcexGetMarketHistoryMainBean;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;


/**
 * 
 * @author raghu
 *
 */
public class CcexGetMarketHistoryHelper{


	public List<StagCcexGetMarketHistoryBean> convertJsonDataToList(String path)
			throws JsonProcessingException, IOException {
		
		StagCcexGetMarketHistoryMainBean stagCcexGetMarketHistoryMainBean=new ObjectMapper().readValue(new File(path),StagCcexGetMarketHistoryMainBean.class);

		
		return stagCcexGetMarketHistoryMainBean.getResult();
	}
	
	public static void main(String[] args) {
		try {
			new CcexGetMarketHistoryHelper().convertJsonDataToList("C:\\Users\\raghu\\Desktop\\faliure\\46.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
