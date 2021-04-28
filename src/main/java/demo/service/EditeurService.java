package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.EditeurRepository;
import demo.model.Editeur;

@Service
public class EditeurService implements IEditeur{

	@Autowired
	EditeurRepository editeurDao;
	
	
	@Override
	public Editeur ajouter(Editeur editeur) {
		return editeurDao.save(editeur);
	}

	@Override
	public List<Editeur> listeEditeurs() {
		return editeurDao.findAll();
	}

}
