package com.chedi.docteur.entities;

import java.io.Serializable;

public class PatientRendezvousId implements Serializable {
	private Integer patient;
    private Integer rendezvous;
    
	public PatientRendezvousId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getPatient() {
		return patient;
	}

	public void setPatient(Integer patient) {
		this.patient = patient;
	}

	public Integer getRendezvous() {
		return rendezvous;
	}

	public void setRendezvous(Integer rendezvous) {
		this.rendezvous = rendezvous;
	}
    
}
