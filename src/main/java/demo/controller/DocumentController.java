package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Document;
import demo.service.IDisque;
import demo.service.IDocument;
import demo.service.IPapier;

@CrossOrigin
@RestController
public class DocumentController {
	
	@Autowired
	IDocument documentService;
	
	@Autowired
	IPapier papierService;
	
	@Autowired
	IDisque disqueService;
	
	@PostMapping("/ajoutDocument")
	public Integer addDocument(@RequestBody Document document,
			@RequestParam String typeDoc,
			@RequestParam(required = false) String typeDePublication,
			@RequestParam(required = false) String nombrePage,
			@RequestParam(required = false) String typeDisque,
			@RequestParam(required = false) String dureeMinutes
			) {
		if (typeDoc != null) {
			if (typeDoc.equals("papier")) {
				return papierService.ajouter(document, typeDePublication, nombrePage);			
			} else if (typeDoc.equals("disque")) {
				return disqueService.ajouter(document, typeDisque, dureeMinutes);
			}
		}
		return documentService.ajouter(document, typeDoc);
	}
	
	@GetMapping("/listeDocuments")
	public List<Document> getDocuments() {
		return documentService.listeDocuments();
	}

}
