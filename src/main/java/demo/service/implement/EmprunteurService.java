package demo.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.EmprunteurRepository;
import demo.dto.EmprunteurDTO;
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

	@Override
	public List<Emprunteur> findAll() {
		return emprunteurDao.findAll();
	}

	@Override
	public EmprunteurDTO findByID(Long id) {
		return emprunteurDao.findById(id);
	}

}
