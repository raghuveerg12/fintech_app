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
    <c:when test="${not empty coinDeskCurrentPrice}">
       
     					
	<table id="example" class="display">
        <thead>
            <tr>
           		
               	<th> updated</th>

				<th> updatedISO</th>
				
				<th> updateduk</th>
				
				
				<th> disclaimer</th>
				
				<th> usdCode</th>
				<th> usdSymbol</th>
				<th> usdRate</th>
				<th> usdDescription</th>
				<th> usdRate_float</th>
				
				<th> gbpCode</th>
				<th> gbpSymbol</th>
				<th> gbpRate</th>
				<th> gbpDescription</th>
				<th> gbpRate_float</th>
				
				<th> eurCode</th>
				<th> eurSymbol</th>
				<th> eurRate</th>
				<th> eurDescription</th>
				<th> eurRate_float</th>
            </tr>
        </thead>
       
        <tbody>
            
            <c:forEach items="${coinDeskCurrentPrice}" var="coinDeskCurrentPrice" varStatus="status">
            <tr>
					<td>${coinDeskCurrentPrice. updatedISO}</td>

					<td>${coinDeskCurrentPrice. updateduk}</td>
				
					<td>${coinDeskCurrentPrice. disclaimer}</td>
				
					<td>${coinDeskCurrentPrice. usdCode}</td>
					<td>${coinDeskCurrentPrice. usdSymbol}</td>
					<td>${coinDeskCurrentPrice. usdRate}</td>
					<td>${coinDeskCurrentPrice. usdDescription}</td>
					<td>${coinDeskCurrentPrice. usdRate_float}</td>
				
					<td>${coinDeskCurrentPrice. gbpCode}</td>
					<td>${coinDeskCurrentPrice. gbpSymbol}</td>
					<td>${coinDeskCurrentPrice. gbpRate}</td>
					<td>${coinDeskCurrentPrice. gbpDescription}</td>
					<td>${coinDeskCurrentPrice. gbpRate_float}</td>
				
					<td>${coinDeskCurrentPrice. eurCode}</td>
					<td>${coinDeskCurrentPrice. eurSymbol}</td>
					<td>${coinDeskCurrentPrice. eurRate}</td>
					<td>${coinDeskCurrentPrice. eurDescription}</td>
					<td>${coinDeskCurrentPrice. eurRate_float}</td>
					
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
