<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Comptes client - ProxiBanque SI</title>

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
	
<section class="row">

	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
 	<center><img class="img-responsive" src="assets/img/ProxiBanque.jpg" alt="logo" style="width:20%"><center><br>
	<h2>Liste des comptes d'un client</h2>
	</div>
</section>
	
<section class="row">

	<div class="row">
             <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top">
                        			<center><p>Voici la liste des comptes de <c:out value="${client.prenom}"/> <c:out value="${client.nom}"/></p></center>
                            		
                        		</div>
						</div>
						<div class="form-bottom">    
 				 			<table class="table">
   							 <thead>
      							<tr>
						  			<th>Numero de compte</th>
						  			<th>Id du propriétaire</th>
       					 			<th>Type de compte</th>
       					  			<th>Solde de compte (euros)</th> 
      							</tr>
    							</thead>
    
    							<tbody>
    								<c:forEach items="${Listecompte}" var="item"> 
     							 <tr>
      							<td>${item.idcompte}</td>
    								<td>${item.idclient}</td>
        							<td>${item.typecompte}</td>
       					   	 	<td>${item.solde}</td>
      							</tr>
    								</c:forEach>
    							</tbody>
  							</table>
						</div>			
			</div>
	</div>
</section>
	<hr />
	<section class="row">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
	<c:out value="${sessionScope.login}"></c:out>
	<section class="row">

	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		 <a href="Accueil.jsp">Retour accueil</a><br>
		 <a href="Deconnection.jsp">Se deconnecter</a>
	</div>
	</section>
</div>
</body>