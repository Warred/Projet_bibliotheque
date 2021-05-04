package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import demo.service.IEmprunteur;

@CrossOrigin
@RestController
public class EmprunteurController {

	@Autowired
	IEmprunteur emprunteurService;
	
	
}
