package com.chedi.docteur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chedi.docteur.entities.Medecin;
import com.chedi.docteur.entities.Patient;

public interface MedecinRepository extends JpaRepository<Medecin, Integer> {
	Medecin findByEmailAndMdp(String email,String pwd);
}
