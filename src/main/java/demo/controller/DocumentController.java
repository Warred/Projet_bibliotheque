package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Document;
import demo.service.IDocument;

@RestController
@CrossOrigin
public class DocumentController {
	
	@Autowired
	IDocument documentService;
	
	@PostMapping("/ajoutDocument")
	public Document addDocument(@RequestBody Document editeur) {
		return documentService.ajouter(editeur);	
	}
	
	@GetMapping("/listeDocuments")
	public List<Document> getDocuments() {
		return documentService.listeDocuments();
	}

}
