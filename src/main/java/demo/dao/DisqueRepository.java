package demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.Disque;

public interface DisqueRepository extends JpaRepository<Disque, Integer> {

}
