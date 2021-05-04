package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Auteur;
import demo.service.IAuteur;

@CrossOrigin
@RestController
public class AuteurController {
	
	@Autowired
	IAuteur auteurService;
	
	@PostMapping("/ajoutAuteur")
	public Auteur addAuteur(@RequestBody Auteur auteur) {
		return auteurService.ajouter(auteur);	
	}
	
	@GetMapping("/listeAuteurs")
	public List<Auteur> getAuteurs() {
		return auteurService.listeAuteurs();
	}

}