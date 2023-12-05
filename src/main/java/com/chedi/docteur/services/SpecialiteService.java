package com.chedi.docteur.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chedi.docteur.entities.Specialite;
import com.chedi.docteur.entities.Utilisateur;
import com.chedi.docteur.repository.SpecialiteRepository;
import com.chedi.docteur.repository.UtilisateurRepository;
@Service
public class SpecialiteService {
	private SpecialiteRepository repo;
	public SpecialiteService() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Autowired
	public SpecialiteService(SpecialiteRepository repo) {
		super();
		this.repo = repo;
	}
	public Specialite getSpecialite(Long id) {
		return this.repo.getById(id);
	}
	public List<Specialite> getAll(){
		return this.repo.findAll();
	}
	public void save(Specialite u) {
		Specialite sp=new Specialite();
		sp.setId(u.getId());
		sp.setLabel(u.getLabel());
		this.repo.save(u);
	}
}
