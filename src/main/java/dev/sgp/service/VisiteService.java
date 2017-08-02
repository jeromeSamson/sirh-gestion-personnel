package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.VisiteWeb;

public class VisiteService {
	List<VisiteWeb> listVisit = new ArrayList<>();

	public List<VisiteWeb> listerVisite() {
		return listVisit;
	}

	public void sauvegarderVisite(VisiteWeb visit) {
		listVisit.add(visit);
	}

	public int nbVisite(String chemin) {
		return (int) listVisit.stream().filter(p -> p.getChemin().equals(chemin)).count();
	}

	public int tempsMin(String chemin) {
		return listVisit.stream().filter(p -> p.getChemin().equals(chemin)).mapToInt(VisiteWeb::getTempsExecution).min()
				.getAsInt();
	}

	public int tempsMax(String chemin) {
		return listVisit.stream().filter(p -> p.getChemin().equals(chemin)).mapToInt(VisiteWeb::getTempsExecution).max()
				.getAsInt();
	}

	public int moyenne(String chemin) {
		return (int) Math.round(listVisit.stream().filter(p -> p.getChemin().equals(chemin))
				.mapToInt(VisiteWeb::getTempsExecution).average().getAsDouble());

	}

}
