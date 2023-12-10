package com.chedi.docteur.entities;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rendezvous {
	@Id
	@GeneratedValue
private Integer id_rendezvous;
	private Date dateRendezVous;
	@Column
	private Time heure;
	@Column
	private String validation;
	 private String observation;
	    private String ordonance;
	@ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    
	public Rendezvous() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rendezvous(Integer id_rendezvous, Date dateRendezVous, Time heure, String validation, String observation,
			String ordonance, Medecin medecin, Patient patient) {
		super();
		this.id_rendezvous = id_rendezvous;
		this.dateRendezVous = dateRendezVous;
		this.heure = heure;
		this.validation = validation;
		this.observation = observation;
		this.ordonance = ordonance;
		this.medecin = medecin;
		this.patient = patient;
	}
	public Integer getId_rendezvous() {
		return id_rendezvous;
	}
	public void setId_rendezvous(Integer id_rendezvous) {
		this.id_rendezvous = id_rendezvous;
	}
	
	
	public Date getDateRendezVous() {
		return dateRendezVous;
	}
	public void setDateRendezVous(Date dateRendezVous) {
		this.dateRendezVous = dateRendezVous;
	}
	public Time getHeure() {
		return heure;
	}
	public void setHeure(Time heure) {
		this.heure = heure;
	}
	public String getValidation() {
		return validation;
	}
	public void setValidation(String validation) {
		this.validation = validation;
	}
	public Medecin getMedecin() {
		return medecin;
	}
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public String getOrdonance() {
		return ordonance;
	}
	public void setOrdonance(String ordonance) {
		this.ordonance = ordonance;
	}
	
}
