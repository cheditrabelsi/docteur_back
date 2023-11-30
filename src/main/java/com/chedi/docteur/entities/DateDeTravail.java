package com.chedi.docteur.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class DateDeTravail {
	@Id
private Integer id_travail;
	private int jour;
	private int heure_debut;
	private int heure_fin;
	@ManyToMany(mappedBy = "lesDatedetravail")
	private List<Medecin> lesMedecins;
	public Integer getId_travail() {
		return id_travail;
	}
	public void setId_travail(Integer id_travail) {
		this.id_travail = id_travail;
	}
	public int getJour() {
		return jour;
	}
	public void setJour(int jour) {
		this.jour = jour;
	}
	public int getHeure_debut() {
		return heure_debut;
	}
	public void setHeure_debut(int heure_debut) {
		this.heure_debut = heure_debut;
	}
	public int getHeure_fin() {
		return heure_fin;
	}
	public void setHeure_fin(int heure_fin) {
		this.heure_fin = heure_fin;
	}
	public List<Medecin> getLesMedecins() {
		return lesMedecins;
	}
	public void setLesMedecins(List<Medecin> lesMedecins) {
		this.lesMedecins = lesMedecins;
	}
	
}
