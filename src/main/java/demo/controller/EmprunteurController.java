package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Document;
import demo.model.Emprunteur;
import demo.service.IDocument;
import demo.service.IEmprunteur;

@CrossOrigin
@RestController
public class EmprunteurController {

	@Autowired
	IEmprunteur emprunteurService;
	
	@Autowired
	IDocument documentService;
	
	@GetMapping("/listeEmprunteurs")
	public List<Emprunteur> listeEmprunteurs() {
		List<Emprunteur> list = emprunteurService.findAll();
		for (Emprunteur emp : list) {
			System.out.println(emp.getNom() + " : " + emp.getDocumentsEmprunts().size());
		}
		return list;
	}
	
	@PutMapping("/emprunteDocument/{username}/{idDocument}")
	public Long emprunteDocument(@PathVariable("username") String username,
				@PathVariable("idDocument") Integer idDocument) {		
		Emprunteur emprunteur = emprunteurService.findByUsername(username);
		Document document = documentService.findById(idDocument);
		if (emprunteur.addDocumentsEmpruntés(document)) {
			emprunteur.setEmpruntEffectue(emprunteur.getEmpruntEffectue()+1);
			return emprunteurService.save(emprunteur);
		} else return (long) -1;
	}
	
	@PutMapping("/rendreDocument/{username}/{idDocument}")
	public Long rendreDocument(@PathVariable("username") String username,
				@PathVariable("idDocument") Integer idDocument) {		
		Emprunteur emprunteur = emprunteurService.findByUsername(username);
		Document document = documentService.findById(idDocument);
		if (emprunteur.removeDocumentsEmpruntés(document)) {
			emprunteur.setEmpruntEffectue(emprunteur.getEmpruntEffectue()-1);
			return emprunteurService.save(emprunteur);
		} else return (long) -1;
	}
	
}
