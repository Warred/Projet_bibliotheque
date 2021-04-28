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
import demo.model.Utilisateur;
import demo.service.IUtilisateur;

@RestController
@CrossOrigin
public class UtilisateurController {
	
	@Autowired
	IUtilisateur utilisateurService;
	
	@PostMapping("/inscrireEmprunteur")
	public Utilisateur addUtilisateur(@RequestBody Emprunteur emprunteur) {
		return utilisateurService.inscrire(emprunteur);	
	}
	
	@PostMapping("/inscrireBibliothecaire")
	public Utilisateur addUtilisateur(@RequestBody Bibliothecaire bibliothecaire) {
		return utilisateurService.inscrire(bibliothecaire);	
	}
	
	@GetMapping("/listUtilisateurs")
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurService.listUtilisateurs();
	}

}
