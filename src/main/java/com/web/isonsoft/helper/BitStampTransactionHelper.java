package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;

import com.core.isonsoft.beans.StagBitStampTransactionsBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;


/**
 * 
 * @author raghu
 *
 */
public class BitStampTransactionHelper implements ConvertJsonToListObject{

	
	
	
	
	/**
	 * 
	 */
	@Override
	public List<Object> convertJsonDataToList(String path)
			throws JsonProcessingException, IOException {
		

		List<Object> list=new ArrayList<Object>();
		ObjectMapper mapper=new ObjectMapper();
		TypeFactory typeFactory=mapper.getTypeFactory();
		List<StagBitStampTransactionsBean> someClassList =
			    mapper.readValue(new File(path), typeFactory.constructCollectionType(List.class, StagBitStampTransactionsBean.class));
		for (StagBitStampTransactionsBean object : someClassList) {
			object.setFeedDate(new Timestamp(object.getDate()*1000L));
			list.add(object);
		}
		
		return list;
	}

	public static void main(String[] args) {
		try {
			new BitStampTransactionHelper().convertJsonDataToList("C:\\Users\\raghu\\Desktop\\faliure\\25.json");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
