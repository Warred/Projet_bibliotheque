package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.UtilisateurRepository;
import demo.model.Bibliothecaire;
import demo.model.Emprunteur;
import demo.model.Utilisateur;

@Service
public class UtilisateurService implements IUtilisateur{

	@Autowired
	UtilisateurRepository utilisateurDao;
	
	@Override
	public Utilisateur inscrire(Utilisateur utilisateur) {
		utilisateur = utilisateurDao.save(utilisateur);
		return utilisateur;
	}

	@Override
	public boolean verifierExist(String pseudo, String password) {
		return utilisateurDao.existsByPseudoAndPassword(pseudo, password);
	}

	@Override
	public Utilisateur getUtilisateur(String pseudo, String password) {
		return utilisateurDao.findByPseudoAndPassword(pseudo, password);
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
