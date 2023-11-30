package com.chedi.docteur.services;

import org.springframework.stereotype.Service;

import com.chedi.docteur.entities.Utilisateur;
import com.chedi.docteur.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
private UtilisateurRepository repo;
public UtilisateurService() {
	super();
	// TODO Auto-generated constructor stub
}

public UtilisateurService(UtilisateurRepository repo) {
	super();
	this.repo = repo;
}

public Utilisateur getUtilisateur(Integer id) {
	return this.repo.getById(id);
}
public void save(Utilisateur u) {
	this.repo.save(u);
}
}	
