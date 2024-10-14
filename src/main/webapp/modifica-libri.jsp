<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="anagrafiche.*"%>

<!doctype html>
<html lang="it">
<head>

<style>
.box{
	margin: 0 auto;
}
</style>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
<body>

	<div class="container">
		<jsp:include page="template/header.jsp"></jsp:include>

		<!-- main content -->

			<div class="col-12 col-md-6 box">
				<h2>Modifica Libro</h2>
				 <% Libro libri = Libro.getLibroById(Integer.parseInt(request.getParameter("id")));%>
				  <h5> Stai modificando <%=libri.getTitolo()%></h5>
				
				<form method="post" action="./updateLibro">   
					<div class="mb-3">
						<label for="titolo">Titolo</label> 
						<input type="text" name="titolo" id="titolo" class="form-control" value="<%=libri.getTitolo() %>" required>
					</div>
					<div class="mb-3">
						<label for="prezzo">Prezzo</label> 
						<input type="number" min="0.0" step="0.01" name="prezzo" value="<%=libri.getPrezzo() %>" id="prezzo_val" class="form-control"
							required>
					</div>

					<div class="mb-3">
						<label for="autore">Seleziona autore</label>
						<%  ArrayList<Autore> lAutori = Autore.getAll(); %>
						<select name="autore" class="form-control" required>
							<option value="">seleziona un elemento</option>
							<% for(Autore a : lAutori) { 
							
								if(libri.getAutore().getId() == a.getId()) {
							%>
								<option selected value="<%=a.getId()%>"><%=a.getNome() + " " + a.getCognome()%></option>
							<% 	} else { %>
								<option  value="<%=a.getId()%>"><%=a.getNome() + " " + a.getCognome()%></option>
				
							<% } } %>
						</select>
					</div>

					<div class="mb-3">
						<label for="categoria">Seleziona categoria</label>
						<%  ArrayList<Categoria> lCategorie = Categoria.getAll(); %>
						<select name="categoria" class="form-control" required>
							<option value="">seleziona un elemento</option>
							<% for(Categoria c : lCategorie) { 
							
								if(libri.getCategoria().getId() == c.getId() ) {
								%>	
									<option selected value="<%=c.getId()%>"><%=c.getNome()%></option>
								<% } 
								else { %> 
								 <option value="<%=c.getId()%>"><%=c.getNome()%></option>
								<%	}
							} %>
				
						</select>
					</div>


					<div class="mb-3">
						<input type="hidden" value="<%=libri.getId()%>" name="id">
						<input type="submit" value="Salva" class="btn btn-primary">
					</div>
				</form>  
 				

			</div>
		</div>

		<!-- end main content -->

		<jsp:include page="template/footer.jsp"></jsp:include>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>
