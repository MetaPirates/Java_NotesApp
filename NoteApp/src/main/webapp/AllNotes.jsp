<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="jakarta.persistence.*" %>
    <%@page import="com.NoteApp.*" %>
    <%@page import="com.Tables.*" %>
    <%@page import="java.util.*" %>
    <%@include file="index.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	EntityManager em=EntityProvider.getManager();
	List<NoteTable> list1=em.createQuery("FROM NoteTable ORDER BY date").getResultList();
	for(NoteTable n:list1){
		
		%>
		<div class="container d-flex justify-content-center ">
		<div class="card wr" >
  <div class="card-body">
    <h5 class="card-title cursive" style="font-size: 26px"><%out.print(n.getTitle()); %></h5>
    
    <p class="card-text"><% out.print(n.getContent());%></p>
    <a href="Delete?id=<%=n.getId() %>" class="card-link" style="text-decoration: none">Delete Note</a>
    <a href="UpdateNote.jsp?id=<%=n.getId() %>" class="card-link" style="text-decoration: none ">Update and View Note</a>
  </div>
</div>
		
		</div>
		
		<br>
		<%
		
	}
	em.close();
	%>


</body>
</html>