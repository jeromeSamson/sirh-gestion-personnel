package dev.sgp.entite;

public class Statistique {
	private String chemin;
	private Integer nbVisite;
	private Integer tempsMin;
	private Integer tempsMax;
	private Integer moyenne;

	public Statistique(String chemin, Integer nbVisite, Integer tempsMin, Integer tempsMax, Integer moyenne) {
		super();
		this.chemin = chemin;
		this.nbVisite = nbVisite;
		this.tempsMin = tempsMin;
		this.tempsMax = tempsMax;
		this.moyenne = moyenne;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public long getNbVisite() {
		return nbVisite;
	}

	public void setNbVisite(Integer nbVisite) {
		this.nbVisite = nbVisite;
	}

	public Integer getTempsMin() {
		return tempsMin;
	}

	public void setTempsMin(Integer tempsMin) {
		this.tempsMin = tempsMin;
	}

	public long getTempsMax() {
		return tempsMax;
	}

	public void setTempsMax(Integer tempsMax) {
		this.tempsMax = tempsMax;
	}

	public Integer getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(Integer moyenne) {
		this.moyenne = moyenne;
	}

}
