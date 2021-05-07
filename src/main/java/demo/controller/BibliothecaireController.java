package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Bibliothecaire;
import demo.model.Document;
import demo.service.IBibliothecaire;

@CrossOrigin
@RestController
public class BibliothecaireController {
	
	@Autowired
	IBibliothecaire bibliothecaireService;
	
	@GetMapping("/listeBibliothecaires")
	public List<Bibliothecaire> getBibliothecaires() {
		return bibliothecaireService.listeBibliothecaires();
	}
	
	@GetMapping("/bibliothecaireByUsername/{username}")
	public Bibliothecaire getBibliothecaireByUsername( @PathVariable("username") String username) {
		return bibliothecaireService.findByUsername(username);
	}
	
	@GetMapping("documentsParUsernameBibliothecaire/{username}")
	public List<Document> getDocByUsername(@PathVariable("username") String username) {
		Bibliothecaire bibliothecaire = bibliothecaireService.findByUsername(username);
		return bibliothecaire.getDocuments();
	}

}
