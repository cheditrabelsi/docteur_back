package com.chedi.docteur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chedi.docteur.entities.Medecin;
import com.chedi.docteur.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	Patient findByEmail(String email);
}
