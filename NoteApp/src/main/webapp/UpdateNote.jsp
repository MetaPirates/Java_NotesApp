<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="jakarta.persistence.*" %>
    <%@page import="com.NoteApp.*" %>
    <%@page import="com.Tables.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>

<%
int id=Integer.parseInt(request.getParameter("id"));
EntityManager em=EntityProvider.getManager();
NoteTable note=em.find(NoteTable.class,id);
%>

<div class="d-flex justify-content-center">

<form class="md-5" style="width:350px; margin-top:200px;" action="UpdateServlet">
  <div class="mb-2">
  <input name="id" value="<%=note.getId() %>" hidden="true"></input>
    <label for="exampleInputEmail1" class="form-label">Title</label>
    <input type="text" value="<%=note.getTitle() %>" name="formtitle" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" style="background-color:none">
    
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Content</label>
    <textarea value="<%=note.getContent() %>" name="formcontent" class="form-control"  id="exampleInputPassword1" placeholder="Enter text..."></textarea>
  </div>
  
  <button type="submit" class="btn btn-primary btn-align-center">Submit</button>
</form>
</div>
</body>
</html>