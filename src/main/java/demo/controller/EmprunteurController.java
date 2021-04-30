package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import demo.service.IEmprunteur;

@RestController
@CrossOrigin
public class EmprunteurController {

	@Autowired
	IEmprunteur emprunteurService;
	
	
}
