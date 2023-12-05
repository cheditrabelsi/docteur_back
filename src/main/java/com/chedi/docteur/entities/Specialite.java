package com.chedi.docteur.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;

@Entity
public class Specialite {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String label;
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
