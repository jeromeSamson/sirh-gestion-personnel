package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;

@WebServlet("collaborateurs/creerCollaborateur")
public class CreerCollaborateur extends HttpServlet {
	@Inject
	CollaborateurService colService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/WEB-INF/views/collab/nouveauCollaborateur.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String numSecuSocial = req.getParameter("numSecu");
		String photo = "http://www.chatsdesrues.fr/wp-content/uploads/2016/10/acheter-jouet-pour-chat-pas-cher.jpg";
		String date = req.getParameter("dateNaissance");
		LocalDate dateNaissance = LocalDate.parse(date);
		if (numSecuSocial.length() != 15) {
			resp.setStatus(400);
			resp.getWriter().write("Erreur à la saisie");
		} else {
			resp.setStatus(200);
			colService.sauvegarderCollaborateur(new Collaborateur(req.getParameter("nom"), req.getParameter("prenom"),
					dateNaissance, req.getParameter("adresse"), numSecuSocial, ZonedDateTime.now()));
			resp.sendRedirect("lister");

		}
	}

}
