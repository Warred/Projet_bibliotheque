package demo.dto;

public class UserSecurity {

    private String username;
    private String password;
    private String nom;
    private String prenom;

/////////////////////////////////////////////////////////////////

    public UserSecurity() {
    }

    public UserSecurity(String username, String password, String nom, String prenom) {
        this.username = username;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
		return "UserSecurity [username=" + username + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom
				+ "]";
	}

	
}
