<%@page import="com.sathya.servlet.ProductDao"  import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.0/dist/css/bootstrap.min.css" rel="stylesheet"></link>
<title>Product List</title>
</head>
<body>
	<h1 class="text-primary font-italic mb-2 text-center"> List of Available Products....</h1>
	
	<div>
		<a class="btn btn-success" href="add-product.html">Save Product</a>
	</div>
	
	<div>
		<input type="text" placeholder="Search" />
	</div>
	
	<div>
		<c:if test="${saveResult==1}">
			<h2 class="text-success text-center"> Data Inserted Successfully.....</h2>
		</c:if>
	</div>
	
	<div>
		<c:if test="${deleteResult==1}">
			<h2 class="text-danger text-center"> Data Deleted Successfully.....</h2>
		</c:if>
	</div>
	
	<div>
		<c:if test="${deleteResult==0}">
			<h2 class="text-danger text-center"> Data Deletion Failed.....</h2>
		</c:if>
	</div>
	
	<table class="table table-bordered table-striped" >
	<thead class="thead-dark">
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Cost</th>
				<th>Product Brand</th>
				<th>Made In</th>
				<th>Manufacture Date</th>
				<th>Expiry Date</th>
				<th>Image</th>
				<th>Audio</th>
				<th>Video</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="<%= new ProductDao().getAllProducts() %>">
				<tr>
					<td>${product.proId}</td>
					<td>${product.proName}</td>
					<td>${product.proPrice}</td>
					<td>${product.proBrand}</td>
					<td>${product.proMadeIn}</td>
					<td>${product.proMfgDate}</td>
					<td>${product.proExpDate}</td>
					<td> <img alt="Product Image" src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}" style="max-width: 100px; max-height:100px"></td>
					<td> <audio controls> <source type="audio/mpeg" src="data:audio/mpeg;base64,${Base64.getEncoder().encodeToString(product.proAudio)}"> </audio> </td>
					<td> <video controls width="100px" height="100px"> <source src="data:audio/mpeg;base64,${Base64.getEncoder().encodeToString(product.proVideo)}"> </video> </td>
					<td> <a class="btn btn-primary" href="./DeleteProductServlet?proId=${product.proId}">Delete</a> 
						<a class="btn btn-primary" href="./EditProductServlet?proId=${product.proId}">Edit</a> 
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>