package com.web.isonsoft.helper.service;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;

/**
 * 
 * @author raghu
 *
 */
public interface ConvertJsonToListObject {

	
	/**
	 * 
	 * @param path
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public  List<Object> convertJsonDataToList(String path) throws JsonProcessingException, IOException;
}
