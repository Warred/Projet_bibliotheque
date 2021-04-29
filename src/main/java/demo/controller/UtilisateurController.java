package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.controller.exception.UsernameAlreadyExistException;
import demo.dto.UserSecurity;
import demo.dto.UtilisateurDTO;
import demo.model.Utilisateur;
import demo.service.IUtilisateur;


@RestController
@CrossOrigin
public class UtilisateurController {
	
	@Autowired
	IUtilisateur utilisateurService;
	
	@PostMapping("/insrireUtilisateur")
    public ResponseEntity<Long> register(@RequestBody UserSecurity user){
        UtilisateurDTO userDTO = utilisateurService.findUserByUsername(user.getUsername());
        if(userDTO != null) throw new UsernameAlreadyExistException();
        Long idCreated = utilisateurService.registerUser(user);
        return ResponseEntity.ok(idCreated);
    }
	
	
	@GetMapping("/listeUtilisateurs")
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurService.listUtilisateurs();
	}

}
