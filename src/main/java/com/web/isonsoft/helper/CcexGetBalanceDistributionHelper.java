package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.core.isonsoft.beans.StagCcexGetBalanceDistribution;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;

public class CcexGetBalanceDistributionHelper implements ConvertJsonToListObject{

	@Override
	public List<Object> convertJsonDataToList(String path)
			throws JsonProcessingException, IOException {
			List<Object> list=new ArrayList<Object>();
			JsonNode rootNode = new ObjectMapper().readTree(new File(path));
			Iterator<String> fieldNames = rootNode.getFieldNames();
			while (fieldNames.hasNext()) {
				String fieldName = fieldNames.next();
				if (fieldName.equals("result")) {
				JsonNode childNode = rootNode.get(fieldName).get(
						"Distribution");
				for (JsonNode jsonNode : childNode) {
					StagCcexGetBalanceDistribution stagCcexGetBalanceDistribution = new StagCcexGetBalanceDistribution();
					stagCcexGetBalanceDistribution.setBalance(Double
							.parseDouble(jsonNode.get("Balance").asText()));
						list.add(stagCcexGetBalanceDistribution);
					}
				}
			}

			return list;
	}

}
