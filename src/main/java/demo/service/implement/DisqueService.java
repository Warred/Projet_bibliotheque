package demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.DisqueRepository;
import demo.model.Disque;
import demo.model.Document;
import demo.service.IDisque;

@Service
public class DisqueService implements IDisque {

	@Autowired
	DisqueRepository disqueDao;

	@Override
	public Integer ajouter(Document document, String typeDisque, String dureeMinutes) {
		Disque disque = new Disque();
		
		disque.setNom(document.getNom());
		disque.setDateAjout(document.getDateAjout());
		disque.setBibliothecaire(document.getBibliothecaire());
		disque.setDescription(document.getDescription());
		disque.setlEditeur(document.getlEditeur());
		disque.setListeAuteurs(document.getListeAuteurs());
		
		disque.setTypeDisque(typeDisque);
		Integer dureeMin = Integer.valueOf(dureeMinutes);
		disque.setDureeMinutes(dureeMin);
		return disqueDao.save(disque).getId();
	}
	
}
