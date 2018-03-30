<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>


<head>
<title>center page</title>
	<link href="<c:url value="/CSS/dropDown_hover.css" />" rel="stylesheet" type="text/css"/>
    <script type="text/javascript"  src="<c:url value="/js/accordion-menu.js" />" ></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
    
    <script type="text/javascript">
    
    $(document).ready(function() {
    $('#example').DataTable();
	} );
    </script>
</head>
	<body style="width: 100% ;height: 100% ;">
	<c:choose>
    <c:when test="${not empty coinMaretCap}">
       
     					
	<table id="example" class="display">
        <thead>
            <tr>
           		
                <th>id</th>
                <th>name</th>
                <th>symbol</th>
                <th>rank</th>
                <th>price_usd</th>
                <th>price_btc</th>
                <th>h_volume_usd</th>
                <th>market_cap_usd</th>
                <th>available_supply</th>
                <th>total_supply</th>
                <th>percent_change_1h</th>
                <th>percent_change_24h</th>
                <th>percent_change_7d</th>
                 <th>last_updated</th>
            </tr>
        </thead>
       
        <tbody>
            
            <c:forEach items="${coinMaretCap}" var="coinMaretCap" varStatus="status">
            <tr>
					<td>${coinMaretCap.id}</td>
					<td>${coinMaretCap.name}</td>
					<td>${coinMaretCap.symbol}</td>
					<td>${coinMaretCap.rank}</td>
					<td>${coinMaretCap.price_usd}</td>
					<td>${coinMaretCap.price_btc}</td>
					<td>${coinMaretCap.h_volume_usd}</td>
					<td>${coinMaretCap.market_cap_usd}</td>
					<td>${coinMaretCap.available_supply}</td>
					<td>${coinMaretCap.total_supply}</td>
					<td>${coinMaretCap.percent_change_1h}</td>
					<td>${coinMaretCap.percent_change_24h}</td>
					<td>${coinMaretCap.percent_change_7d}</td>
					<td>${coinMaretCap.last_updated}</td>
					
			</tr>
			</c:forEach>
        </tbody>
    </table>
 
 
    </c:when>    
    <c:otherwise>
      Please check the URL is Working or not <br><a href="${url}">${url}</a>
       
        <br />
    </c:otherwise>
</c:choose>
 </body>
</html>
