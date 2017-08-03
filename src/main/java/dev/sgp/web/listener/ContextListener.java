package dev.sgp.web.listener;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

@WebListener
public class ContextListener implements ServletContextListener {
	@Inject
	private CollaborateurService collabService;
	@Inject
	private DepartementService depService;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		initDepartement();
		initCollaborateur();
	}

	public void initDepartement() {
		depService.addDepartement(new Departement("Comptabilité"));
		depService.addDepartement(new Departement("Resources Humaines"));
		depService.addDepartement(new Departement("Informatique"));
		depService.addDepartement(new Departement("Administratif"));
	}

	public void initCollaborateur() {
		List<Departement> list = depService.listerDepartement();
		collabService.sauvegarderCollaborateur(new Collaborateur("nom", "prenom", LocalDate.now(), "adresse",
				"12345678912345", ZonedDateTime.now(), list.get(0), "testeur", "0101010508"));
		collabService.sauvegarderCollaborateur(new Collaborateur("Chirac", "Patrick", LocalDate.now(), "Flot bleu",
				"12345678412345", ZonedDateTime.now(), list.get(1), "developpeur", "0101010101"));
		collabService.sauvegarderCollaborateur(new Collaborateur("Jacques", "Jacques", LocalDate.now(), "ici",
				"12345678912345", ZonedDateTime.now(), list.get(2), "chef", "0505050505"));
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
