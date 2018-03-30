package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.core.isonsoft.beans.StagCcexPricesBean;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;

/**
 * 
 * @author raghu
 *
 */
public class CcexPricesHelper implements ConvertJsonToListObject {

	@Override
	public List<Object> convertJsonDataToList(String path)
			throws JsonProcessingException, IOException {
		List<Object> list=new ArrayList<Object>();
		
		JsonNode rootNode = new ObjectMapper().readTree(new File(path));
		Iterator<String> elements = rootNode.getFieldNames();

		while (elements.hasNext()) {
			String elemnet = elements.next();
			StagCcexPricesBean stagCcexPricesBean = new StagCcexPricesBean();
			stagCcexPricesBean.setName(elemnet);
			if (rootNode.path(elemnet) != null) {
				if (StringUtils.isNotEmpty(rootNode
						.path(elemnet).path("high").asText()))

					stagCcexPricesBean.setHigh(Double.parseDouble(rootNode
							.path(elemnet).path("high").asText()));
				if (StringUtils.isNotEmpty(rootNode
						.path(elemnet).path("avg").asText()))
					stagCcexPricesBean.setAvg(Double.parseDouble(rootNode
							.path(elemnet).path("avg").asText()));

				if (StringUtils.isNotEmpty(rootNode
						.path(elemnet).path("low").asText()))

					stagCcexPricesBean.setLow(Double.parseDouble(rootNode
							.path(elemnet).path("low").asText()));
				if (StringUtils.isNotEmpty(rootNode
						.path(elemnet).path("lastbuy").asText()))

					stagCcexPricesBean.setLastBuy(Double
							.parseDouble(rootNode.path(elemnet)
									.path("lastbuy").asText()));
				if (StringUtils.isNotEmpty(rootNode
						.path(elemnet).path("lastsell").asText()))

					stagCcexPricesBean.setLastSell(Double
							.parseDouble(rootNode.path(elemnet)
									.path("lastsell").asText()));
				if (StringUtils.isNotEmpty(rootNode
						.path(elemnet).path("buy").asText()))

					stagCcexPricesBean.setBuy(Double.parseDouble(rootNode
							.path(elemnet).path("buy").asText()));
				if (StringUtils.isNotEmpty(rootNode
						.path(elemnet).path("sell").asText()))

					stagCcexPricesBean.setSell(Double.parseDouble(rootNode
							.path(elemnet).path("sell").asText()));

				if (StringUtils.isNotEmpty(rootNode
						.path(elemnet).path("lastprice").asText()))
					stagCcexPricesBean.setLastPrice(Double
							.parseDouble(rootNode.path(elemnet)
									.path("lastprice").asText()));
				stagCcexPricesBean.setUpdated(new Timestamp(Long
						.parseLong(rootNode.path(elemnet).path("updated")
								.asText()) * 1000L));

				list.add(stagCcexPricesBean);
			}
		}


		return list;
	}

}
