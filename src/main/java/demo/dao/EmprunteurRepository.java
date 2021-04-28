package demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.Emprunteur;

public interface EmprunteurRepository extends JpaRepository<Emprunteur, Integer> {

}
