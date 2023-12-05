	package com.chedi.docteur.entities;
	
	
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
	
	@Entity
	@Inheritance(strategy = InheritanceType.JOINED)
	public class Utilisateur{
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		@Column(unique = true)
		private String email;
		@Column
		private String mdp;
		@Column
		private String nom;
		@Column
		private String prenom;
		@Column
		private int tel;
		private String role;
		public Utilisateur() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Utilisateur(int id, String nom, String prenom, String email, String mdp, int tel, String role) {
			super();
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.mdp = mdp;
			this.tel = tel;
			this.role = role;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMdp() {
			return mdp;
		}
		public void setMdp(String mdp) {
			this.mdp = mdp;
		}
		public int getTel() {
			return tel;
		}
		public void setTel(int tel) {
			this.tel = tel;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		
	}
