package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Document;
import demo.model.Emprunteur;
import demo.service.IDocument;
import demo.service.IEmprunteur;

@CrossOrigin
@RestController
public class EmprunteurController {

	@Autowired
	IEmprunteur emprunteurService;
	
	@Autowired
	IDocument documentService;
	
	@PutMapping("/emprunteDocument/{username}/{idDocument}")
	public Long emprunteDocument(@PathVariable("username") String username,
				@PathVariable("idDocument") Integer idDocument) {
		
		Emprunteur emprunteur = emprunteurService.findByUsername(username);
		Document document = documentService.findById(idDocument);
		emprunteur.addDocumentsEmpruntés(document);
		return emprunteurService.save(emprunteur);
	}
}
