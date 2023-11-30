package com.chedi.docteur.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	@Column
	private Date date_rendezvous;
	@Column
	private int heure;
	@Column
	private String validation;
	@OneToMany(mappedBy = "rendezvous")
	private List<Patient_rendezvous> lesPatients;
	public Integer getId_rendezvous() {
		return id_rendezvous;
	}
	public void setId_rendezvous(Integer id_rendezvous) {
		this.id_rendezvous = id_rendezvous;
	}
	public Date getDate_rendezvous() {
		return date_rendezvous;
	}
	public void setDate_rendezvous(Date date_rendezvous) {
		this.date_rendezvous = date_rendezvous;
	}
	public int getHeure() {
		return heure;
	}
	public void setHeure(int heure) {
		this.heure = heure;
	}
	public String getValidation() {
		return validation;
	}
	public void setValidation(String validation) {
		this.validation = validation;
	}
	public List<Patient_rendezvous> getLesPatients() {
		return lesPatients;
	}
	public void setLesPatients(List<Patient_rendezvous> lesPatients) {
		this.lesPatients = lesPatients;
	}
	
}
