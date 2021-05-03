package demo.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.AuteurRepository;
import demo.model.Auteur;
import demo.service.IAuteur;

@Service
public class AuteurService implements IAuteur{

	@Autowired
	AuteurRepository auteurDao;
	
	
	@Override
	public Auteur ajouter(Auteur auteur) {
		return auteurDao.save(auteur);
	}

	@Override
	public List<Auteur> listeAuteurs() {
		return auteurDao.findAll();
	}

}
