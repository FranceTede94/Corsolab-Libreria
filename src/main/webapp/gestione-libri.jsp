<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="anagrafiche.Libro"%>
<%@page import="anagrafiche.Autore"%>
<%@page import="anagrafiche.Categoria"%>
<%@page import="java.util.ArrayList"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
    crossorigin="anonymous">
<title>Hello, world!</title>
</head>
<body>
	<div class="container mt-3  text-center card fs-8">


		<jsp:include page="template/header.jsp"></jsp:include>

		<!-- main content -->
		<div class="row card">
			<div class="col-12 text-center">
				<h2>Gestione Libri</h2>
				<jsp:include page="include/alert.jsp"></jsp:include>
			</div>
		</div>
		<div class="row">
			<div class=" card col-12 col-md-6 mt-3">
				<h2>Gestione Libri</h2>
				<!-- tabella -->
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Titolo</th>
							<th scope="col">Autore</th>
							<th scope="col">Categoria</th>
							<th scope="col">Prezzo</th>
							<th></th>
						</tr>
					</thead>
					<tbody>

						<%
						//import della lista
						ArrayList<Libro> listLibro = Libro.getAll();
						%>
						<!-- devo stampare gli autori dentro una tabella -->
						<!-- devo ciclare sugli elementi della lista -->
						<%
						for (Libro l : listLibro) {
						%>
						<tr>
							<td><%= l.getId() %></td>
							<td><%= l.getTitolo() %></td>
							<td><%= l.getAutore().getNome()+ " " + l.getAutore().getCognome() %></td>
							<td><%= l.getCategoria().getNome() %></td>
							<td><%= l.getPrezzo()%> €</td>
							<td><a href="deleteLibro?id=<%=l.getId()%>" class="btn btn-outline-danger mt-3 mb-3 col-12">Elimina</a></td>
							<td><a href="modifica-libri.jsp?id=<%=l.getId()%>" class="btn btn-outline-secondary mt-3 mb-3 col-12">Modifica</a></td>
						
						</tr>
						<%
						}
						%>

					</tbody>
				</table>
			</div>
			<div class="card mt-3 col-12 col-md-6">
				<h2>Inserisci un nuovo libro</h2>
				<!-- form -->
				  <form method="post" action="./registerLibro" >
				  
                	<div class="md-3">
                    	<label for= "titolo">Titolo</label>
                    	<input type="text" name= "titolo" id="titolo" class="form-control"  required> 
                    </div>
                    	
                    <div class="md-3">
                    	<label for= "prezzo">Prezzo</label>
                    	<input type="text" name= "prezzo" id="prezzo" class="form-control"  required> 
                    </div>
                   
                   
                <div class="col-3 mb-3">
                <label for= "autore">Seleziona autore</label>
                    <% ArrayList<Autore>  listAutori = Autore.getAll();%>
                	<select name = "autore" class="form control" required>
                	<option value="">Seleziona un elemento</option>
                 	<% for (Autore a : listAutori) { %>
                		<option value ="<%=a.getId()%>"><%= a.getNome() + " " + a.getCognome() %> </option>
                	<% } %>
                 	</select>
                </div>   
                
                
                <div class="col-3 mb-3">
                	<label for= "categoria">Seleziona categoria</label>
                	<% ArrayList<Categoria>  listCategoria = Categoria.getAll();%>
                 	<select name="categoria" class="form control" required>
                 	<option value="">Seleziona un elemento</option>
                 	 <% for (Categoria c : listCategoria) { %>
                 	<option value ="<%=c.getId()%>"><%= c.getNome() %></option>
               		<% }  %> 
                     </select>
                 </div>
                 
                	<div class="col-3">
                    <button class="btn btn-primary w-100 col-3" type="submit">Salva</button>
                	</div>
                	<br>
                	
           	 	</form>
			</div>
		</div>

		<!-- end main content -->

		


	</div>
	
	 <div class="container-fluid text-center p-3">
    <jsp:include page="template/footer.jsp"></jsp:include>
    </div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>