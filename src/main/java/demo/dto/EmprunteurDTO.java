package demo.dto;

import java.util.Set;
import java.util.stream.Collectors;

import demo.model.Authority;
import demo.model.Emprunteur;

public class EmprunteurDTO {
	private Long id;
    private String username;
    private String nom;
    private String prenom;
    private Integer empruntMax;
	private Integer empruntEffectue;
    private Set<String> authorities;

    public EmprunteurDTO() {
    }

    public EmprunteurDTO(Emprunteur emprunteur) {
        this.id = emprunteur.getId();
        this.username = emprunteur.getUsername();
        this.nom = emprunteur.getNom();
        this.prenom = emprunteur.getPrenom();
        this.empruntEffectue = emprunteur.getEmpruntEffectue();
        this.empruntMax = emprunteur.getEmpruntMax();
        this.authorities = emprunteur.getAuthorities()
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

	public Integer getEmpruntMax() {
		return empruntMax;
	}

	public void setEmpruntMax(Integer empruntMax) {
		this.empruntMax = empruntMax;
	}

	public Integer getEmpruntEffectue() {
		return empruntEffectue;
	}

	public void setEmpruntEffectue(Integer empruntEffectue) {
		this.empruntEffectue = empruntEffectue;
	}

	public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}
