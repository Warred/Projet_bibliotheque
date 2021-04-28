package demo.model;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type_Document")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 2)
	@NotEmpty(message = "Le champ nom est obligatoire!")
	private String nom;
	
	@Size(min = 1, max=400, message = "La description doit être entre 1 et 400 caractères!")
	@NotEmpty
	private String description;
	
	@NotNull(message = "La date d'ajout est obligatoire!")
	private Date dateAjout;
	
	@ManyToOne
	private Editeur lEditeur;

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
}
