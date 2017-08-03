package dev.sgp.entite;

public class Departement {
	private Integer id;
	private String nom;

	public Departement(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

}
