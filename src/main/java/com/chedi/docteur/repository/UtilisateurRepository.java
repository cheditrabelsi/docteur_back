package com.chedi.docteur.repository;

import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chedi.docteur.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	java.util.Optional<Utilisateur> findByEmail(String email);
	boolean existsByEmail(String email);
}
