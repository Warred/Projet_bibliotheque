package demo.service;


import java.util.List;

import demo.model.Utilisateur;

public interface IUtilisateur {

	Utilisateur inscrire(Utilisateur utilisateur);
	
	boolean verifierExist(String pseudo, String password);	
	Utilisateur getUtilisateur(String pseudo, String password);
	
	boolean isEmprunteur(Utilisateur utilisateur);
	boolean isBibliothecaire(Utilisateur utilisateur);
	//COMMENTAIRE GRATUIT JUSTE COMME EXERCICE
	// deuxieme modif

	List<Utilisateur> listUtilisateurs();
}
