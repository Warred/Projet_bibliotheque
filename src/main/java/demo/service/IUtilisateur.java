package demo.service;

import demo.model.Utilisateur;

public interface IUtilisateur {

	Utilisateur inscrire(Utilisateur utilisateur);
	
	boolean verifierExist(String pseudo, String password);	
	Utilisateur getUtilisateur(String pseudo, String password);
	
	boolean isEmprunteur(Utilisateur utilisateur);
	boolean isBibliothecaire(Utilisateur utilisateur);
	
}
