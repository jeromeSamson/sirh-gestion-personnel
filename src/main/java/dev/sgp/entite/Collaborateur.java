package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "collaborateur.findAll", query = "Select c from Collaborateur c"),
		@NamedQuery(name = "collaborateur.findByMatricule", query = "Select c from Collaborateur c where c.matricule=:matricule") })
public class Collaborateur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String matricule;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String adresse;
	private String numSecuSocial;
	private String emailPro;
	private String photo;
	private String tel;
	private ZonedDateTime dateHeurCreation;
	private boolean actif;
	private String intitulePoste;
	private String banque;
	private String iban;
	private String bic;

	@ManyToOne
	private Departement departement;

	public Collaborateur(String nom, String prenom, LocalDate dateNaissance, String adresse, String numSecuSocial,
			ZonedDateTime dateHeurCreation) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.numSecuSocial = numSecuSocial;
		this.dateHeurCreation = dateHeurCreation;

	}

	public Collaborateur() {

	}

	public Collaborateur(String nom, String prenom, LocalDate dateNaissance, String adresse, String numSecuSocial,
			ZonedDateTime dateHeurCreation, Departement dp, String poste, String tel) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.numSecuSocial = numSecuSocial;
		this.dateHeurCreation = dateHeurCreation;
		this.departement = dp;
		this.intitulePoste = poste;
		this.tel = tel;

	}

	public Collaborateur(String matricule, String adresse, String tel, boolean actif, String intitulePoste,
			String banque, String iban, String bic, Departement departement) {
		this.matricule = matricule;
		this.adresse = adresse;
		this.tel = tel;
		this.actif = actif;
		this.intitulePoste = intitulePoste;
		this.banque = banque;
		this.iban = iban;
		this.bic = bic;
		this.departement = departement;

	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumSecuSocial() {
		return numSecuSocial;
	}

	public void setNumSecuSocial(String numSecuSocial) {
		this.numSecuSocial = numSecuSocial;
	}

	public String getEmailPro() {
		return emailPro;
	}

	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public ZonedDateTime getDateHeurCreation() {
		return dateHeurCreation;
	}

	public void setDateHeurCreation(ZonedDateTime dateHeurCreation) {
		this.dateHeurCreation = dateHeurCreation;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public String getIntitulePoste() {
		return intitulePoste;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public String getBanque() {
		return banque;
	}

	public void setBanque(String banque) {
		this.banque = banque;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

}
