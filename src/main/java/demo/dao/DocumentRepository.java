package demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer>{

	List<Document> findByEmprunteurIsNull();

	List<Document> findByEmprunteurIsNotNull();

	List<Document> findAllByOrderByIdAsc();

	
}
