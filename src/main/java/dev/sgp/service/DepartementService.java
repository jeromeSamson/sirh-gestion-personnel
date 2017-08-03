package dev.sgp.service;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.sgp.entite.Departement;

@Stateless
public class DepartementService {

	@PersistenceContext
	private EntityManager em;

	public List<Departement> listerDepartement() {
		return em.createNamedQuery("dep.findAll").getResultList();
	}

	public void addDepartement(Departement dep) {
		Optional<Departement> opDep = listerDepartement().stream().filter(p -> p.getNom().equals(dep.getNom()))
				.findAny();
		if (!opDep.isPresent()) {
			em.persist(dep);
		}
	}
}
