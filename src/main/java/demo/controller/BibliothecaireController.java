package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Bibliothecaire;
import demo.model.Emprunteur;
import demo.model.Bibliothecaire;
import demo.service.IBibliothecaire;

@RestController
@CrossOrigin
public class BibliothecaireController {
	
	@Autowired
	IBibliothecaire bibliothecaireService;
	
	@PostMapping("/inscrireBibliothecaire")
	public Bibliothecaire addBibliothecaire(@RequestBody Bibliothecaire bibliothecaire) {
		return bibliothecaireService.inscrire(bibliothecaire);	
	}

}
