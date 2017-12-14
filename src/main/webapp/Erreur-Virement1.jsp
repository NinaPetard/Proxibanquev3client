<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Virement - ProxiBanque SI</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/font-awesome/css/font-awesome.min.css">
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
		<center>
			<img class="img-responsive" src="assets/img/ProxiBanque.jpg"
				alt="logo" style="width: 20%">
			<center>
				<br>
				<h3>
					Erreur: Le virement a echoué<br>
					Le montant du virement est superieur au solde du compte a debiter
				</h3>

				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<h2>Virement compte a compte</h2>
				</div>
				
				<section class="row">
					<div class="row">
						<div class="col-sm-10 col-sm-offset-1 form-box">
							<div class="form-top">
								<div class="form-top">
									<center>
										<p1>Realiser un virement</p1>
									</center>
								</div>
							</div>
							<div class="form-bottom2">
								<table class="table">
									<thead>
										<tr>
											<th>Compte a debiter</th>
											<th>Compte a crediter</th>
											<th>Montant</th>
											<th>Action</th>
										</tr>
									</thead>

									<tbody>
										<form class="form-inline" action="ServletVirement" method="post" >
										<c:forEach items="${ListeTypeCompte}" var="item">
									<input type="text" class="form-control1"  value="${item.idclient}" name="idclient" style=visibility:hidden>
										</c:forEach>
											<td><label for="typecompte_debit"></label>
											<select id="typecompte_debit" name="typecompte_debit" class="form-control1">
												<c:forEach items="${ListeTypeCompte}" var="item">
													<option value="${item.typecompte}">${item.typecompte}</option>
												</c:forEach></td>
											</select>
											<td><label for="typecompte_credit"></label> 
											<select id="typecompte_credit" name="typecompte_credit">
												<option value="Courant">courant</option>
												<option value="Epargne">epargne</option>
												<option value="Externe">externe</option>
											</select> </td>
											<td><label for="montant"></label> 
											<input type="text" value="0" id="montant_virement" name="montant_virement"
												placeholder="Saisir le montant du virement"> </td><br>
												<br>
										<td>
										<button type="submit" class="btn btn-default"> Effectuer le virement</button>
										</td>	
										<td></form>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</section>

				<hr />
				<section class="row">

					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<a href="Accueil.jsp">Retour accueil</a><br> 
						<a href="Deconnection.jsp">Deconnection</a>
					</div>
				</section>
</body>
</html>