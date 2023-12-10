package com.chedi.docteur.entities;

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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;	
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Medecin extends Utilisateur {
@Column
	private float longitude;
@Column
	private float latitude;
@Column
private String image;
@Column
private float prixvisite;
@OneToMany(mappedBy = "medecin") 
@JsonManagedReference
private List<DateDeTravail> lesDatedetravail;
@ManyToMany
@JoinTable(
    name = "medecin_specialite",
    joinColumns = @JoinColumn(name = "medecin_id"),
    inverseJoinColumns = @JoinColumn(name = "specialite_id")
)
@JsonIgnoreProperties("medecins")
private List<Specialite> specialites;
@ManyToMany
@JoinTable(
    name = "rendezvous",
    joinColumns = @JoinColumn(name = "medecin_id"),
    inverseJoinColumns = @JoinColumn(name = "patient_id")
)
private List<Patient> patients;
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
public List<DateDeTravail> getLesDatedetravail() {
	return lesDatedetravail;
}
public void setLesDatedetravail(List<DateDeTravail> lesDatedetravail) {
	this.lesDatedetravail = lesDatedetravail;
}

public List<Specialite> getSpecialites() {
	return specialites;
}
public void setSpecialites(List<Specialite> specialites) {
	this.specialites = specialites;
}
public List<Patient> getPatients() {
	return patients;
}
public void setPatients(List<Patient> patients) {
	this.patients = patients;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
@Override
public String toString() {
	return "Medecin [longitude=" + longitude + ", latitude=" + latitude + ", prixvisite=" + prixvisite
			+ ", lesDatedetravail=" + lesDatedetravail + ", specialites=" + specialites + ", patients=" + patients
			+ "]";
}

}
