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
	public Emprunteur findByUsername(String username) {
		return emprunteurDao.findByUsername(username);
	}

	@Override
	public Long save(Emprunteur emprunteur) {		
		return emprunteurDao.save(emprunteur).getId();
	}

}
