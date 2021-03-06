package demo.service;


import java.util.List;

import demo.dto.UserSecurity;
import demo.dto.UtilisateurDTO;
import demo.model.Utilisateur;

public interface IUtilisateur {
	
	
	UtilisateurDTO findUserByUsername(String username); // spring security
	Long registerUser(UserSecurity user, String role); // spring security

	List<Utilisateur> listUtilisateurs();
	
	void save(Utilisateur utilisateur);
	Utilisateur findUserByDTO(UtilisateurDTO userDTO);
}
