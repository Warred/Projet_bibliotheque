package demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@DiscriminatorValue(value="BIBLIOTHECAIRE")
public class Bibliothecaire extends Utilisateur {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2055638775345286934L;
	
	@OneToMany(mappedBy="bibliothecaire", cascade=CascadeType.PERSIST)
	@JsonIgnore
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

	public boolean removeDocument(Document document) {
		document.setBibliothecaire(null);
		return documents.remove(document);
	}
	
	
}
