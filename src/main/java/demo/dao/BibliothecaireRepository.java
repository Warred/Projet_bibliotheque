package demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.Bibliothecaire;

public interface BibliothecaireRepository extends JpaRepository<Bibliothecaire, Integer> {

	Bibliothecaire findByUsername(String username);
}
