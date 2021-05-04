package demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.Papier;

public interface PapierRepository extends JpaRepository<Papier, Integer> {

}
