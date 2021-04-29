package demo.dto;

import java.util.Set;
import java.util.stream.Collectors;

import demo.model.Authority;
import demo.model.Utilisateur;


public class UtilisateurDTO {

	private Long id;
    private String username;
    private String nom;
    private String prenom;
    private Set<String> authorities;

    public UtilisateurDTO() {
    }

    public UtilisateurDTO(Utilisateur utilisateur) {
        this.id = utilisateur.getId();
        this.username = utilisateur.getUsername();
        this.nom = utilisateur.getNom();
        this.prenom = utilisateur.getPrenom();
        this.authorities = utilisateur.getAuthorities()
                               .stream()
                               .map(Authority::getAuthority)
                               .collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

	public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}
