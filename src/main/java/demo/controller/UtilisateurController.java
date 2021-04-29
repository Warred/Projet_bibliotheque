package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.controller.exception.UsernameAlreadyExistException;
import demo.dto.UserSecurity;
import demo.dto.UtilisateurDTO;
import demo.model.Utilisateur;
import demo.service.IUtilisateur;


@RestController
public class UtilisateurController {
	
	@Autowired
	IUtilisateur utilisateurService;
	
	@CrossOrigin
	@PostMapping("/inscrireUtilisateur")
    public ResponseEntity<Long> register(@RequestBody UserSecurity user,
    		@RequestParam String role
    		){
		System.out.println(role);
        UtilisateurDTO userDTO = utilisateurService.findUserByUsername(user.getUsername());
        if(userDTO != null) throw new UsernameAlreadyExistException();
        Long idCreated = utilisateurService.registerUser(user, role);
        return ResponseEntity.ok(idCreated);
    }
	
	
	@GetMapping("/listeUtilisateurs")
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurService.listUtilisateurs();
	}

}
