<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
    crossorigin="anonymous">
<title>Recupero password</title>
</head>

<body>
<br>
<div class="container text-center">
<h3>Modifica la tua password</h3>
</div>

 <div class="container">
      <div class="col-12">
        
        <form method="post" action="./modificaPassword">
     
            <div class="container text-center">
             	
        		<label class="text-uppercase" for="email">Email</label>
        		<input type="text" name="email" id="email" class="form-control" required>
        		
        		<label class="text-uppercase" for="password">Password</label>
        		<input type="password" name="password" id="password" class="form-control" required>
       
				<input type="submit" value="Invia" class="btn btn-primary">
				
			</div>
        </form>
        
   
    </div>
 </div>

 
</body>
</html>