package demo.service;

import java.util.List;

import demo.model.Editeur;

public interface IEditeur {

	Editeur ajouter(Editeur editeur);

	List<Editeur> listeEditeurs();

}
