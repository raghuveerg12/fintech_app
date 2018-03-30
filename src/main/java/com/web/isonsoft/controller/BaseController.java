package com.web.isonsoft.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.core.isonsoft.beans.StagAllCoinsTickerBean;
import com.core.isonsoft.beans.StagAllCoinsTickerMainBean;
import com.core.isonsoft.beans.StagBitStampTickerBean;
import com.core.isonsoft.beans.StagBitStampTickerHourBean;
import com.core.isonsoft.beans.StagBitTrexGetCurrencieBean;
import com.core.isonsoft.beans.StagBitTrexGetMarketSummariesBean;
import com.core.isonsoft.beans.StagBitTrexGetMarketsBean;
import com.core.isonsoft.beans.StagBitTrexGetTickerBean;
import com.core.isonsoft.beans.StagBtcDepthBean;
import com.core.isonsoft.beans.StagBtceTickerMainBean;
import com.core.isonsoft.beans.StagBtceTradeBean;
import com.core.isonsoft.beans.StagCcexDashBtcBean;
import com.core.isonsoft.beans.StagCcexDashBtcMainBean;
import com.core.isonsoft.beans.StagCcexGetMarketHistoryBean;
import com.core.isonsoft.beans.StagCcexPairsBean;
import com.core.isonsoft.beans.StagCcexgetMarketSummaries;
import com.core.isonsoft.beans.StagCcexgetMarktSummResult;
import com.core.isonsoft.beans.StagCoinMarketCapGlobalBean;
import com.core.isonsoft.beans.StagCryptoCoinsNewsFeedBeans;
import com.core.isonsoft.beans.StagEconomistIndexBean;
import com.core.isonsoft.parsingJson.storeToDb.BitStampOrderBookFeedToDb;
import com.core.isonsoft.parsingJson.storeToDb.ConvertUrlToJsonFile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.isonsoft.helper.AllCoinDepthHelper;
import com.web.isonsoft.helper.AllCoinTradesHelper;
import com.web.isonsoft.helper.BitStampOrerBookHelper;
import com.web.isonsoft.helper.BitStampTransactionHelper;
import com.web.isonsoft.helper.BitStockOrderHelper;
import com.web.isonsoft.helper.BitTrexGetCurrenciesHelper;
import com.web.isonsoft.helper.BitTrexGetMarketHelper;
import com.web.isonsoft.helper.BitTrexGetMarktSumriesHelper;
import com.web.isonsoft.helper.BitTrexGetMrktHisryHelper;
import com.web.isonsoft.helper.BitTrexGetOrderBookHelper;
import com.web.isonsoft.helper.BtcDepthHelper;
import com.web.isonsoft.helper.BtcTickerHelper;
import com.web.isonsoft.helper.BtcTradeHelper;
import com.web.isonsoft.helper.CcexCoinNamesHelper;
import com.web.isonsoft.helper.CcexGetBalanceDistributionHelper;
import com.web.isonsoft.helper.CcexGetMarketHelper;
import com.web.isonsoft.helper.CcexGetMarketHistoryHelper;
import com.web.isonsoft.helper.CcexOrderBookHelper;
import com.web.isonsoft.helper.CcexPricesHelper;
import com.web.isonsoft.helper.CcexVolumeBtcHelper;
import com.web.isonsoft.helper.CoinDeskCurrentPriceHelper;
import com.web.isonsoft.helper.CoinMarketCapTickerHelper;
import com.web.isonsoft.helper.GetUrlBasedOnId;
import com.web.isonsoft.helper.RssFeedHelper;

@Controller
public class BaseController {
	private final static org.slf4j.Logger logger = LoggerFactory
			.getLogger(BaseController.class);

	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private static final String INDEX_NAME = "feedUrl.";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		System.out.println("into normal controller");
		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", ++counter);
		logger.debug("[welcome] counter : {}", counter);
		model.addAttribute("centerBody", "CenterBody.jsp");
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
		System.out.println("into name controller" + name);
		model.addAttribute("message", "Welcome " + name);
		model.addAttribute("counter", ++counter);
		model.addAttribute("centerBody", "CenterBody");
		logger.debug("[welcomeName] counter : {}", counter);
		return VIEW_INDEX;

	}

	
	@RequestMapping(value = "/leftNavigation", method = RequestMethod.GET)
	public String leftNavigation(ModelMap model) {

		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", ++counter);

		logger.debug("[welcome] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return "LeftNavigation";

	}

	@RequestMapping(value = "/btcDepth", method = RequestMethod.GET)
	public String btcDepth(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		 
		
		List<Object> listStagBtc = new BtcDepthHelper().convertJsonDataToList(ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request));

		model.addAttribute("url", "url");
		
		model.addAttribute("centerBody", "btcDepth.jsp");
		model.addAttribute("listStagBtc", listStagBtc);
		return VIEW_INDEX;

	}

	@RequestMapping(value = "/BtceTicker", method = RequestMethod.GET)
	public String btceTicker(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into btceTicker Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://btc-e.com/api/3/ticker/btc_usd-btc_rur-btc_eur-ltc_btc-ltc_usd-ltc_rur-ltc_eur-nmc_btc-nmc_usd-nvc_btc-nvc_usd-usd_rur-eur_usd-eur_rur-ppc_btc-ppc_usd-dsh_btc-eth_btc-eth_usd-eth_ltc-eth_rur";
		ServletContext sc = request.getSession().getServletContext();
		
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));


		

		List<Object> listStagBtc = new BtcTickerHelper().convertJsonDataToList(ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request));
		logger.info("listStagBtc >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));

		model.addAttribute("url", url);
		
		model.addAttribute("centerBody", "btcTickerData.jsp");
		model.addAttribute("listStagBtc", listStagBtc);
		return VIEW_INDEX;

	}
	
	
	@RequestMapping(value = "/BtcTrade", method = RequestMethod.GET)
	public String btcTrade(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into btcTrade Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://btc-e.com/api/3/trades/btc_usd";
		ServletContext sc = request.getSession().getServletContext();
		
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));


		

		List<StagBtceTradeBean> listStagBtc = new BtcTradeHelper().convertJsonDataToList(ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request));
		logger.info("listStagBtc >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));

		model.addAttribute("url", url);
		
		model.addAttribute("centerBody", "btcTradeData.jsp");
		model.addAttribute("listStagBtc", listStagBtc);
		return VIEW_INDEX;

	}

	
	
	
	@RequestMapping(value = "/BitStampTransactions", method = RequestMethod.GET)
	public String bitStampTransactions(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into bitStampTransactions Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://www.bitstamp.net/api/v2/transactions/btceur/";
		ServletContext sc = request.getSession().getServletContext();
		
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));


		

		List<Object> listBitStamp = new BitStampTransactionHelper().convertJsonDataToList(ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request));
		logger.info("listStagBtc >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));

		model.addAttribute("url", url);
		
		model.addAttribute("centerBody", "bitStampTrans.jsp");
		model.addAttribute("listBitStamp", listBitStamp);
		return VIEW_INDEX;

	}
	
	
	@RequestMapping(value = "/BitStampOrderBook", method = RequestMethod.GET)
	public String bitStampOrderBook(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into bitStampOrderBook Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://www.bitstamp.net/api/v2/order_book/btcusd/";
		ServletContext sc = request.getSession().getServletContext();
		
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));
		List<Object> listBitStamp = new BitStampOrerBookHelper().convertJsonDataToList(ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request));
		logger.info("listStagBtc >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));

		model.addAttribute("url", url);
		model.addAttribute("centerBody", "bitStampOrBk.jsp");
		model.addAttribute("listBitStamp", listBitStamp);
		return VIEW_INDEX;

	}

	
	
	@RequestMapping(value = "/BitStampTickers", method = RequestMethod.GET)
	public String bitStampTicker(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into bitStampTicker Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://www.bitstamp.net/api/v2/ticker/btcusd/";
		ServletContext sc = request.getSession().getServletContext();
		
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));
		
		
		final StagBitStampTickerBean stagBitStampTickerBean = new ObjectMapper()
		.readValue(new File(ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request)), StagBitStampTickerBean.class);
		stagBitStampTickerBean.setUpdated(new Timestamp(stagBitStampTickerBean.getTimeStamp()*1000L));

		model.addAttribute("url", url);
		model.addAttribute("centerBody", "bitStampTckr.jsp");
		model.addAttribute("BitStampTicker", stagBitStampTickerBean);
		return VIEW_INDEX;

	}
	
	
	
	@RequestMapping(value = "/BitStampTickerHours", method = RequestMethod.GET)
	public String bitStampTickerHour(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {

		logger.info("<<<<<<<<<<<<<<<Into bitStampTickerHour Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://www.bitstamp.net/api/v2/ticker_hour/btcusd/";
		ServletContext sc = request.getSession().getServletContext();
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));
		
		final StagBitStampTickerHourBean stagBitStampTickerHour = new ObjectMapper()
		.readValue(new File(ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request)), StagBitStampTickerHourBean.class);
		stagBitStampTickerHour.setUpdated(new Timestamp(stagBitStampTickerHour.getTimeStamp()*1000L));
		model.addAttribute("url", url);
		model.addAttribute("centerBody", "bitStampTckrHr.jsp");
		model.addAttribute("BitStampTicker", stagBitStampTickerHour);
		return VIEW_INDEX;

	}
	
	
	@RequestMapping(value = "/StagBitTrexGetOrderBook", method = RequestMethod.GET)
	public String bitTrexGetOrderBook(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into StagBitTrexGetOrderBook Controller flow>>>>>>>>>>>>>>>>");
		String url = "https://bittrex.com/api/v1.1/public/getorderbook?market=BTC-LTC&type=both&depth=50";
		ServletContext sc = request.getSession().getServletContext();
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));
		List<Object> list=new BitTrexGetOrderBookHelper().convertJsonDataToList(ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request));

		model.addAttribute("url", url);
		model.addAttribute("centerBody", "bitTrexGetOrdrBk.jsp");
		model.addAttribute("BitTrex", list);
		return VIEW_INDEX;
	}
	
	
	@RequestMapping(value = "/StagBitTrexGetCurrencies", method = RequestMethod.GET)
	public String bitTrexGetCurrencies(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into bitTrexGetCurrencies Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://bittrex.com/api/v1.1/public/getcurrencies";
		ServletContext sc = request.getSession().getServletContext();
		
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));
		List<StagBitTrexGetCurrencieBean> list=new BitTrexGetCurrenciesHelper().convertJsonDataToList(ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request));

		logger.info("list---->>"+list);
		
		for (StagBitTrexGetCurrencieBean stagBitTrexGetCurrencieBean : list) {
			
			logger.info(stagBitTrexGetCurrencieBean.getCurrency());
			
		}
		
		model.addAttribute("url", url);
		model.addAttribute("centerBody", "bitTrexGetCurrencies.jsp");
		model.addAttribute("BitTrex", list);
		return VIEW_INDEX;

	}
	
	
	@RequestMapping(value = "/StagBitTrexGetMarkets", method = RequestMethod.GET)
	public String bitTrexGetMarkets(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into StagBitTrexGetMarkets Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://bittrex.com/api/v1.1/public/getmarkets";
		ServletContext sc = request.getSession().getServletContext();
		

		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));
		List<StagBitTrexGetMarketsBean> list=new BitTrexGetMarketHelper().convertJsonDataToList(ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request));

		model.addAttribute("url", url);
		model.addAttribute("centerBody", "bitTrexGetMarket.jsp");
		model.addAttribute("BitTrex", list);
		return VIEW_INDEX;

	}
	
	
	@RequestMapping(value = "/StagBitTrexGetTicker", method = RequestMethod.GET)
	public String bitTrexGetTicker(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into StagBitTrexGetTicker Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://bittrex.com/api/v1.1/public/getticker?market=BTC-LTC";
		ServletContext sc = request.getSession().getServletContext();
		
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));
		JsonNode rootNode = new ObjectMapper().readTree(new File(ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request)));
		StagBitTrexGetTickerBean stagBitTrexGetMarketsBean = new StagBitTrexGetTickerBean();

		stagBitTrexGetMarketsBean.setBids(Double.parseDouble(rootNode
				.path("result").path("Bid").asText()));
		stagBitTrexGetMarketsBean.setAsks(Double.parseDouble(rootNode
				.path("result").path("Ask").asText()));
		stagBitTrexGetMarketsBean.setLast(Double.parseDouble(rootNode
				.path("result").path("Last").asText()));
		model.addAttribute("url", url);
		model.addAttribute("centerBody", "bitTrexGetTckr.jsp");
		model.addAttribute("BitTrex", stagBitTrexGetMarketsBean);
		return VIEW_INDEX;

	}
	
	
	@RequestMapping(value = "/StagBitTrexGetMarketSummaries", method = RequestMethod.GET)
	public String bitTrexGetMarketSummaries(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into StagBitTrexGetMarketSummaries Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://bittrex.com/api/v1.1/public/getmarketsummaries";
		ServletContext sc = request.getSession().getServletContext();
		

		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));
		List<StagBitTrexGetMarketSummariesBean> list=new BitTrexGetMarktSumriesHelper().convertJsonDataToList(ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request));

		model.addAttribute("url", url);
		model.addAttribute("centerBody", "bitTrexGetMrktSumry.jsp");
		model.addAttribute("BitTrex", list);
		return VIEW_INDEX;


	}
	
	
	@RequestMapping(value = "/StagBitTrexGetMarketHistory", method = RequestMethod.GET)
	public String bitTrexGetMarketHistory(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into StagBitTrexGetMarketHistory Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://bittrex.com/api/v1.1/public/getmarkethistory?market=BTC-DOGE&count=50";
		ServletContext sc = request.getSession().getServletContext();
		

		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));
		List<Object> list=new BitTrexGetMrktHisryHelper().convertJsonDataToList(ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request));

		model.addAttribute("url", url);
		model.addAttribute("centerBody", "bitTrexGetMrktHis.jsp");
		model.addAttribute("BitTrex", list);
		return VIEW_INDEX;
	}

	@RequestMapping(value = "/allCoinDepth", method = RequestMethod.GET)
	public String allCoinDepth(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into allCoinDepth Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://api.allcoin.com/api/v1/depth?symbol=btc_usd";
		ServletContext sc = request.getSession().getServletContext();
		

		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));
		List<Object> list=new AllCoinDepthHelper().convertJsonDataToList(ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request));

		model.addAttribute("url", url);
		model.addAttribute("centerBody", "allCoinDepth.jsp");
		model.addAttribute("allCoin", list);
		return VIEW_INDEX;
	}

	@RequestMapping(value = "/allCoinTicker", method = RequestMethod.GET)
	public String allCoinTicker(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into allCoinTicker Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://api.allcoin.com/api/v1/ticker?symbol=btc_usd";
		ServletContext sc = request.getSession().getServletContext();
		

		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));

		
		StagAllCoinsTickerMainBean stagAllCoinsTickerBeanMain = new ObjectMapper().readValue(new File(ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request)), StagAllCoinsTickerMainBean.class);
		StagAllCoinsTickerBean stagAllBeancoinsTicker=stagAllCoinsTickerBeanMain.getTicker();
		stagAllBeancoinsTicker.setUpdated(new Timestamp(stagAllCoinsTickerBeanMain.getDate()*1000L) );
		
		
		model.addAttribute("url", url);
		model.addAttribute("centerBody", "allCoinTicker.jsp");
		model.addAttribute("allCoin", stagAllBeancoinsTicker);
		return VIEW_INDEX;
	}


	@RequestMapping(value = "/allCoinTrade", method = RequestMethod.GET)
	public String allCoinTrade(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into allCoinTrade Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://api.allcoin.com/api/v1/trades?symbol=btc_usd";
		ServletContext sc = request.getSession().getServletContext();
		

		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));

		
		List<Object> list=new AllCoinTradesHelper().convertJsonDataToList(ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request));
		
		model.addAttribute("url", url);
		model.addAttribute("centerBody", "allCoinTrade.jsp");
		model.addAttribute("allCoin", list);
		return VIEW_INDEX;
	}
	
	
	@RequestMapping(value = "/cCexDashBtc", method = RequestMethod.GET)
	public String cCexDashBtc(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into cCexDashBtc Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://c-cex.com/t/dash-btc.json";
		ServletContext sc = request.getSession().getServletContext();
		

		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));

		
		StagCcexDashBtcMainBean stagCcexDashBtcMainBean = new ObjectMapper().readValue(new File(ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request)), StagCcexDashBtcMainBean.class);
		StagCcexDashBtcBean stagCcexDashBtcBean=stagCcexDashBtcMainBean.getTicker();
		stagCcexDashBtcBean.setDateUpdated(new Timestamp(stagCcexDashBtcBean.getUpdated()*1000L) );
		
		model.addAttribute("url", url);
		model.addAttribute("centerBody", "cCexDashBtc.jsp");
		model.addAttribute("cCex", stagCcexDashBtcBean);
		return VIEW_INDEX;
	}
	
	
	@RequestMapping(value = "/cCexPairs", method = RequestMethod.GET)
	public String cCexPairs(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into cCexPairs Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://c-cex.com/t/pairs.json";
		ServletContext sc = request.getSession().getServletContext();
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));

		String path=ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request);
		logger.info("path file location >>>>>>>>>>>>>>>> {}",path);


		List<Object> list=new ArrayList<Object>();

		JsonNode rootNode = new ObjectMapper().readTree(new File(path));
		for (JsonNode jsonNode : rootNode.path("pairs")) {
			StagCcexPairsBean stagCcexPairsBean = new StagCcexPairsBean();
			stagCcexPairsBean.setName(jsonNode.textValue());
			list.add(stagCcexPairsBean);
		}
		
		model.addAttribute("url", url);
		model.addAttribute("centerBody", "cCexPairs.jsp");
		model.addAttribute("cCex", list);
		return VIEW_INDEX;
	}
	
	@RequestMapping(value = "/cCexPrices", method = RequestMethod.GET)
	public String cCexPrices(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into cCexPrices Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://c-cex.com/t/prices.json";
		ServletContext sc = request.getSession().getServletContext();
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));

		String path=ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request);
		logger.info("path file location >>>>>>>>>>>>>>>> {}",path);


		List<Object> list=new CcexPricesHelper().convertJsonDataToList(path);

		
		
		model.addAttribute("url", url);
		model.addAttribute("centerBody", "cCexPrices.jsp");
		model.addAttribute("cCex", list);
		return VIEW_INDEX;
	}
	
	
	@RequestMapping(value = "/cCexCoinNames", method = RequestMethod.GET)
	public String cCexCoinNames(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into cCexCoinNames Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://c-cex.com/t/coinnames.json";
		ServletContext sc = request.getSession().getServletContext();
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));

		String path=ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request);
		logger.info("path file location >>>>>>>>>>>>>>>> {}",path);


		List<Object> list=new CcexCoinNamesHelper().convertJsonDataToList(path);

		
		
		model.addAttribute("url", url);
		model.addAttribute("centerBody", "cCexCoinNames.jsp");
		model.addAttribute("cCex", list);
		return VIEW_INDEX;
	}
	
	
	
	@RequestMapping(value = "/cCexVolumeBtc", method = RequestMethod.GET)
	public String cCexVolumeBtc(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into cCexVolumeBtc Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://c-cex.com/t/volume_btc.json";
		ServletContext sc = request.getSession().getServletContext();
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));

		String path=ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request);
		logger.info("path file location >>>>>>>>>>>>>>>> {}",path);


		List<Object> list=new CcexVolumeBtcHelper().convertJsonDataToList(path);

		
		
		model.addAttribute("url", url);
		model.addAttribute("centerBody", "cCexVolumeBtc.jsp");
		model.addAttribute("cCex", list);
		return VIEW_INDEX;
	}
	
	
	@RequestMapping(value = "/cCexMarkets", method = RequestMethod.GET)
	public String cCexMarkets(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into cCexMarkets Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://c-cex.com/t/api_pub.html?a=getmarkets";
		ServletContext sc = request.getSession().getServletContext();
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));

		String path=ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request);
		logger.info("path file location >>>>>>>>>>>>>>>> {}",path);


		List<Object> list=new CcexGetMarketHelper().convertJsonDataToList(path);

		
		
		model.addAttribute("url", url);
		model.addAttribute("centerBody", "cCexMarkets.jsp");
		model.addAttribute("cCex", list);
		return VIEW_INDEX;
	}
	
	@RequestMapping(value = "/cCexOrderBook", method = RequestMethod.GET)
	public String cCexOrderBook(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into cCexOrderBook Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://c-cex.com/t/api_pub.html?a=getorderbook&market=btc-usd&type=both&depth=100";
		ServletContext sc = request.getSession().getServletContext();
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));

		String path=ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request);
		logger.info("path file location >>>>>>>>>>>>>>>> {}",path);


		List<Object> list=new CcexOrderBookHelper().convertJsonDataToList(path);

		
		
		model.addAttribute("url", url);
		model.addAttribute("centerBody", "cCexOrderBook.jsp");
		model.addAttribute("cCex", list);
		return VIEW_INDEX;
	}
	
	
	@RequestMapping(value = "/cCexMarketSummaries", method = RequestMethod.GET)
	public String cCexMarketSummaries(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into cCexMarketSummaries Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://c-cex.com/t/api_pub.html?a=getmarketsummaries";
		ServletContext sc = request.getSession().getServletContext();
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));

		String path=ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request);
		logger.info("path file location >>>>>>>>>>>>>>>> {}",path);


		List<StagCcexgetMarktSummResult> list = new ObjectMapper()
		.readValue(new File(path), StagCcexgetMarketSummaries.class)
		.getResult();
		
		
		model.addAttribute("url", url);
		model.addAttribute("centerBody", "cCexMarketSummaries.jsp");
		model.addAttribute("cCex", list);
		return VIEW_INDEX;
	}

	@RequestMapping(value = "/cCexMarketHistory", method = RequestMethod.GET)
	public String cCexMarketHistory(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into cCexMarketHistory Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://c-cex.com/t/api_pub.html?a=getmarkethistory&market=btc-usd&count=100";
		ServletContext sc = request.getSession().getServletContext();
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));

		String path=ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request);
		logger.info("path file location >>>>>>>>>>>>>>>> {}",path);


		List<StagCcexGetMarketHistoryBean> list=new CcexGetMarketHistoryHelper().convertJsonDataToList(path);

		
		
		model.addAttribute("url", url);
		model.addAttribute("centerBody", "cCexMarketHistory.jsp");
		model.addAttribute("cCex", list);
		return VIEW_INDEX;
	}
	
	
	@RequestMapping(value = "/cCexBalanceDistrubution", method = RequestMethod.GET)
	public String cCexBalanceDistrubution(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into cCexBalanceDistrubution Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://c-cex.com/t/api_pub.html?a=getbalancedistribution&currencyname=ltc";
		ServletContext sc = request.getSession().getServletContext();
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));

		String path=ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request);
		logger.info("path file location >>>>>>>>>>>>>>>> {}",path);


		List<Object> list=new CcexGetBalanceDistributionHelper().convertJsonDataToList(path);

		
		
		model.addAttribute("url", url);
		model.addAttribute("centerBody", "cCexBalanceDistrubution.jsp");
		model.addAttribute("cCex", list);
		return VIEW_INDEX;
	}
	
	
	@RequestMapping(value = "/bitStockOrder", method = RequestMethod.GET)
	public String bitStockOrder(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into bitStockOrder Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://www.bitstock.com/api/order/czk/orderbook";
		ServletContext sc = request.getSession().getServletContext();
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));

		String path=ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request);
		logger.info("path file location >>>>>>>>>>>>>>>> {}",path);


		List<Object> list=new BitStockOrderHelper().convertJsonDataToList(path);

		
		
		model.addAttribute("url", url);
		model.addAttribute("centerBody", "bitStockOrder.jsp");
		model.addAttribute("bitStockOrder", list);
		return VIEW_INDEX;
	}
	
	
	@RequestMapping(value = "/coinMaretCapGlobal", method = RequestMethod.GET)
	public String coinMaretCapGlobal(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into coinMaretCapGlobal Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://api.coinmarketcap.com/v1/global/";
		ServletContext sc = request.getSession().getServletContext();
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));

		String path=ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request);
		logger.info("path file location >>>>>>>>>>>>>>>> {}",path);


		StagCoinMarketCapGlobalBean stagCoinMarketCapGlobalBean = new ObjectMapper()
		.readValue(new File(path),
				StagCoinMarketCapGlobalBean.class);
		
		
		model.addAttribute("url", url);
		model.addAttribute("centerBody", "coinMaretCapGlobal.jsp");
		model.addAttribute("coinMaretCap", stagCoinMarketCapGlobalBean);
		return VIEW_INDEX;
	}

	
	@RequestMapping(value = "/coinMaretCapTicker", method = RequestMethod.GET)
	public String coinMaretCapTicker(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into coinMaretCapTicker Controller flow>>>>>>>>>>>>>>>>");

		String url = "https://api.coinmarketcap.com/v1/ticker/";
		ServletContext sc = request.getSession().getServletContext();
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));

		String path=ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request);
		logger.info("path file location >>>>>>>>>>>>>>>> {}",path);


		
		List<Object> list=new CoinMarketCapTickerHelper().convertJsonDataToList(path);
		
		model.addAttribute("url", url);
		model.addAttribute("centerBody", "coinMaretCapTicker.jsp");
		model.addAttribute("coinMaretCap", list);
		return VIEW_INDEX;
	}
	
	
	@RequestMapping(value = "/coinDeskCurrentPrice", method = RequestMethod.GET)
	public String coinDeskCurrentPrice(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into coinDeskCurrentPrice Controller flow>>>>>>>>>>>>>>>>");

		String url = "http://api.coindesk.com/v1/bpi/currentprice.json";
		ServletContext sc = request.getSession().getServletContext();
		logger.info("path of context >>>>>>>>>>>>>>>>{}",sc.getRealPath("/"));

		String path=ConvertUrlToJsonFile.readJsonFromUrlMVC( id,request);
		logger.info("path file location >>>>>>>>>>>>>>>> {}",path);


		
		List<Object> list=new CoinDeskCurrentPriceHelper().convertJsonDataToList(path);
		
		model.addAttribute("url", url);
		model.addAttribute("centerBody", "coinDeskCurrentPrice.jsp");
		model.addAttribute("coinDeskCurrentPrice", list);
		return VIEW_INDEX;
	}
	
	@RequestMapping(value = "/rssFeed", method = RequestMethod.GET)
	public String rssFeed(ModelMap model, @RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		logger.info("<<<<<<<<<<<<<<<Into rssFeed Controller flow>>>>>>>>>>>>>>>>");

		String url =null;
		List<Object> list=null;
		if(id.equals("11")){
			url = "http://www.economist.com/topics/bitcoins/index.xml";

			list=RssFeedHelper.convertRssFeedToList(new StagEconomistIndexBean() ,url);
		}else{
			url ="http://www.cryptocoinsnews.com/news/feed/";
			 list=RssFeedHelper.convertRssFeedToList(new StagCryptoCoinsNewsFeedBeans() ,url);

		}
		
		
		model.addAttribute("url", url);
		model.addAttribute("centerBody", "RssFeedView.jsp");
		model.addAttribute("RssFeedView", list);
		return VIEW_INDEX;
	}

}

