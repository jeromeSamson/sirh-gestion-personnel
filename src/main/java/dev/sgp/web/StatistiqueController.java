package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Statistique;
import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteService;

@WebServlet("collaborateurs/stats")
public class StatistiqueController extends HttpServlet {
	@Inject
	VisiteService visiteService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		List<VisiteWeb> listVisite = visiteService.listerVisite();
		Map<String, List<VisiteWeb>> map = listVisite.stream().collect(Collectors.groupingBy(v -> v.getChemin()));

		List<Statistique> listStat = map.keySet().stream().map(chemin -> {
			Statistique stat = new Statistique(chemin, visiteService.nbVisite(chemin), visiteService.tempsMin(chemin),
					visiteService.tempsMax(chemin), visiteService.moyenne(chemin));
			return stat;
		}).collect(Collectors.toList());
		req.setAttribute("listStat", listStat);
		req.getRequestDispatcher("/WEB-INF/views/statistique/statistique.jsp").forward(req, resp);
	}
}
