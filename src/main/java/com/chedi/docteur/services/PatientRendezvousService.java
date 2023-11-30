package com.chedi.docteur.services;

import org.springframework.stereotype.Service;

import com.chedi.docteur.entities.Patient;
import com.chedi.docteur.entities.PatientRendezvousId;
import com.chedi.docteur.entities.Patient_rendezvous;
import com.chedi.docteur.repository.PatientRendezvousRepository;
@Service
public class PatientRendezvousService {
	private PatientRendezvousRepository repo;

	public PatientRendezvousService(PatientRendezvousRepository repo) {
		super();
		this.repo = repo;
	}
	public Patient_rendezvous getPatient_rendezvous(Integer patient,Integer rendezvous) {
		PatientRendezvousId patientid=new PatientRendezvousId();
		patientid.setPatient(patient);
		patientid.setRendezvous(rendezvous);
		return this.repo.getById(patientid);
	}
	public void save(Patient_rendezvous u) {
		this.repo.save(u);
	}

}
