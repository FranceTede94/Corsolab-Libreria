<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   
<% if(request.getParameter("s") != null ){ %>

	<div class ="alert alert-success">
		<strong>OK!</strong> Operazione completata
	</div>
	
	<% } %>

<% if(request.getParameter("e") != null ){ %>

	<div class= "alert alert-danger">
		<strong>Attenzione</strong> Impossibile completare l'operazione 
	</div>
	
	<% } %>
