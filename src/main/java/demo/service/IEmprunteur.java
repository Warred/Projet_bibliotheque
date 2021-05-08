package demo.service;

import java.util.List;

import demo.dto.EmprunteurDTO;
import demo.model.Emprunteur;

public interface IEmprunteur {

	Emprunteur findByUsername(String username);

	Long save(Emprunteur emprunteur);

	List<Emprunteur> findAll();

	EmprunteurDTO findByID(Long id);

}
