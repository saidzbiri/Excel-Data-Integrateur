package com.excel.data.integrateur.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import java.util.Date;

import javax.persistence.Column;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long Id;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "nom")
	private String nom;

	@Column(name = "date")
	private Date date;

	@Column(name = "commentaire")
	private String commentaire;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long id, String prenom, String nom, Date date, String commentaire) {
		super();
		Id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.date = date;
		this.commentaire = commentaire;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

}
