package demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Auteur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nom;
	
	private String prenom;

	private String pays;
	
	
	@ManyToMany(mappedBy="listeAuteurs", fetch = FetchType.LAZY)
	@JsonIgnore
	private List <Document> listeDocuments = new ArrayList <Document> ();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public List<Document> getListeDocuments() {
		return listeDocuments;
	}

	public void setListeDocuments(List<Document> listeDocuments) {
		this.listeDocuments = listeDocuments;
	}

	public boolean addDocument(Document document) {
		document.addAuteur(this);
		return listeDocuments.add(document);
	}

	public boolean removeDocument(Document document) {
		document.removeAuteur(this);
		return listeDocuments.remove(document);
	}
	
}