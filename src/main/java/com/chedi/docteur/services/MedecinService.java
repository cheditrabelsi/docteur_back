package com.chedi.docteur.services;

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

	public Medecin getMedecin(String email,String pwd) {
	    return this.repo.findByEmailAndMdp(email, pwd);
	}
	public int save(Medecin u) {
		return this.repo.save(u).getId();
	}
}
