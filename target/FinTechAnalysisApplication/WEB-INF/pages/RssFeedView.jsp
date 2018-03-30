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
    <c:when test="${not empty RssFeedView}">
       
     					
	<table id="example" class="display">
        <thead>
            <tr>
           		
                <th>description</th>
                <th>title</th>
                <th>link</th>
                <th>updated</th>
                <th>creator</th>
                 <th>category</th>
                
            </tr>
        </thead>
       
        <tbody>
            
            <c:forEach items="${RssFeedView}" var="RssFeedView" varStatus="status">
            <tr>
					<td>${RssFeedView.description}</td>
					<td>${RssFeedView.title}</td>
					<td>${RssFeedView.link}</td>
					<td>${RssFeedView.updated}</td>
					<td>${RssFeedView.creator}</td>
					<td>${RssFeedView.category}</td>
					
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
