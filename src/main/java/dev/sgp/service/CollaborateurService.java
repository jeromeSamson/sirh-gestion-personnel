package dev.sgp.service;

import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;

@Stateless
public class CollaborateurService {
	@Inject
	Event<CollabEvt> collabEvt;

	@PersistenceContext
	private EntityManager em;

	public List<Collaborateur> listerCollaborateurs() {
		return em.createNamedQuery("collaborateur.findAll").getResultList();
	}

	public List<Collaborateur> listerCollaborateurByDep(Integer id) {
		return em.createNamedQuery("collaborateur.findAllByDepartement").setParameter("dep", id).getResultList();

	}

	public void sauvegarderCollaborateur(Collaborateur collab) {
		String matricule = UUID.randomUUID().toString();
		collab.setPhoto("http://www.chatsdesrues.fr/wp-content/uploads/2016/10/acheter-jouet-pour-chat-pas-cher.jpg");
		String suffixe = ResourceBundle.getBundle("application").getString("suffixe");
		collab.setEmailPro(collab.getPrenom() + "." + collab.getNom() + suffixe);
		collab.setMatricule(matricule);
		collab.setActif(true);
		em.persist(collab);
		collabEvt.fire(
				new CollabEvt(collab.getDateHeurCreation(), TypeCollabEvt.CREATION_COLLAB, collab.getMatricule()));
	}

	public void updateCollaborateur(Collaborateur collab) {
		Collaborateur col = getCollabByMatricule(collab.getMatricule());
		col.setActif(collab.isActif());
		col.setAdresse(collab.getAdresse());
		col.setBanque(collab.getBanque());
		col.setBic(collab.getBic());
		col.setTel(collab.getTel());
		col.setDepartement(collab.getDepartement());
		col.setIban(collab.getIban());
		col.setIntitulePoste(collab.getIntitulePoste());
		em.merge(col);
		collabEvt.fire(
				new CollabEvt(collab.getDateHeurCreation(), TypeCollabEvt.MODIFICATION_COLLAB, collab.getMatricule()));
	}

	public Collaborateur getCollabByMatricule(String mat) {
		return listerCollaborateurs().stream().filter(p -> p.getMatricule().equals(mat)).findFirst().get();
	}

	public void updateBanque(Collaborateur collab) {
		Collaborateur col = getCollabByMatricule(collab.getMatricule());
		col.setBanque(collab.getBanque());
		col.setBic(collab.getBic());
		col.setIban(collab.getIban());
		em.merge(col);
		collabEvt.fire(
				new CollabEvt(collab.getDateHeurCreation(), TypeCollabEvt.MODIFICATION_COLLAB, collab.getMatricule()));
	}
}
