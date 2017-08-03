<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.css'></c:url>">
<title>SGP - App</title>
<style>
.thumbnail>img {
	height: 200px;
}

.thumbnail>.caption>span {
	color: black;
	width: 100%;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<header class="page-header">
			<h1>Les collaborateurs</h1>
		</header>
		<div class="form-group text-center">
			<form class="form-inline text-left" style="margin-bottom: 10px;">
				<label class="col-md-12 control-label" for="appendedtext">Rechercher
					un nom ou un prénom qui commence par : <input type="text"
					class="form-control" placeholder="Recherche" size="50%;">
					<button class="btn btn-secondary btn-primary" type="button">Rechercher</button>
				</label> <label class="col-md-6 control-label" for="selectbasic"
					style="margin-top: 10px;">Rechercher par département : <select
					id="departement" name="listDepartement" class="form-control">
							<option value="0">Tous</option> 
						<c:forEach var="dep" items="${listDepartement}" varStatus="loop">
							<option value="${loop.index+1}">${dep.nom}</option>
						</c:forEach>
				</select>
				</label>
				<div class="form-group">
				<div class="col-md-6	">
						<label class="checkbox-inline" for="checkboxes-0"> <input
							type="checkbox" name="checkboxes" id="checkboxes-0" value="0">
							<span>Voir les collaborateurs désactivés</span>
						</label>
					</div>					
				</div>
			</form>
		</div>
	</div>
		<div class="container-fluid">
		<div class="row">
		<c:forEach var="collab" items="${listCollaborateurs}">
			<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"
				style="margin-top: 10px;">
				<form class="form-inline">
					<div class="thumbnail" style="margin-right: 10px">
						<span><h3>${collab.nom}, ${collab.prenom}</h3></span>
						<div class="row">
						<div class="caption col-offset-1 col-md-4">
						<img alt="test" src="${collab.photo}" class="text-left img-responsive img-circle" width="40%" >
						</div>
						<div class="col-md-6">
							<span>Fonction : ${collab.intitulePoste}</span> <br>
							<span>Département : ${collab.departement.nom}</span><br>
							<span>Email : ${collab.emailPro}</span>
							<span>Telephone : ${collab.tel}</span>
							<button class="pull-right btn btn-primary" type="button"
								name="editer" id="editer">Editer</button>
						</div>
					</div>
					</div>
				</form>
			</div>
			</c:forEach>
		</div>
		
		<label class="control-label" for="Envoyer"></label>
		<div class="col-md-4">
			<a id="Statistiques"
				href='<c:url value="creerCollaborateur"></c:url>'
				class="btn btn-primary">Créer Collaborateur</a>
		</div>
	</div>


	<footer style="margin: 25px;">
		<a style="margin: 25px;" href="<c:url value='stats'></c:url>">Statistique</a>
	</footer>


</body>
</html>