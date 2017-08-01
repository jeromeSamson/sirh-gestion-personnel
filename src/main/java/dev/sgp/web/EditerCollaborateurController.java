package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String avecMatricule = req.getParameter("matricule");
		if (avecMatricule == null) {
			resp.setStatus(400);
			resp.getWriter().write("<h1>Un matricule est attendu</h1>");
		} else {
			resp.setStatus(200);
			resp.getWriter().write("<h1> Edition de collaborateur</h1>Matricule : " + avecMatricule);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> chaine = Stream.of("matricule", "titre", "nom", "prenom").filter(p -> req.getParameter(p) == null)
				.collect(Collectors.toList());
		if (chaine.isEmpty()) {
			resp.setStatus(201);
			resp.getWriter()
					.write("Creation d'un collaborateur avec les informations suivantes : </br> matricule = "
							+ req.getParameter("matricule") + ", titre = " + req.getParameter("titre") + ", nom = "
							+ req.getParameter("nom") + ", prenom = " + req.getParameter("prenom"));
		} else {
			resp.setStatus(400);
			resp.getWriter().write("Les parametres suivants sont incorrect : " + String.join(", ", chaine));
		}
	}
}
