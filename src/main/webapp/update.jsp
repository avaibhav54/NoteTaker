<%@page import="javax.persistence.Table"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.*"%>
<%@page import="java.util.*"%>
<%@page import="com.entities.note"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Notes</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="css/style.css"    rel="stylesheet"/>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
 
</head>
<body>


 <div class="container">
<%@include file="navbar.jsp" %>
 
<br>
<%
int  n=Integer.parseInt(request.getParameter("noteId").trim());
Session s=FactoryProvider.getFactory().openSession();

note not=s.get(note.class,n);
 
%>


<form action="update">
<input value="<%=not.getId() %>"   name="nid"   type="hidden"> 
  <div class="form-group">
    <label for="   Note title">Title</label>
    <input value="<%= not.getTitle() %>" name="title"    type="text" class="form-control"   required id="title" aria-describedby="emailHelp" placeholder="Enter  title">
 
  </div>
  <div class="form-group">
    <label for="content">Note Content</label>
 <textarea   name="content"style="height:240px" required id="content"   placeholder="Enter your content here"   class="form-control">
 <%=not.getContent() %>
 </textarea>
 <br>
 <center>
  <button type="submit" class="btn btn-primary">Update</button>
  </center>
</form>
</div>

</body>
</html>