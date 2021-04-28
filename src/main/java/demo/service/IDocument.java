package demo.service;

import java.util.List;

import demo.model.Document;

public interface IDocument {

	Document ajouter(Document editeur);

	List<Document> listeDocuments();

}
