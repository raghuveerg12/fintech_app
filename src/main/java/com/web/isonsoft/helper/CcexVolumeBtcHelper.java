package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.core.isonsoft.beans.StagCcexVolumeBtcBean;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;


/**
 * 
 * @author raghu
 *
 */
public class CcexVolumeBtcHelper implements ConvertJsonToListObject{

	@Override
	public List<Object> convertJsonDataToList(String path)
			throws JsonProcessingException, IOException {
		List<Object> list=new ArrayList<Object>();
		JsonNode rootNode = new ObjectMapper().readTree(new File(path));

		Iterator<String> fieldNames = rootNode.get("ticker")
				.getFieldNames();
		while (fieldNames.hasNext()) {
			StagCcexVolumeBtcBean stagCcexVolumeBtcBean = new StagCcexVolumeBtcBean();
			String fieldName = fieldNames.next();
			stagCcexVolumeBtcBean.setName(fieldName);
			if (StringUtils.isNotEmpty(rootNode.get("ticker").get(fieldName).toString())) {

				stagCcexVolumeBtcBean
						.setLast(Double.parseDouble(rootNode.get("ticker")
								.get(fieldName).get("last").asText()));
				stagCcexVolumeBtcBean.setVol(Double.parseDouble(rootNode
						.get("ticker").get(fieldName).get("vol").asText()));
				list.add(stagCcexVolumeBtcBean);
			}
		}

		return list;
	}

	
	
}
