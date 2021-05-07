package demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Editeur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nom;
	
	private Date dateCreation;
	
	private Date dateDisparition;

	private String pays;
	
	@OneToMany (cascade={CascadeType.PERSIST}, mappedBy = "lEditeur", fetch = FetchType.EAGER)
	@JsonManagedReference(value="doc_editeur")
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

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateDisparition() {
		return dateDisparition;
	}

	public void setDateDisparition(Date dateDisparition) {
		this.dateDisparition = dateDisparition;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public List<Document> getListeDocuments() {
		return listeDocuments;
	}

	public void setListeDocuments(List<Document> listeDocuments) {
		this.listeDocuments = listeDocuments;
	}

	public boolean addDocument(Document document) {
		document.setlEditeur(this);
		return listeDocuments.add(document);
	}

	public boolean removeDocument(Document document) {
		document.setlEditeur(null);
		return listeDocuments.remove(document);
	}
	
}