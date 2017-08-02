<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"  %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.css'></c:url>">
		<title>SGP - App</title>
		<style>
		
            .thumbnail > img {
                height:200px;
            }

            .thumbnail > .caption > span {
                color: black;
                width: 100%;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis; 
            }
		
		</style>
	</head>
	<body>
		<h1>Les collaborateurs</h1>
		<c:forEach var="collab" items="${listCollaborateurs}">
			<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
						
                        <div class="thumbnail">
                            <div class="caption">
                                <span>Nom :  ${collab.nom}</span>
                                <br>
                                 <span>Prenom : ${collab.prenom}</span>
                                <br>
                                <span>Adresse : ${collab.adresse}</span>
                                 <br>
                                <span>Email : ${collab.emailPro}</span>
                                <button class="pull-right btn btn-primary" type="button" name="editer" id="editer">Editer</button>
                            </div>
                        </div>
            </div>
        </c:forEach>
			
	</body>
</html>