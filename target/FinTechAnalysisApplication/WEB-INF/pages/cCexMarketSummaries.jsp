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
    <c:when test="${not empty cCex}">
       
     					
	<table id="example" class="display">
        <thead>
            <tr>
           		
                <th>MarketName</th>
                <th>High</th>
                <th>Low</th>
                <th>Volume</th>
                <th>Last</th>
               <th> BaseVolume</th>
                <th>TimeStamp</th>
                <th>Bid</th>
                <th>Ask</th>
                <th>OpenBuyOrders</th>
                <th>OpenSellOrders</th>
                <th>PrevDay</th>
                
                <th>DisplayMarketName</th>
            </tr>
        </thead>
       
        <tbody>
            
            <c:forEach items="${cCex}" var="cCex" varStatus="status">
            <tr>
					<td>${cCex.MarketName}</td>
					<td>${cCex.High}</td>
					<td>${cCex.Low}</td>
					<td>${cCex.Volume}</td>
					<td>${cCex.Last}</td>
					<td>${cCex.BaseVolume}</td>
                	<td>${cCex.updated}</td>
                	<td>${cCex.Bid}</td>
                	<td>${cCex.Ask}</td>
                	<td>${cCex.OpenBuyOrders}</td>
                	<td>${cCex.OpenSellOrders}</td>
                	<td>${cCex.PrevDay}</td>
                	
                	<td>${cCex.DisplayMarketName}</td>
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
