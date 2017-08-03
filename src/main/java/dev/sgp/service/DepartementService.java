package dev.sgp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import dev.sgp.entite.Departement;

public class DepartementService {
	List<Departement> listDepartement = new ArrayList<>(Arrays.asList(new Departement("Comptabilité"),
			new Departement("Resources Humaines"), new Departement("Informatique"), new Departement("Administratif")));

	public List<Departement> listerDepartement() {
		return listDepartement;
	}

	public void addDepartement(Departement dep) {
		Optional<Departement> opDep = listDepartement.stream().filter(p -> p.getNom().equals(dep.getNom())).findAny();
		if (!opDep.isPresent()) {
			listDepartement.add(dep);
		}
	}
}
