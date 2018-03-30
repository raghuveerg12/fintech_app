package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;

import com.core.isonsoft.beans.StagBtceTradeBean;
import com.core.isonsoft.beans.StagBtceTradeMainBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;


/**
 * 
 * @author raghu
 *
 */
public class BtcTradeHelper{

	
	/**
	 * 
	 */
	
	public List<StagBtceTradeBean> convertJsonDataToList(String path)
			throws JsonProcessingException, IOException {

		StagBtceTradeMainBean stagBtceTradeMainBean=new ObjectMapper().readValue(new File(path),StagBtceTradeMainBean.class);
	
		return stagBtceTradeMainBean.getBtc_usd();
	}
	
public static void main(String[] args) {
	try {
		new BtcTradeHelper().convertJsonDataToList("C:\\Users\\raghu\\Desktop\\faliure\\21.json");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}	

}
