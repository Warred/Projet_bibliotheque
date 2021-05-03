package demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "utilisateur")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type_Utilisateur")
@DiscriminatorValue(value="UTILISATEUR")
public class Utilisateur implements UserDetails {	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2063470082902241712L;
	
	private static final String SEQ = "users_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
    @SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
    private Long id;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	private String nom;
	
	private String prenom;
	
	@JsonIgnore
    @Column(name = "password_hash", nullable = false)
	private String password;
	
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_authority",
            joinColumns = { @JoinColumn(name="users_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "authority_name", referencedColumnName = "name") }
    )
    private Set<Authority> authorities = new HashSet<>();

/////////////////////////////////////////////////////////////////


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
///////////////////////////////////////////////////////////////////////
	
	public Utilisateur() {}
	
	public Utilisateur(Long id, String username, String password, String nom, String prenom, Set<Authority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.authorities = authorities;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", username=" + username + ", nom=" + nom + ", prenom=" + prenom
				+ ", password=" + password + ", authorities=" + authorities + "]";
	}

	
	
}
