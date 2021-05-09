package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.controller.exception.UsernameAlreadyExistException;
import demo.dto.EmprunteurDTO;
import demo.dto.UserSecurity;
import demo.dto.UtilisateurDTO;
import demo.model.Utilisateur;
import demo.security.JwtUtils;
import demo.service.IEmprunteur;
import demo.service.IUtilisateur;

@CrossOrigin
@RestController
public class UtilisateurController {
	
	@Autowired
	IUtilisateur utilisateurService;
	
	@Autowired
	IEmprunteur emprunteurService;
	
	
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
	
	@GetMapping("/account")
    public ResponseEntity<Object> getAccount(){
        String username = JwtUtils.getCurrentUserLogin().orElse("");
        UtilisateurDTO user = utilisateurService.findUserByUsername(username);
        if (user.getAuthorities().contains("ROLE_EMPRUNTEUR")) {
        	EmprunteurDTO userEmprunteur = emprunteurService.findByID(user.getId());
        	return ResponseEntity.ok(userEmprunteur);
        }
        return ResponseEntity.ok(user);
    }
	
	@GetMapping("/listeUtilisateurs")
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurService.listUtilisateurs();
	}
	
	@PutMapping("/modifierUtilisateur")
	public void modifierUtilisateur(@RequestBody Utilisateur form) {
		String username = JwtUtils.getCurrentUserLogin().orElse("");
        UtilisateurDTO userDTO = utilisateurService.findUserByUsername(username);
        Utilisateur utilisateur = utilisateurService.findUserByDTO(userDTO);
		utilisateur.setNom(form.getNom());
		utilisateur.setPrenom(form.getPrenom());
		utilisateurService.save(utilisateur);
	}

}
