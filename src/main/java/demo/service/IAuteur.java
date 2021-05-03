package demo.service;

import java.util.List;

import demo.model.Auteur;

public interface IAuteur {

	Auteur ajouter(Auteur auteur);

	List<Auteur> listeAuteurs();

}

