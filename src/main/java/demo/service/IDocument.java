package demo.service;

import java.util.List;

import demo.model.Document;

public interface IDocument {

	Integer ajouter(Document editeur, String typeDoc);
	
	List<Document> listeDocuments();

	Document findById(Integer id);

}
