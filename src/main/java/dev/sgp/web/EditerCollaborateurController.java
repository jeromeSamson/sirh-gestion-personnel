package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

@WebServlet("collaborateurs/editer")
public class EditerCollaborateurController extends HttpServlet {
	@Inject
	DepartementService depService;
	@Inject
	CollaborateurService collabService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String mat = req.getParameter("matricule");
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("collab", collabService.getCollabByMatricule(mat));
		req.setAttribute("listeDepartements", depService.listerDepartement());
		req.getRequestDispatcher("/WEB-INF/views/collab/editerCollab.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String matricule = req.getParameter("matricule");
		String adresse = req.getParameter("adresse");
		String tel = req.getParameter("telephone");
		boolean actif = !(req.getParameter("actif") != null);
		String intitulePoste = req.getParameter("intitulePoste");
		String banque = req.getParameter("banque");
		String iban = req.getParameter("iban");
		String bic = req.getParameter("bic");
		String idDep = req.getParameter("departement");
		List<Departement> listDep = depService.listerDepartement();
		int index = Integer.parseInt(idDep) - 1;
		Departement departement = listDep.get(index);

		collabService.updateCollaborateur(
				new Collaborateur(matricule, adresse, tel, actif, intitulePoste, banque, iban, bic, departement));

		resp.sendRedirect("lister");

	}
}
