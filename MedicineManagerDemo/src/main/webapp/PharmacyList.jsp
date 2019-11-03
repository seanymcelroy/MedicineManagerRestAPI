<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Should display list of pharmacies Here:

       <c:forEach items="${pharmacyList}" var="pharmacy">
                <c:out value="${pharmacy.pharmacyName}"/>
                <br/>
       </c:forEach>
</body>
</html>