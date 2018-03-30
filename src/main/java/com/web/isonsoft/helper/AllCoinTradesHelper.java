package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;

import com.core.isonsoft.beans.StagAllCoinTradesBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;


/**
 * 
 * @author raghu
 *
 */

public class AllCoinTradesHelper implements ConvertJsonToListObject{

	
	/**
	 * 
	 */
	@Override
	public List<Object> convertJsonDataToList(String path)
			throws JsonProcessingException, IOException {
		List<Object> list= new ArrayList<Object>();
		ObjectMapper mapper=new ObjectMapper();
		TypeFactory typeFactory=mapper.getTypeFactory();
		List<StagAllCoinTradesBean> someClassList =
			    mapper.readValue(new File(path), typeFactory.constructCollectionType(List.class, StagAllCoinTradesBean.class));
			for (StagAllCoinTradesBean stagAllCoinTradesBean : someClassList) {
				stagAllCoinTradesBean.setDateFeed(new Timestamp(stagAllCoinTradesBean.getDate()));
				stagAllCoinTradesBean.setDateFeed_ms(new Timestamp(stagAllCoinTradesBean.getDate_ms()));
				list.add(stagAllCoinTradesBean);
			}	
			System.out.println(list);
		return list;
	}

	public static void main(String[] args) {
		try {
			new AllCoinTradesHelper().convertJsonDataToList("C:\\Users\\raghu\\Desktop\\faliure\\37.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//convertJsonDataToDb( "C:\\Users\\raghu\\Desktop\\faliure\\28.json",System.currentTimeMillis(),session);
		
	}
	
}
