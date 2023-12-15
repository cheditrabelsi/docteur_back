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
	public Patient getPatient(String email) {
		return this.repo.findByEmail(email);
	}
	public String save(Patient u) {
		return this.repo.save(u).getEmail();
	}
	public boolean exist(String email) {
		return this.repo.existsByEmail(email);
	}
}
