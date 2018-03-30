package com.web.isonsoft.helper;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.core.isonsoft.beans.StagCoinMarketCapTickerBean;
import com.web.isonsoft.helper.service.ConvertJsonToListObject;

public class CoinMarketCapTickerHelper implements ConvertJsonToListObject{

	@Override
	public List<Object> convertJsonDataToList(String path)
			throws JsonProcessingException, IOException {

		List<Object> list=new ArrayList<Object>();

		JsonNode rootNode = new ObjectMapper().readTree(new File(path));

		for (JsonNode jsonNode : rootNode) {
			StagCoinMarketCapTickerBean stagCoinMarketCapTickerBean = new StagCoinMarketCapTickerBean();
			if (jsonNode.get("available_supply").asText() != null
					&& !jsonNode.get("available_supply").asText()
							.equals("null")
					&& !(jsonNode.get("available_supply").asText()
							.isEmpty()))

				stagCoinMarketCapTickerBean.setAvailable_supply(Double
						.parseDouble(jsonNode.get("available_supply")
								.asText()));
			if (jsonNode.get("24h_volume_usd").asText() != null
					&& !jsonNode.get("24h_volume_usd").asText()
							.equals("null")
					&& !(jsonNode.get("24h_volume_usd").asText().isEmpty()))

				stagCoinMarketCapTickerBean.setH_volume_usd(Double
						.parseDouble(jsonNode.get("24h_volume_usd")
								.asText()));

			stagCoinMarketCapTickerBean.setId(jsonNode.get("id").asText());
			if (jsonNode.get("last_updated").asText() != null
					&& !jsonNode.get("last_updated").asText()
							.equals("null")
					&& !(jsonNode.get("last_updated").asText().isEmpty()))

				stagCoinMarketCapTickerBean.setLast_updated(new Timestamp(
						Long.parseLong((jsonNode.get("last_updated")
								.asText())) * 1000L));
			if (jsonNode.get("market_cap_usd").asText() != null
					&& !jsonNode.get("market_cap_usd").asText()
							.equals("null")
					&& !(jsonNode.get("market_cap_usd").asText().isEmpty()))

				stagCoinMarketCapTickerBean.setMarket_cap_usd(Double
						.parseDouble(jsonNode.get("market_cap_usd")
								.asText()));
			stagCoinMarketCapTickerBean.setName(jsonNode.get("name")
					.asText());

			if (jsonNode.get("percent_change_1h").asText() != null
					&& !jsonNode.get("percent_change_1h").asText()
							.equals("null")
					&& !(jsonNode.get("percent_change_1h").asText()
							.isEmpty()))
				stagCoinMarketCapTickerBean.setPercent_change_1h(Double
						.parseDouble(jsonNode.get("percent_change_1h")
								.asText()));

			if (jsonNode.get("percent_change_24h").asText() != null
					&& !jsonNode.get("percent_change_24h").asText()
							.equals("null")
					&& !(jsonNode.get("percent_change_24h").asText()
							.isEmpty()))

				stagCoinMarketCapTickerBean.setPercent_change_24h(Double
						.parseDouble(jsonNode.get("percent_change_24h")
								.asText()));
			if (jsonNode.get("percent_change_7d").asText() != null
					&& !jsonNode.get("percent_change_7d").asText()
							.equals("null")
					&& !(jsonNode.get("percent_change_7d").asText()
							.isEmpty()))

				stagCoinMarketCapTickerBean.setPercent_change_7d(Double
						.parseDouble(jsonNode.get("percent_change_7d")
								.asText()));
			if (jsonNode.get("price_btc").asText() != null
					&& !jsonNode.get("price_btc").asText().equals("null")
					&& !(jsonNode.get("price_btc").asText().isEmpty()))

				stagCoinMarketCapTickerBean.setPrice_btc(Double
						.parseDouble(jsonNode.get("price_btc").asText()));
			if (jsonNode.get("price_usd").asText() != null
					&& !jsonNode.get("price_usd").asText().equals("null")
					&& !(jsonNode.get("price_usd").asText().isEmpty()))

				stagCoinMarketCapTickerBean.setPrice_usd(Double
						.parseDouble(jsonNode.get("price_usd").asText()));
			if (jsonNode.get("rank").asText() != null
					&& !jsonNode.get("rank").asText().equals("null")
					&& !(jsonNode.get("rank").asText().isEmpty()))

				stagCoinMarketCapTickerBean.setRank(Long.parseLong(jsonNode
						.get("rank").asText()));
			stagCoinMarketCapTickerBean.setSymbol(jsonNode.get("symbol")
					.asText());
			if (jsonNode.get("total_supply").asText() != null
					&& !jsonNode.get("total_supply").asText()
							.equals("null")
					&& !(jsonNode.get("total_supply").asText().isEmpty()))

				stagCoinMarketCapTickerBean
						.setTotal_supply(Double.parseDouble(jsonNode.get(
								"total_supply").asText()));

			list.add(stagCoinMarketCapTickerBean);

		}
		return list;
	}

}
