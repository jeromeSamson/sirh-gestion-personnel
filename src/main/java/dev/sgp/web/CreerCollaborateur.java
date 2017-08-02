package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.util.Constante;

public class CreerCollaborateur extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/collab/nouveauCollaborateur.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String numSecuSocial = req.getParameter("numSecu");
		String photo = "src/main/resources/LogoLaFlorentina.png";
		String date = req.getParameter("dateNaissance");
		LocalDate dateNaissance = LocalDate.parse(date);
		if (numSecuSocial.length() != 15) {
			resp.setStatus(400);
			resp.getWriter().write("Erreur à la saisie");
		} else {
			resp.setStatus(200);
			String matricule = "aerazr";
			Constante.COLLAB_SERVICE
					.sauvegarderCollaborateur(new Collaborateur(req.getParameter("nom"), req.getParameter("prenom"),
							dateNaissance, req.getParameter("adresse"), numSecuSocial, ZonedDateTime.now()));
			resp.sendRedirect("lister");
		}
	}

}
