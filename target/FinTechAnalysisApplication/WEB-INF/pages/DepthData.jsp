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
    <c:when test="${not empty listStagBtc}">
       
     					
	<table id="example" class="display">
        <thead>
            <tr>
           		<th>Name</th>
                <th>high</th>
                <th>low</th>
                <th>avg</th>
                <th>vol</th>
                <th>vol_cur</th>
                <th>last</th>
                <th>buy</th>
                <th>sell</th>
                <th>updated</th>
            </tr>
        </thead>
       
        <tbody>
            
            <c:forEach items="${listStagBtc}" var="stagBtc" varStatus="status">
            <tr>
					<td>${stagBtc.fieldName}</td>
					<td>${stagBtc.high}</td>
					<td>${stagBtc.low}</td>
					<td>${stagBtc.avg}</td>					
					<td>${stagBtc.vol}</td>
					<td>${stagBtc.vol_cur}</td>
					<td>${stagBtc.last}</td>
					<td>${stagBtc.buy}</td>
					<td>${stagBtc.sell}</td>
					<td>${stagBtc.updated}</td>
					
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
