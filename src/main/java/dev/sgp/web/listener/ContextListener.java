package dev.sgp.web.listener;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.util.Constante;

@WebListener
public class ContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<Departement> list = Constante.DEPARTEMENT_SERVICE.listerDepartement();
		Constante.COLLAB_SERVICE.sauvegarderCollaborateur(new Collaborateur("nom", "prenom", LocalDate.now(), "adresse",
				"12345678912345", ZonedDateTime.now(), list.get(0), "testeur", "0000000"));
		Constante.COLLAB_SERVICE.sauvegarderCollaborateur(new Collaborateur("Chirac", "Patrick", LocalDate.now(),
				"Flot bleu", "12345678412345", ZonedDateTime.now(), list.get(1), "developpeur", "0000000"));
		Constante.COLLAB_SERVICE.sauvegarderCollaborateur(new Collaborateur("Jacques", "Jacques", LocalDate.now(),
				"ici", "12345678912345", ZonedDateTime.now(), list.get(2), "chef", "0000000"));

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
