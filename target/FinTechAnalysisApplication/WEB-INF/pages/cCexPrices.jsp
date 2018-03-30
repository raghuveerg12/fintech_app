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
           		
                <th>Name</th>
                <th>High</th>
                <th>Low</th>
                <th>Avg</th>
                <th>LastBuy</th>
                <th>LastSell</th>
                <th>Buy</th>
                <th>Sell</th>
                <th>LastPrice</th>
                <th>Updated</th>
            </tr>
        </thead>
       
        <tbody>
            
            <c:forEach items="${cCex}" var="cCex" varStatus="status">
            <tr>
					<td>${cCex.name}</td>
					<td>${cCex.high}</td>
					<td>${cCex.low}</td>
					<td>${cCex.avg}</td>
					<td>${cCex.lastBuy}</td>
					<td>${cCex.lastSell}</td>
					<td>${cCex.buy}</td>
					<td>${cCex.sell}</td>
					<td>${cCex.lastPrice}</td>
					<td>${cCex.updated}</td>
					
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
