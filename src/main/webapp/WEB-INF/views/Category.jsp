<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
</head>
<body  background="C:\Users\G.MANIKANTA\Desktop\css\008.png">
	<c:url var="action" value="editcategory"></c:url>
	<form:form action="${action}" modelAttribute="Category" style="color:blue;">
ID:<form:input path="id" /> 
Name:<form:input path="name" /> 
Description:<form:input path="description" />
		<input type="submit" value="save" />
</form:form>
<!--<c:url var="delaction" value="deletecategory"></c:url>
<form:form action="${action}" modelAttribute="Category" style="color:blue;">
ID:<form:input path="id" />  
		<input type="submit" value="delete">-->

</form:form>
<table>
<div align="center">
<table style="width:80%">
<caption>Categorys</caption>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Description</th>
    <th>Edit</th>
      <th>Delete</th>
  </tr>
<c:forEach items="${categoryList}" var ="category">
<tr>
<td><c:out value="${category.id}"/>
<td><c:out value="${category.name}"/>
<td><c:out value="${category.description}"/>
<td><a href="addeditcategory/${category.id}"/><img alt="Edit" src="C:\Users\G.MANIKANTA\Desktop\css\edit2.jpg"></a>
<td><a href="adddeletecategory/${category.id}"/><img alt="Delete" src="C:\Users\G.MANIKANTA\Desktop\css\delete.jpg"></a>
</tr>
</c:forEach>
</body>
</html>