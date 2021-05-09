package demo.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.DocumentRepository;
import demo.service.IDocument;
import demo.model.Document;

@Service
public class DocumentService implements IDocument{

	@Autowired
	DocumentRepository documentDao;
	
	@Override
	public Integer ajouter(Document document, String typeDoc) {
		return documentDao.save(document).getId();
	}

	@Override
	public List<Document> listeDocuments() {
		return documentDao.findAllByOrderByIdAsc();
	}

	@Override
	public Document findById(Integer id) {
		return documentDao.findById(id).orElse(null);
	}

	@Override
	public List<Document> listeDocumentsDispo() {
		return documentDao.findByEmprunteurIsNull();
	}

	@Override
	public List<Document> listeDocumentsEmpruntes() {
		return documentDao.findByEmprunteurIsNotNull();
	}

	@Override
	public void efface(Integer id) {
		documentDao.deleteById(id);
	}

}
