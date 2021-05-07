package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Document;
import demo.model.Editeur;
import demo.service.IEditeur;

@CrossOrigin
@RestController
public class EditeurController {
	
	@Autowired
	IEditeur editeurService;
	
	@PostMapping("/ajoutEditeur")
	public Editeur addEditeur(@RequestBody Editeur editeur) {
		return editeurService.ajouter(editeur);	
	}
	
	@GetMapping("/listeEditeurs")
	public List<Editeur> getEditeurs() {
		return editeurService.listeEditeurs();
	}
	
	@GetMapping("documentsParIdEditeur/{id}")
	public List<Document> docByEditeur(@PathVariable("id") Integer id) {
		Editeur editeur = editeurService.findById(id);
		return editeur.getListeDocuments();
	}

}
