package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.core.isonsoft.beans.StagCcexOorderBookBean;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;

public class CcexOrderBookHelper implements ConvertJsonToListObject{

	@Override
	public List<Object> convertJsonDataToList(String path)
			throws JsonProcessingException, IOException {
		List<Object> list=new ArrayList<Object>();
		
		JsonNode rootNode = new ObjectMapper().readTree(new File(path));
		Iterator<String> fieldNames = rootNode.getFieldNames();

		while (fieldNames.hasNext()) {

			String fieldName = fieldNames.next();

			if (fieldName.equals("result")) {
				JsonNode buyChildNode = rootNode.get(fieldName).get("buy");
				JsonNode sellChildNode = rootNode.get(fieldName)
						.get("sell");
				for (JsonNode jsonNode : buyChildNode) {
					StagCcexOorderBookBean stagCcexOorderBookBean = new StagCcexOorderBookBean();
					stagCcexOorderBookBean.setType("buy");
					stagCcexOorderBookBean
							.setQuantity(Double.parseDouble(jsonNode.get(
									"Quantity").asText()));
					;
					stagCcexOorderBookBean.setRate(Double
							.parseDouble(jsonNode.get("Rate").asText()));
					list.add(stagCcexOorderBookBean);

				}

				for (JsonNode jsonNode : sellChildNode) {
					StagCcexOorderBookBean stagCcexOorderBookBean = new StagCcexOorderBookBean();
					stagCcexOorderBookBean.setType("sell");
					stagCcexOorderBookBean
							.setQuantity(Double.parseDouble(jsonNode.get(
									"Quantity").asText()));
					;
					stagCcexOorderBookBean.setRate(Double
							.parseDouble(jsonNode.get("Rate").asText()));
					list.add(stagCcexOorderBookBean);

				}

			}
		}

		return list;
	}

	
}
