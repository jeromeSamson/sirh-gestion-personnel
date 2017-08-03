package dev.sgp.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.service.ActiviteService;

@WebServlet("collaborateurs/activites")
public class ActiviteController extends HttpServlet {
	@Inject
	private ActiviteService actService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("listEvt", actService.listerActivitesCollab());
		req.getRequestDispatcher("/WEB-INF/views/activites/activites.jsp").forward(req, resp);
	}
}
