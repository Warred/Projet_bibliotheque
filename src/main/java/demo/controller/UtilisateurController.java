package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Utilisateur;
import demo.service.IUtilisateur;

@RestController
@CrossOrigin
public class UtilisateurController {
	
	@Autowired
	IUtilisateur utilisateurService;
	
	@PostMapping("/inscrireUtilisateur")
	public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.inscrire(utilisateur);	
	}
	
	@GetMapping("/listeUtilisateurs")
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurService.listUtilisateurs();
	}

}
