<%@page import="com.jsp.CarManagementSystem.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Car> cars = (List<Car>) request.getAttribute("carList");
	%>
	<table border="">
		<tr>
			<th>Car ID</th>
			<th>Car Model</th>
			<th>Car Brand</th>
			<th>Car Price</th>
			<th>Car UPDATE</th>
			<th>Car DELETE</th>
			
		</tr>
		<%
		
		for (Car car : cars) { %>
		<tr>
			<td><%=car.getCarId()%></td>
			<td><%=car.getCarModel()%></td>
			<td><%=car.getCarBrand()%></td>
			<td><%=car.getCarPrice()%></td>
			<td><a href="Update?carId=<%=car.getCarId() %>">Update</a></td>
			<td><a href="deleteCar?carId=<%=car.getCarId() %>">Delete</a></td>
					</tr>
		<%
		}
		%>
	</table>
</body>
</html>