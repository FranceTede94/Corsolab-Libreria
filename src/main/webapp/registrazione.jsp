<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
    crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
  <div class="container mt-3 text-center card ">
  
  
  <jsp:include page="template/header.jsp"></jsp:include>
 
 
  <!-- main content -->
  <div class="row">
      <div class="col-12 text-center">
         <h1>Registrazione</h1>
         <h2>Compila i seguenti dati per registrarti alla libreria</h2>
         <hr>
        
        <jsp:include page="include/alert.jsp"></jsp:include>
         
    </div>
 </div>
 
 
  <div class="row">
      <div class="col-12">
        
        <form method="post" action="./registerUser">
        
        	<div class="mb-3">
        	
        	<label for="name">Nome</label>
        	<input type="text" name="nome" id="nome" class="form-control" required>
       
        	</div>
        	
        	
        	<div class="mb-3">
        	
        	<label for="cognome">Cognome</label>
        	<input type="text" name="cognome" id="cognome" class="form-control" required>
       
        	</div>
        	
        	
        	<div class="mb-3">
        	
        	<label for="email">Email</label>
        	<input type="email" name="email" id="email" class="form-control" required>
       
        	</div>
        	
   
           	<div class="mb-3">
        	
        	<label for="password">Password</label>
        	<input type="password" name="password" id="password" class="form-control" required>
       
        	</div>
        	
        	<div class="mb-3">
			<input type="submit" value="Salva" class="btn btn-primary">
			</div>
        </form>
        
        
    </div>
 </div>
 
 
 
  <!-- end main content -->
  

   
   
  </div>
  <div class="text-center">
    <jsp:include page="template/footer.jsp"></jsp:include>
    </div>
    

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>