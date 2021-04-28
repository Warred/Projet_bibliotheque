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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Editeur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 2)
	@NotEmpty(message = "le champ nom est obligatoire")
	private String nom;
	
	
	@NotNull(message = "le champ dateCreation est obligatoire")
	private Date dateCreation;
	
	private Date dateDisparition;
	
	@Size(min = 2)
	@NotEmpty(message = "le champ pays est obligatoire")
	private String pays;
	
	@OneToMany (cascade={CascadeType.PERSIST},  fetch = FetchType.LAZY, mappedBy = "lEditeur")
	@JsonIgnoreProperties("lEditeur")
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
}