package com.chedi.docteur.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
public class Specialite {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String label;
private String Description;
@ManyToMany(mappedBy = "specialites")
@JsonIgnoreProperties("specialites")
private List<Medecin> medecins;
public Specialite() {
	super();
	// TODO Auto-generated constructor stub
}

public Specialite(String label) {
    this.label = label;
}
public Specialite(Long id) {
    this.id = id;
}

public String getDescription() {
	return Description;
}

public void setDescription(String description) {
	Description = description;
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getLabel() {
	return label;
}
public void setLabel(String label) {
	this.label = label;
}

}
