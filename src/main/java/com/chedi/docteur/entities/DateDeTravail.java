package com.chedi.docteur.entities;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class DateDeTravail {
	@Id
	@GeneratedValue
	private Integer id_travail;
	private Date jour_debut;
	private Date jour_fin;
	private Time heure_debut;
	private Time heure_fin;
	private String label;
	@ManyToOne 
    @JoinColumn(name = "medecin_id") 
	@JsonBackReference
    private Medecin medecin;
	public Integer getId_travail() {
		return id_travail;
	}
	public void setId_travail(Integer id_travail) {
		this.id_travail = id_travail;
	}
	
	
	public Date getJour_debut() {
		return jour_debut;
	}
	public void setJour_debut(Date jour_debut) {
		this.jour_debut = jour_debut;
	}
	public Date getJour_fin() {
		return jour_fin;
	}
	public void setJour_fin(Date jour_fin) {
		this.jour_fin = jour_fin;
	}
	public Time getHeure_debut() {
		return heure_debut;
	}
	public void setHeure_debut(Time heure_debut) {
		this.heure_debut = heure_debut;
	}
	public Time getHeure_fin() {
		return heure_fin;
	}
	public void setHeure_fin(Time heure_fin) {
		this.heure_fin = heure_fin;
	}
	
	public Medecin getMedecin() {
		return medecin;
	}
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
