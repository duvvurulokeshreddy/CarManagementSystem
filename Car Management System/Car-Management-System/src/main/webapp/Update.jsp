<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.jsp.CarManagementSystem.Car"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Car car=(Car) request.getAttribute("car");
%>

<form action="SaveUpdateCar" method="post">
<input type="number" name="carId" value="<%=car.getCarId()%>" readonly="true"><br>
<input type="text" name="carModel" value="<%=car.getCarModel()%>"><br>
<input type="text" name="caBrand" value="<%=car.getCarBrand()%>"><br>
<input type="number" name="carPrice" value="<%=car.getCarPrice()%>"><br>
<input type="Submit" value="Update">
</form>
</body>
</html>