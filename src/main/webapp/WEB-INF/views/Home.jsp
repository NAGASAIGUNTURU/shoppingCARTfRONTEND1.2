<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
           <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ShoppingCrat</title>
</head>
<body background="C:\Users\G.MANIKANTA\Desktop\css\001.jpg"" width: 128px; height: 128px;">
<h2 style="color:blue;" align="center">WELCOME TO SHOPPINGCART</h2> 
 
  ${msg}
${msg1 }
<script>
var app = angular.module("myapp", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl :"Home"
    })
    .when("/Supplier",{
    	templateUrl : "Supplier"
    })
     .when("/Category",{
    	templateUrl : "Category"
    })
    .when("/Product", {
        templateUrl : "Product"
    });
    </script>
${message}
<form action="supplier">
<input type="submit" value="Open">
</form>
<a href="Login">Login Here</a><br>
<a href="Register">Register Here</a><br>
<a href="Admin">Admin</a><br>
<c:choose>
<c:when test="${UserClickedadmin}">
<c:import url="/WEB-INF/views/Admin.jsp"></c:import>
</c:when>
</c:choose>
</body>
</html>
