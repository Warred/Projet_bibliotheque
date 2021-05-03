package demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@DiscriminatorValue(value="BIBLIOTHECAIRE")
public class Bibliothecaire extends Utilisateur {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2055638775345286934L;
	
	@OneToMany(mappedBy="bibliothecaire", cascade=CascadeType.PERSIST)
	@JsonManagedReference
	private List<Document> documents = new ArrayList<Document>();

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public boolean addDocument(Document document) {
		document.setBibliothecaire(this);
		return documents.add(document);
	}

	public boolean remove(Document document) {
		document.setBibliothecaire(null);
		return documents.remove(document);
	}
	
	
}
