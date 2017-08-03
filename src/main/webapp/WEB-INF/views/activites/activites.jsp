<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page import="java.util.List"%>
    <%@ page import="dev.sgp.entite.CollabEvt"%>
    <%@ page import="dev.sgp.entite.TypeCollabEvt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.css'></c:url>">
<title>SGP - App</title>
<title>Insert title here</title>
</head>
<body>

	<div id="Activite" class="col-lg-11 col-lg-offset-1">
		<div>
		<h1>Activités depuis le démarage de l'application</h1>
	</div>
	<table class="table table-striped table-bordered" style="border-width: 2px; border-color: black; ">
		<thead>
			<tr>
				<th>Date/Heure</th>
				<th>Libellé</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="evt" items="${listEvt}">
				<tr>
					<td>${evt.dateHeure}</td>
					<c:choose>
					<c:when test="${evt.type == TypeCollabEvt.CREATION_COLLAB }">
						<td>Création d'un nouveau collaborateur - matricule : ${evt.matricule}</td>
					</c:when>
					<c:otherwise>
						<td>Modification d'un collaborateur - matricule : ${evt.matricule}</td>
					</c:otherwise>
					</c:choose>
					
						
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>