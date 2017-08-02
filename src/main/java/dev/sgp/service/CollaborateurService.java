package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

import dev.sgp.entite.Collaborateur;

public class CollaborateurService {
	List<Collaborateur> listeCollaborateurs = new ArrayList<>();

	public List<Collaborateur> listerCollaborateurs() {
		return listeCollaborateurs;
	}

	public void sauvegarderCollaborateur(Collaborateur collab) {
		String matricule = UUID.randomUUID().toString();
		String suffixe = ResourceBundle.getBundle("application").getString("suffixe");
		collab.setEmailPro(collab.getPrenom() + "." + collab.getNom() + suffixe);
		collab.setMatricule(matricule);
		collab.setActif(true);
		listeCollaborateurs.add(collab);
	}
}
