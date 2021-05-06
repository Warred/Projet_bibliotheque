package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Bibliothecaire;
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
	public Bibliothecaire getBibliothecaireById( @PathVariable("username") String username) {
		return bibliothecaireService.findByUsername(username);
	}

}
