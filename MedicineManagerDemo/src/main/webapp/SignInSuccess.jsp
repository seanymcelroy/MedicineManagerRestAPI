<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome ${pharmacy.pharmacyName}</h2>
	
<form action="/deletePharmacy">
<input type="hidden" value ={pharmacy.pharmacyRegNumber} name="myPharmacyRegNumber"></input>
<input type="submit" value="Delete Pharmacy">
</form>
	
</body>
</html>