package demo.service.implement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import demo.dao.UtilisateurRepository;
import demo.dto.UserSecurity;
import demo.dto.UtilisateurDTO;
import demo.model.Authority;
import demo.model.Bibliothecaire;
import demo.model.Emprunteur;
import demo.model.Utilisateur;
import demo.security.AuthorityConstant;
import demo.service.IUtilisateur;

@Service
public class UtilisateurService implements IUtilisateur{

	@Autowired
	UtilisateurRepository utilisateurDao;

	// password encode permet d'encoder le mot de passe avant de l'enregistrer en BDD
    // Pour fonctionner, PasswordEncoder est défini dans SecurityConfig (dans le package Security)
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public UtilisateurDTO findUserByUsername(String username) {
        Utilisateur user = utilisateurDao.findByUsername(username);
        return user != null ? new UtilisateurDTO(user) : null;
    }

	@Override
    public Long registerUser(UserSecurity user) {
        Utilisateur userToCreate = new Utilisateur();
        userToCreate.setUsername(user.getUsername());
        userToCreate.setPassword(passwordEncoder.encode(user.getPassword()));
        userToCreate.setNom(user.getNom());
        userToCreate.setPrenom(user.getPrenom());
        Set<Authority> authorities = new HashSet<>();
        Authority authority = new Authority(AuthorityConstant.ROLE_USER);
        authorities.add(authority);
        userToCreate.setAuthorities(authorities);
        return utilisateurDao.save(userToCreate).getId();
    }
	
	@Override
	public boolean isEmprunteur(Utilisateur utilisateur) {
		boolean emprunteur = utilisateur instanceof Emprunteur;
		return emprunteur;
	}

	@Override
	public boolean isBibliothecaire(Utilisateur utilisateur) {
		boolean biblio = utilisateur instanceof Bibliothecaire;
		return biblio;
	}

	@Override
	public List<Utilisateur> listUtilisateurs() {
		return utilisateurDao.findAll();
	}
	
}
