<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"  %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
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
			<%
			 List<Collaborateur> listCollaborateurs = (List<Collaborateur>) request.getAttribute("listeCollaborateurs");
				for (Collaborateur collaborateur : listCollaborateurs) {
			%>
			<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <div class="thumbnail">
                            <div class="caption">
                                <span><%="Nom : " + collaborateur.getNom()%></span>
                                <br>
                                 <span><%="Prenom :" +collaborateur.getPrenom()%></span>
                                <br>
                                <span><%="Adresse : " + collaborateur.getAdresse()%></span>
                                 <br>
                                <span><%="Email : " + collaborateur.getEmailPro()%></span>
                                <button class="pull-right btn btn-primary" type="button" name="editer" id="editer">Editer</button>
                            </div>
                        </div>
                        </div>
			<%
				}
			%>
	</body>
</html>