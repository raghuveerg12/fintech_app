<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<body style="width: 100%;height: 100%;background: #fff0f5;padding: 0px;">
	<table style="width: 100%;height: 100%; padding: 0px;">
		<tr style="width: 100%;padding: 0px;" >			
			<td style="border-bottom: solid;">
				<!-- HEADER -->		
				 
						
				<jsp:include page="Header.jsp"/>
			</td>
		</tr>
				<!-- Main Content -->	
		<tr style="padding: 0px;">
			<td>
				<table style="width: 100%;">
					<tr>
							<!-- Left Navigation -->	
						<td style="width: 10%;height:440px;padding: 0px;border: thick;border-right: solid;">
							<jsp:include page="LeftNavigation.jsp"/>			
						</td>
							<!-- center Content -->	
						<td style="width:90%;height:440px ;padding: 0px;" >
							<!-- footer -->
							<jsp:include page="${centerBody}"/>
						</td>
					</tr>
					
				</table>
			</td>
		</tr>
		<tr>
			<td style="border-top: solid;" >
				<!-- Footer -->				
				<jsp:include page="footer.jsp"/>
			</td>
		</tr>
	</table>
		
		<!-- body -->
		
		
	</body>
</html>
