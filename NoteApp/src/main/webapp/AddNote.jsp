<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="index.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet">
</head>
<body>

<h1 class=" d-flex justify-content-center">Add New Note</h1>

<div class="container d-flex justify-content-center ">
<form class="md-5 blur wi" method="post" action="formdetail">
  <div class="mb-2">
    <label for="exampleInputEmail1" class="form-label">Title</label>
    <input type="text" name="formtitle" class="form-control back" id="exampleInputEmail1" aria-describedby="emailHelp" style="background-color:none">
    
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Content</label>
    <textarea type="" name="formcontent" class="form-control back hi"  id="exampleInputPassword1" placeholder="Enter text..."></textarea>
  </div>
  
  <button type="submit" class="btn btn-primary btn-align-center">Submit</button>
</form>
</div>

</body>
</html>