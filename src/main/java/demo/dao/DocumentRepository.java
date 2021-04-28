package demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer>{

	
}
