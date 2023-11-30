package com.chedi.docteur.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Medecin extends Utilisateur {
@Column
	private float longitude;
@Column
	private float latitude;
@Column
	private float prixvisite;
@Column
	private String specialite;
@ManyToMany
@JoinTable(
		name="lesdateTravailMedecin",
				joinColumns =   @JoinColumn(name="medecin_id"),
				inverseJoinColumns =  @JoinColumn(name="datetravail_id"))
private List<DateDeTravail> lesDatedetravail;

public float getLongitude() {
	return longitude;
}
public void setLongitude(float longitude) {
	this.longitude = longitude;
}
public float getLatitude() {
	return latitude;
}
public void setLatitude(float latitude) {
	this.latitude = latitude;
}
public float getPrixvisite() {
	return prixvisite;
}
public void setPrixvisite(float prixvisite) {
	this.prixvisite = prixvisite;
}
public String getSpecialite() {
	return specialite;
}
public void setSpecialite(String specialite) {
	this.specialite = specialite;
}
public List<DateDeTravail> getLesDatedetravail() {
	return lesDatedetravail;
}
public void setLesDatedetravail(List<DateDeTravail> lesDatedetravail) {
	this.lesDatedetravail = lesDatedetravail;
}

}
