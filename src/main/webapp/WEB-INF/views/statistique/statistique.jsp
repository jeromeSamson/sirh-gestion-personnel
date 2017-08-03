<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Statistique"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.css'></c:url>">
<title>SGP - App</title>
<title>Insert title here</title>
</head>
<body>
	<h1>Statistique</h1>
	<div id="Stat" class="col-lg-11 col-lg-offset-1">
		
    	<table class="table table-striped">
    	<thead>
    		<tr>
    			<th>Chemin</th>
    			<th>Nombre de visite</th>
    			<th>Min</th>
    			<th>Max</th>
    			<th>Moyenne</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach var="stat" items="${listStat}">
    			<tr>
    				<td> ${stat.chemin}</td>
    				<td> ${stat.nbVisite}</td>
    				<td> ${stat.tempsMin}</td>
    				<td> ${stat.tempsMax}</td>
    				<td>${stat.moyenne}</td>		
    			</tr>
    		</c:forEach>
    	</tbody>
    	</table>
    </div>
    <br>
    <a style="margin: 25px;" href="<c:url value='lister'></c:url>">Lister les collaborateurs</a>    
</body>
</html>