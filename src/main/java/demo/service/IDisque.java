package demo.service;

import demo.model.Document;

public interface IDisque {

	Integer ajouter(Document document, String typeDisque, String dureeMinutes);

}
