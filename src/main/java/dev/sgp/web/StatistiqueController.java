package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Statistique;
import dev.sgp.entite.VisiteWeb;
import dev.sgp.util.Constante;

public class StatistiqueController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<VisiteWeb> listVisite = Constante.VISITE_SERVICE.listerVisite();
		Map<String, List<VisiteWeb>> map = listVisite.stream().collect(Collectors.groupingBy(v -> v.getChemin()));
		List<Statistique> listStat = map.keySet().stream().map(chemin -> {
			Statistique stat = new Statistique(chemin, Constante.VISITE_SERVICE.nbVisite(chemin),
					Constante.VISITE_SERVICE.tempsMin(chemin), Constante.VISITE_SERVICE.tempsMax(chemin),
					Constante.VISITE_SERVICE.moyenne(chemin));
			return stat;
		}).collect(Collectors.toList());
		req.setAttribute("listStat", listStat);
		req.getRequestDispatcher("/WEB-INF/views/statistique/statistique.jsp").forward(req, resp);
	}
}
