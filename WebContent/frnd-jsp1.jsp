<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*,java.sql.DriverManager,java.sql.Connection,java.sql.ResultSet,java.sql.Statement" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="Frndjspchk">
<table>
<tr>
<td>CustomerID</td>
<td><input type="text" name="ctid"></td>
<tr>
<td></td>
<td><input type="submit" name="frndjspchk"></td>
</tr>
</table>
</form>

</body>
</html>