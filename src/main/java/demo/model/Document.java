package demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type_Document")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	
	private String description;
	
	private Date dateAjout;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Editeur lEditeur;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Bibliothecaire bibliothecaire;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
            name = "auteurs_documents",
            joinColumns = { @JoinColumn(name="document_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "auteur_id", referencedColumnName = "id") }
    )
	private List <Auteur> listeAuteurs = new ArrayList <Auteur> ();
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Emprunteur emprunteur;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public Editeur getlEditeur() {
		return lEditeur;
	}

	public void setlEditeur(Editeur lEditeur) {
		this.lEditeur = lEditeur;
	}

	public Bibliothecaire getBibliothecaire() {
		return bibliothecaire;
	}

	public void setBibliothecaire(Bibliothecaire bibliothecaire) {
		this.bibliothecaire = bibliothecaire;
	}

	public List<Auteur> getListeAuteurs() {
		return listeAuteurs;
	}

	public void setListeAuteurs(List<Auteur> listeAuteurs) {
		this.listeAuteurs = listeAuteurs;
	}

	public boolean addAuteur(Auteur auteur) {
		auteur.addDocument(this);
		return listeAuteurs.add(auteur);
	}

	public boolean removeAuteur(Auteur auteur) {
		auteur.removeDocument(this);
		return listeAuteurs.remove(auteur);
	}

	public Emprunteur getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Emprunteur emprunteur) {
		this.emprunteur = emprunteur;
	}	
	
}
