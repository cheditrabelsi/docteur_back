package com.chedi.docteur.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chedi.docteur.entities.Medecin;
import com.chedi.docteur.repository.MedecinRepository;

import jakarta.persistence.EntityNotFoundException;
@Service
public class MedecinService {
	private MedecinRepository repo;

	public MedecinService(MedecinRepository repo) {
		super();
		this.repo = repo;
	}

	public Medecin getMedecin(String email) {
	    return this.repo.findByEmail(email);
	}
	public String save(Medecin u) {
		return this.repo.save(u).getEmail();
	}
	public boolean exist(String email) {
		return this.repo.existsByEmail(email);
	}
	public List<Medecin> getAll(){
		return this.repo.findAll();
	}
}
