package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.DocumentRepository;
import demo.model.Bibliothecaire;
import demo.model.Disque;
import demo.model.Emprunteur;
import demo.model.Livre;
import demo.model.Document;

@Service
public class DocumentService implements IDocument{

	@Autowired
	DocumentRepository documentDao;
	
	@Override
	public Document ajouter(Document document) {
		document = documentDao.save(document);
		return document;
	}

	public boolean isPapier(Document document) {
		boolean emprunteur = document instanceof Livre;
		return emprunteur;
	}

	public boolean isDisque(Document document) {
		boolean biblio = document instanceof Disque;
		return biblio;
	}

	@Override
	public List<Document> listeDocuments() {
		return documentDao.findAll();
	}

}
