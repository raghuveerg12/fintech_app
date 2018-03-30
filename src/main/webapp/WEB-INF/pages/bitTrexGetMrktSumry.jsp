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
    <c:when test="${not empty BitTrex}">
       
     					
	<table id="example" class="display">
        <thead>
            <tr>
           		
                <th>marketName</th>
                <th>high</th>
                <th>low</th>
                <th>voulme</th>
                <th>last</th>
                <th>baseVolume</th>
                <th>timeStamp</th>
                <th>bid</th>
                <th>ask</th>
                <th>openBuyOrders</th>
                <th>openSellOrders</th>
                <th>prevDay</th>
               
                
                
                
            </tr>
        </thead>
       
        <tbody>
            
            <c:forEach items="${BitTrex}" var="bitTrex" varStatus="status">
            <tr>
					<td>${bitTrex.marketName}</td>
					<td>${bitTrex.high}</td>
					<td>${bitTrex.low}</td>
					<td>${bitTrex.volume}</td>
					<td>${bitTrex.last}</td>
					<td>${bitTrex.baseVolume}</td>
					<td>${bitTrex.timeStamp}</td>
					<td>${bitTrex.bid}</td>					
                <td>${bitTrex.ask}</td>
                <td>${bitTrex.openBuyOrders}</td>
                <td>${bitTrex.openSellOrders}</td>
                <td>${bitTrex.prevDay}</td>
       
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
