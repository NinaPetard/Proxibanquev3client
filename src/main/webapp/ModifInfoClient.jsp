<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>ModifInfoClient - ProxiBanque SI</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="shortcut icon" href="assets/img/ProxiBanque.jpg">
        
        <!-- JAVASCRIPT -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>
    </head>
    <body>
	<section class="row">
    <center><img class="img-responsive" src="assets/img/ProxiBanque.jpg" alt="logo" style="width:20%"><center><br>

	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<h2>Edition du client <c:out value="${client.prenom}"/> <c:out value="${client.nom}"/></h2>
		<p>Pour toute modification, pensez a demander un justificatif au client<p>
	</div>

	<div class="row">
           <div class="col-sm-6 col-sm-offset-3 form-box">
               <div class="form-top">
                    <div class="form-top">
                     <center><p>Merci de remplir les champs ci-dessous</p></center>
    			
                    </div>
   
                </div>
                    <div class="form-bottom">
    			  
			        <form action="MaServlet2bis" method="post" class="login-form">
			       
				
						<div class="form-group">
						<label for="idclient">Id Client :</label>
						<td><input type="text" class="form-control1" value="${Session_SaveID.idclient}" name="idclient" readonly="readonly" ></td>
						</div>
						
						<div class="form-group">
						<label for="nom">Nom :</label>
						<td><input type="text" class="form-control1" value="${Session_SaveID.nom}" name="nom"  ></td>
						</div class="form-group">
						
						<div class="form-group">
						<label for="prenom">Prenom :</label>
						<td><input type="text" class="form-control1"  value="${Session_SaveID.prenom}" name="prenom"  ></td>
						</div class="form-group">
						
						<div class="form-group">
						<label for="email">Email :</label>
						<td><input type="text" class="form-control1"  value="${Session_SaveID.email}" name="email"  ></td>
						</div class="form-group">
						
						<div class="form-group">
						<label for="codepostal">Adresse :</label>
						 <td><input type="text" class="form-control1"  value="${Session_SaveID.adresse}" name="adresse"  ></td>
						</div class="form-group">
						<input type="text" class="form-control1" value="${Session_SaveID.idconseiller}" name="idconseiller" style=visibility:hidden >
						
						<button type="submit" class="btn btn-success"> Enregistrer les modifications</button><br />
			             </form>      	
			       
		            </div>
            </div>
      </div>
	</section>
	<hr />
	<section class="row">

	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		 <a href="Accueil.jsp">Retour accueil</a><br>
		 <a href="Deconnection.jsp">Se deconnecter</a>
	</div>
	</section>
</body>
</html>