<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<div class="container mt-3  text-center card">


		<jsp:include page="template/header.jsp"></jsp:include>

		<!-- main content -->
		<div class="row card">
			<div class="col-12 text-center">
				<h2>Gestione Categoria</h2>
				<jsp:include page="include/alert.jsp"></jsp:include>
			</div>
		</div>
		<div class="row">
			<div class=" card col-12 col-md-6 mt-3 ">
				<h2>Gestione Categoria</h2>
				<!-- tabella -->
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nome</th>
							<th></th>
						</tr>
					</thead>
					<tbody>

						<%
						//import della lista
						ArrayList<Categoria> listCategoria = Categoria.getAll() ;
						%>
						<!-- devo stampare gli autori dentro una tabella -->
						<!-- devo ciclare sugli elementi della lista -->
						<%
						for (Categoria c : listCategoria) {
						%>
						<tr>
							<td><%=c.getId()%></td>
							<td><%=c.getNome()%></td>
							<td><a href="deleteCategoria?id=<%=c.getId()%>" class="btn btn-outline-danger mt-3 mb-4 col-8">Elimina</a></td>
							<td><a href="modifica-categoria.jsp?id=<%=c.getId()%>" class="btn btn-outline-secondary mt-3 mb-4 col-8">Modifica</a></td>
						</tr>


						<%
						}
						%>

					</tbody>
				</table>
			</div>
			<div class="card mt-3 col-12 col-md-6">
				<h2>Inserisci una nuova categoria</h2>
				<!-- form -->
				  <form class="row g-3" action="./registerCategoria" method="post">
                <div class="col-12 col-md-6">
                    <label  class="form-label">Inserisci categoria:</label>
                    <input type="text" name= "nome" class="form-control"  required>   
                </div>
                <div class="col-12 mt-4">
                    <button class="btn btn-primary w-100" type="submit">Salva</button>
                </div>
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
</html>>