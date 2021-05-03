package demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.Auteur;

public interface AuteurRepository extends JpaRepository<Auteur, Integer>{

	
}
