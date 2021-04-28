package demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.Editeur;

public interface EditeurRepository extends JpaRepository<Editeur, Integer>{

	
}
