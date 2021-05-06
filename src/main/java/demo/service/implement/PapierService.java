package demo.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.AuteurRepository;
import demo.dao.PapierRepository;
import demo.model.Auteur;
import demo.model.Document;
import demo.model.Papier;
import demo.service.IPapier;

@Service
public class PapierService implements IPapier {

	@Autowired
	PapierRepository papierDao;

	@Override
	public Integer ajouter(Document document, String typeDePublication, String nombrePage) {
		Papier papier = new Papier();
		
		papier.setlEditeur(document.getlEditeur());
		papier.setBibliothecaire(document.getBibliothecaire());
		papier.setDateAjout(document.getDateAjout());
		papier.setDescription(document.getDescription());
		papier.setNom(document.getNom());
		
		papier.setTypeDePublication(typeDePublication);
		Integer nbPage = Integer.valueOf(nombrePage);
		papier.setNombrePage(nbPage);
		
		Integer idFinal = papierDao.save(papier).getId();
		papier.setListeAuteurs(document.getListeAuteurs());
		papierDao.flush();
		return idFinal;
	}
	
}
