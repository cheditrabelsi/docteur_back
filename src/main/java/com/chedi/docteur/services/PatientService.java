package com.chedi.docteur.services;

import org.springframework.stereotype.Service;
import com.chedi.docteur.entities.Patient;
import com.chedi.docteur.repository.PatientRepository;

@Service
public class PatientService {
	private PatientRepository repo;
	public PatientService(PatientRepository repo) {
		super();
		this.repo = repo;
	}
	public Patient getPatient(String email,String pwd) {
		return this.repo.findByEmailAndMdp(email, pwd);
	}
	public int save(Patient u) {
		return this.repo.save(u).getId();
	}
}
