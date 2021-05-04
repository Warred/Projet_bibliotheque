package demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.PapierRepository;
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
		papier.setListeAuteurs(document.getListeAuteurs());
		
		papier.setTypeDePublication(typeDePublication);
		Integer nbPage = Integer.valueOf(nombrePage);
		papier.setNombrePage(nbPage);
		
		return papierDao.save(papier).getId();
	}
	
}
