package dev.sgp.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

@WebServlet("collaborateurs/lister")
public class ListerCollaborateursController extends HttpServlet {
	@Inject
	private CollaborateurService collabService;

	@Inject
	private DepartementService departementService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// resp.getWriter().write("Hello ListerCollaborateursController");
		// // récupère la valeur d'un paramètre dont le nom est avecPhoto
		// String avecPhotoParam = req.getParameter("avecPhoto");
		// // récupère la valeur d'un paramètre dont le nom est departement
		// String departementParam = req.getParameter("departement");
		// resp.setContentType("text/html");
		// // code HTML écrit dans le corps de la réponse
		// resp.getWriter().write("<h1>Liste des collaborateurs</h1>" + "<ul>" +
		// "<li>avecPhoto=" + avecPhotoParam
		// + "</li>" + "<li>departement=" + departementParam + "</li>" +
		// "</ul>");
		// req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(req,
		// resp);
		req.setAttribute("listCollaborateurs", collabService.listerCollaborateurs());
		req.setAttribute("listDepartement", departementService.listerDepartement());
		req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(req, resp);
	}

}
