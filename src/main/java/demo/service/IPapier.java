package demo.service;

import demo.model.Document;

public interface IPapier {

	Integer ajouter(Document document, String typeDePublication, String nombrePage);

}
