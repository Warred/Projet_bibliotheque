package demo.service;

import demo.model.Emprunteur;

public interface IEmprunteur {

	Emprunteur findByUsername(String username);

	Long save(Emprunteur emprunteur);

}
