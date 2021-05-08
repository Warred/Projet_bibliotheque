package demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.dto.EmprunteurDTO;
import demo.model.Emprunteur;

public interface EmprunteurRepository extends JpaRepository<Emprunteur, Integer> {

	Emprunteur findByUsername(String username);

	EmprunteurDTO findById(Long id);

}
