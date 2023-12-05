package com.chedi.docteur.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chedi.docteur.entities.Utilisateur;
import com.chedi.docteur.repository.UtilisateurRepository;

@Service
public class UtilisateurService{
private UtilisateurRepository repo;
public UtilisateurService() {
	super();
	// TODO Auto-generated constructor stub
}
@Autowired
public UtilisateurService(UtilisateurRepository repo) {
	super();
	this.repo = repo;
}

public Optional<Utilisateur> getUtilisateur(String email) {
	return this.repo.findByEmail(email);
}
public void save(Utilisateur u) {
	this.repo.save(u);
}
public boolean exist(String email) {
	return this.repo.existsByEmail(email);
}
}	
