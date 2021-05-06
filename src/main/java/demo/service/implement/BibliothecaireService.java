package demo.service.implement;

import java.util.List;

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
	public List<Bibliothecaire> listeBibliothecaires() {
		return bibliothecaireDao.findAll();
	}

	@Override
	public Bibliothecaire findByUsername(String username) {
		return bibliothecaireDao.findByUsername(username);
	}

}
