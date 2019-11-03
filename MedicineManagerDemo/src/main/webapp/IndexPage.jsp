<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyMedicineManager</title>
</head>
<body>

<h2>Welcome to MyMedicineManager</h2>
<h4>Please sign up below</h4>
	
<form action="/signUp">
Pharmacy RegistrationNumber: <input type="text" name="pharmacyRegNumber"></br>
Pharmacy Name: <input type="text" name="pharmacyName"></br>
Pharmacy Contact Number: <input type="text" name="pharmacyContactNum"></br>
Pharmacy Contact Address: <input type="text" name="pharmacyAddress"></br>
Pharmacy email: <input type="text" name="pharmacyEmail"></br>
<input type="submit" value="Sign Up">
</form>

<br>
<br>
<br>
<br>
<br>
<br>
<br>

<form action="/viewAllPharmaciesOnDatabase">
<input type="submit" value="Show All Pharmacies">
</form>

</body>
</html>