package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.EmprunteurRepository;
import demo.model.Emprunteur;

@Service
public class EmprunteurService implements IEmprunteur {
	
	@Autowired
	EmprunteurRepository emprunteurDao;

	@Override
	public Emprunteur inscrire(Emprunteur emprunteur) {
		emprunteur = emprunteurDao.save(emprunteur);
		return emprunteur;
	}

}
