package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;

import com.core.isonsoft.beans.StagBitTrexGetCurrcieMainBean;
import com.core.isonsoft.beans.StagBitTrexGetCurrencieBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;


/**
 * 
 * @author raghu
 *
 */
public class BitTrexGetCurrenciesHelper {

	
	/**
	 * 
	 */
	
	public List<StagBitTrexGetCurrencieBean> convertJsonDataToList(String path)
			throws JsonProcessingException, IOException {
		StagBitTrexGetCurrcieMainBean stagBitTrexGetCurrcieMainBean=new ObjectMapper().readValue(new File(path),StagBitTrexGetCurrcieMainBean.class);
		
				return stagBitTrexGetCurrcieMainBean.getResult();
	}
	
	public static void main(String[] args) {
		try {
			new BitTrexGetCurrenciesHelper().convertJsonDataToList("C:\\Users\\raghu\\Desktop\\faliure\\29.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}

	
	

