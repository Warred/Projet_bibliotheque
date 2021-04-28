package demo.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type_Utilisateur")
public class Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -46830939473067630L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size (min=2, max=12, message="Le pseudo doit comprendre entre 2 et 12 caractéres")
	@NotEmpty(message="Le champ pseudo est obligatoire.")
	private String pseudo;
	
	@NotEmpty(message="Le champ mot de passe est obligatoire.")
	private String password;
	
	@Size (min=2, max=20, message="Le nom doit comprendre entre 2 et 20 caractéres")
	@NotEmpty(message="Le champ nom est obligatoire.")
	private String nom;
	
	@Size (min=2, max=20, message="Le prénom doit comprendre entre 2 et 20 caractéres")
	@NotEmpty(message="Le champ prénom est obligatoire.")
	private String prenom;

	public Utilisateur() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", pseudo=" + pseudo + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + "]";
	}
	
}
