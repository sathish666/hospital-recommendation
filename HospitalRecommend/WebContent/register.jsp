<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.FileWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name = request.getParameter("n");
String email = request.getParameter("e");
String password = request.getParameter("p");

FileWriter fw=new FileWriter("/home/hadoop/user.csv",true);
BufferedWriter bw = new BufferedWriter(fw);
bw.write(name+","+email+","+password);
bw.write("\n");
bw.close();
fw.close();
response.sendRedirect("user.jsp");
%>
</body>
</html>