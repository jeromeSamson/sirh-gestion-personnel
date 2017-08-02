package dev.sgp.listener;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.util.Constante;

public class DemarrageSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		Constante.COLLAB_SERVICE.sauvegarderCollaborateur(
				new Collaborateur("nom", "prenom", LocalDate.now(), "adresse", "12345678912345", ZonedDateTime.now()));
		Constante.COLLAB_SERVICE.sauvegarderCollaborateur(new Collaborateur("Chirac", "Patrick", LocalDate.now(),
				"Flot bleu", "12345678412345", ZonedDateTime.now()));
		Constante.COLLAB_SERVICE.sauvegarderCollaborateur(
				new Collaborateur("Jacques", "Jacques", LocalDate.now(), "ici", "12345678912345", ZonedDateTime.now()));

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub

	}

}
