package com.chedi.docteur.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(PatientRendezvousId.class)
public class Patient_rendezvous {

	    @Id
	    @ManyToOne
	    @JoinColumn(name = "patient_id")
	    private Patient patient;

	    @Id
	    @ManyToOne
	    
	    @JoinColumn(name = "rendezvous_id")
	    private Rendezvous rendezvous;
	    
	    private String observation;
	    private String ordonance;
		public Patient getPatient() {
			return patient;
		}
		public void setPatient(Patient patient) {
			this.patient = patient;
		}
		public Rendezvous getRendezvous() {
			return rendezvous;
		}
		public void setRendezvous(Rendezvous rendezvous) {
			this.rendezvous = rendezvous;
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
