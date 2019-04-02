<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="read.ReadData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.h1{
	text-align: center;
	color : #4CAF50;
	font-family: "Roboto", sans-serif;
	margin-top: 20%;
	font-size: 30px;
 }

table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}
​
td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}
​
tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
<title>Hospital List</title>
</head>
<body>
<%

	String s = request.getParameter("search");
	ArrayList<String> al = ReadData.read(s);
	

%>

<h1>Hospital list</h1>
​
<table>
  <tr>
	<th>Hospital ID</th>
    <th>Hospital</th>
    <th>Address</th>
    <th>Disease</th>
  </tr>
  <%
  for(String id : al){
	  
	  String name ="";
	  String address = "";
	  String disease = "";
	  BufferedReader br = new BufferedReader(new FileReader("/home/hadoop/Hospital.csv"));
	  String l = "";
	  while((l=br.readLine())!=null){
		  
		String file[] = l.split(",");
		if(file[0].equals(id)){
			
			name = file[1];
			address =file[2];
			disease =file[3];
			break;
		}
		
		
	  }
  %>
  <tr>
    <td><%=id %></td>
    <td><%=name %></td>
    <td><%=address %></td>
	<td><%=disease %></td>
  </tr>
<%} %> 
</table>


</body>
</html>