package demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.BibliothecaireRepository;
import demo.model.Bibliothecaire;
import demo.service.IBibliothecaire;

@Service
public class BibliothecaireService implements IBibliothecaire {
	
	@Autowired
	BibliothecaireRepository bibliothecaireDao;

	@Override
	public Bibliothecaire inscrire(Bibliothecaire bibliothecaire) {
		bibliothecaire = bibliothecaireDao.save(bibliothecaire);
		return bibliothecaire;
	}

}
