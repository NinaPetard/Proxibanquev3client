<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.objis.proxibanque.domaine.Client" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Page d'acceuil - ProxiBanque SI</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="shortcut icon" href="assets/img/ProxiBanque.jpg">
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>
    </head>
    
    <body>
    
    
  <h1><strong>Bienvenue !</h1> </strong>
	
<section class="row">

	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
 	<center><img class="img-responsive" src="assets/img/ProxiBanque.jpg" alt="logo" style="width:20%"><center><br>
		<h2>Interface Conseiller</h2><br>
		<hr />

	</div>
	</section>
	
		<section class="row">

	<div class="row">
                        <div class="col-sm-12 form-box">
                        	<div class="form-top">
                        		<div class="form-top">
                        			<center><p>Voici la liste de vos clients</p></center>
                            		
                        		</div>
						</div>

			<div class="form-bottom1">    
 				 <table class="table1">
   					 <thead>
      					<tr>
						 <th>Id Client</th>
       					 <th>Nom</th>
       					 <th>Prenom</th>
       					 <th>Adresse</th>
       					 <th>Email</th>
       					 <th> Action a realiser</th>
      					</tr>
    					</thead>
    
    					<tbody>
			<c:forEach items="${Liste}" var="item">
			 <tr>
					<form class="form-inline" method="POST" action ="MaServlet2b">
						<td><div class="form-group">
      					<input type="text" class="form-control1"  value="${item.idclient}" name="idclient" readonly="readonly">
    					</div></td>
    					<td><div class="form-group">
      					<input type="text" class="form-control2" value="${item.nom}" name="nom" readonly="readonly">
    					</div></td>
    					<td><div class="form-group">     					
      					<input type="text" class="form-control3"  value="${item.prenom}" name="prenom" readonly="readonly">
    					</div></td>
    					<td><div class="form-group">
      					<input type="text" class="form-control5"  value="${item.adresse}" name="adresse" readonly="readonly">
    					</div></td>
    					<td><div class="form-group">     					
      					<input type="text" class="form-control4"  value="${item.email}" name="email" readonly="readonly">
      					<input type="text" class="form-control1"  value="${item.idconseiller}" name="idconseiller" style=visibility:hidden>
    					</div></td>
    					<td><button type="submit" class="btn btn-default">Modifier les informations</button>
    				</form>	  
    				
    				<form class="form-inline" method="POST" action= "MaServlet3bis">
       					<input name="idclient"  value="${item.idclient}"  style = visibility:hidden;>
    	   				<button type="submit" class="btn btn-default">Liste des comptes</button>
    				</form>
    	
    				<form class="form-inline" method="POST" action= "MaServlet4b">
    					<input name="idclient"  value="${item.idclient}"  style = visibility:hidden;>
        				<button type="submit" class="btn btn-default">Virement</button>
    				</form></td>
    		<tr>
    	<br>
	</c:forEach>
    				
    					</tbody>
    					
  					</table>
  					
			</div>

	</div>
	</section>
	<hr />
	<section class="row">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
	<c:out value="${sessionScope.login}"></c:out>
		<p>Pour vous deconnecter cliquez sur:<p>
		<a href="Deconnection.jsp">Deconnection</a>
		</div>
	</section>
	
	
	
	
</div>
</body>
</html>