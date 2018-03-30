<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Insert title here</title>
	<link href="<c:url value="/CSS/dropDown_hover.css" />" rel="stylesheet" type="text/css">
    <script type="text/javascript"  src="<c:url value="/js/accordion-menu.js" />" ></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
</head>
<body>
<table>
	<tr>
		<td>
			<div class="dropdown">
	  			<button class="dropbtn">BTC</button>
				  <div class="dropdown-content">
				    <a href="btcDepth?id=20">Depth</a>
				    <a href="BtcTrade?id=21" >Trade</a>
				    <a href="BtceTicker?id=22">Ticker</a>
				<!--<a href="BtcInfo?id=23">Info</a>-->
				  </div>
	  		</div>
		
		</td>
	</tr>
	<tr>
		<td>
			<div class="dropdown">
	  			<button class="dropbtn">BitStamp</button>
				  <div class="dropdown-content">
				  
				   <!--<a href="BitStampEurUsd?id=24">EurUsd</a>-->
				    <a href="BitStampTransactions?id=25">Transactions</a>
				    <a href="BitStampOrderBook?id=26">OrderBook</a>
				    <a href="BitStampTickers?id=27">Ticker</a>
				    <a href="BitStampTickerHours?id=28">TickerHour</a>
				    
				  </div>
	  		</div>
		
		</td>
	</tr>
	<tr>
		<td>
			<div class="dropdown">
	  			<button class="dropbtn">BitTrex</button>
				  <div class="dropdown-content">				  
				  	<a href="StagBitTrexGetCurrencies?id=29" >Currencies</a>
				    <a href="StagBitTrexGetMarkets?id=30" >Markets</a>
				    <a href="StagBitTrexGetTicker?id=31" >Ticker</a>
				    <a href="StagBitTrexGetMarketSummaries?id=32" >MarketSummaries</a>
				    <a href="StagBitTrexGetOrderBook?id=33" >OrderBook</a>
				    <a href="StagBitTrexGetMarketHistory?id=34" >MarketHistory</a>
				   </div>
	  		</div>
		
		</td>
	</tr>
	<tr>
		<td>
			<div class="dropdown">
	  			<button class="dropbtn">AllCoin</button>
				  <div class="dropdown-content">				  
				  	<a href="allCoinDepth?id=35" >Depth</a>
				    <a href="allCoinTicker?id=36" >Ticker</a>
				    <a href="allCoinTrade?id=37" >Trades</a>
				  </div>
	  		</div>
		
		</td>
	</tr>
	<tr>
		<td>
			<div class="dropdown">
	  			<button class="dropbtn">CCEX</button>
				  <div class="dropdown-content">				  
				  	<a href="cCexDashBtc?id=38" >DashBtc</a>
				    <a href="cCexPairs?id=39" >Pairs</a>
				    <a href="cCexPrices?id=40" >Prices</a>
				    <a href="cCexCoinNames?id=41" >CoinNames</a>
				    <a href="cCexVolumeBtc?id=42" >VolumeBtc</a>
				    <a href="cCexMarkets?id=43" >Markets</a>
				    <a href="cCexOrderBook?id=44" >OrderBook</a>
				    <a href="cCexMarketSummaries?id=45" >MarketSummaries</a>
				    <a href="cCexMarketHistory?id=46" >MarketHistory</a>
				    <a href="cCexBalanceDistrubution?id=47" >BalanceDistrubution</a>				    
				  </div>
	  		</div>
		
		</td>
	</tr>
	<tr>
		<td>
			<div class="dropdown">
	  			<button class="dropbtn">BITSTOCK</button>
				  <div class="dropdown-content">				  
				  	<a href="bitStockOrder?id=48" >BitStockOrder</a>
				    				    
				  </div>
	  		</div>
		
		</td>
	</tr>
	<tr>
		<td>
			<div class="dropdown">
	  			<button class="dropbtn">COINMARKET</button>
				  <div class="dropdown-content">				  
				  	<a href="coinMaretCapGlobal?id=49" >Global</a>
				    <a href="coinMaretCapTicker?id=50" >Ticker</a>
				    				    
				  </div>
	  		</div>
		
		</td>
	</tr>
	<tr>
		<td>
			<div class="dropdown">
	  			<button class="dropbtn">COINDESK</button>
				  <div class="dropdown-content">				  
				  	<a href="coinDeskCurrentPrice?id=10" >CurrentPrice</a>
				  </div>
	  		</div>
		
		</td>
	</tr>
	<tr>
		<td>
			<div class="dropdown">
	  			<button class="dropbtn">Economist</button>
				  <div class="dropdown-content">				  
				  	<a href="rssFeed?id=11" >EconomistIndex</a>
				  	<!--  <a href="rssFeed?id=12" >BitCoinMagazin</a>-->
				  	<a href="rssFeed?id=13" >CryptoCoinsNews</a>
				  </div>
	  		</div>
		
		</td>
	</tr>
	<tr>
		<td>
			<iframe name="gap" style="width: 130px;height: 50px;">please read carefully</iframe>		
		</td>
	</tr>
</table>	
	


</body>
</html>
