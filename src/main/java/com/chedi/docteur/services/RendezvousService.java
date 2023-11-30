package com.chedi.docteur.services;

import org.springframework.stereotype.Service;

import com.chedi.docteur.entities.Rendezvous;
import com.chedi.docteur.entities.Utilisateur;
import com.chedi.docteur.repository.RendezvousRepository;

@Service
public class RendezvousService {
private RendezvousRepository repo;

public RendezvousService(RendezvousRepository repo) {
	super();
	this.repo = repo;
}
public Rendezvous getRendezvous(Integer id) {
	return this.repo.getById(id);
}
public void save(Rendezvous rdv) {
	this.repo.save(rdv);
}
}
