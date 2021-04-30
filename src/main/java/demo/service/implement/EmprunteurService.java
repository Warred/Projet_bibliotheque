package demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.EmprunteurRepository;
import demo.service.IEmprunteur;

@Service
public class EmprunteurService implements IEmprunteur {
	
	@Autowired
	EmprunteurRepository emprunteurDao;

}
