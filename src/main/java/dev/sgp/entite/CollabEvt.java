package dev.sgp.entite;

import java.time.ZonedDateTime;

public class CollabEvt {
	private ZonedDateTime dateHeure;
	private TypeCollabEvt type;
	private String matricule;

	public CollabEvt(ZonedDateTime dateHeurCreation, TypeCollabEvt typeEvt, String matricule) {
		this.dateHeure = dateHeurCreation;
		this.type = typeEvt;
		this.matricule = matricule;
	}

	public ZonedDateTime getDateHeure() {
		return dateHeure;
	}

	public void setDateHeure(ZonedDateTime dateHeure) {
		this.dateHeure = dateHeure;
	}

	public TypeCollabEvt getType() {
		return type;
	}

	public void setType(TypeCollabEvt type) {
		this.type = type;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

}
