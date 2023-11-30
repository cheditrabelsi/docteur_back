package com.chedi.docteur.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient extends Utilisateur{
	@Column
	private String cnss;
	@Column
	private Date date_de_naissance;
	@Column
	private String genre;
	@OneToMany(mappedBy = "patient")
	private List<Patient_rendezvous> LesRendezvous;
	public String getCnss() {
		return cnss;
	}
	public void setCnss(String cnss) {
		this.cnss = cnss;
	}
	public Date getDate_de_naissance() {
		return date_de_naissance;
	}
	public void setDate_de_naissance(Date date_de_naissance) {
		this.date_de_naissance = date_de_naissance;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public List<Patient_rendezvous> getLesRendezvous() {
		return LesRendezvous;
	}
	public void setLesRendezvous(List<Patient_rendezvous> lesRendezvous) {
		LesRendezvous = lesRendezvous;
	} 
	
}
