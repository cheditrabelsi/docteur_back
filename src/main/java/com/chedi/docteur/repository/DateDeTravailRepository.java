package com.chedi.docteur.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chedi.docteur.entities.DateDeTravail;
import com.chedi.docteur.entities.Medecin;

import jakarta.transaction.Transactional;

public interface DateDeTravailRepository extends JpaRepository<DateDeTravail, Integer> {
	List<DateDeTravail> findByMedecin(Medecin medecin);
	
	@Transactional
    @Modifying
    @Query("DELETE FROM DateDeTravail dt WHERE dt.jour_debut = :jourDebut AND dt.jour_fin = :jourFin " +
            "AND dt.heure_debut = :heureDebut AND dt.heure_fin = :heureFin AND dt.medecin.id = :medecinId")
    void deleteByDatesAndTimesAndMedecinId(
            @Param("jourDebut") java.util.Date jourDebut,
            @Param("jourFin") java.util.Date jourFin,
            @Param("heureDebut") java.sql.Time heureDebut,
            @Param("heureFin") java.sql.Time heureFin,
            @Param("medecinId") Integer medecinId
    );
}

