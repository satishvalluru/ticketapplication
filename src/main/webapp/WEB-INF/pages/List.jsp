<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Products List :</h1>
 <form:form action="addToCart" method="post" modelAttribute="cart">
		<table border="1">

			<th>Product Id</th>
			<th>Product Name</th>
			<th>Price</th>
			<th>Description</th>
			<th>Option</th>

			<c:forEach var="product" items="${listProduct}">
				<tr>

					<td>${product.productId}</td>
					<td>${product.productName}</td>
					<td>${product.price}</td>
					<td>${product.description}</td>
					<td><a href="${pageContext.request.contextPath }/addToCart/${product.productId}">Buy Now</a></td>
				</tr>
			</c:forEach>
			
		</table>
		<%--  <form:hidden path="productIds" /> --%>
		 </form:form>
	</div>
</body>
</html>