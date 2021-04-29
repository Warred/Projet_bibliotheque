package demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.EmprunteurRepository;
import demo.model.Emprunteur;
import demo.service.IEmprunteur;

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
