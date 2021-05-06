package demo.service;

import java.util.List;

import demo.model.Bibliothecaire;

public interface IBibliothecaire {

	List<Bibliothecaire> listeBibliothecaires();

	Bibliothecaire findByUsername(String username);

}
