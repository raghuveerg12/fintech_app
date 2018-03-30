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
           		
                <th>total_market_cap_usd</th>
                <th>total_24h_volume_usd</th>
                <th>bitcoin_percentage_of_market_cap</th>
                <th>active_currencies</th>
                <th>active_assets</th>
                <th>active_markets</th>
            </tr>
        </thead>
       
        <tbody>
            
            
            <tr>
					<td>${coinMaretCap.total_market_cap_usd}</td>
					<td>${coinMaretCap.total_24h_volume_usd}</td>
					<td>${coinMaretCap.bitcoin_percentage_of_market_cap}</td>
					<td>${coinMaretCap.active_currencies}</td>
					<td>${coinMaretCap.active_assets}</td>
					<td>${coinMaretCap.active_markets}</td>
					
			</tr>
			
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
