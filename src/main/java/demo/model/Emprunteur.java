package demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@DiscriminatorValue(value="EMPRUNTEUR")
public class Emprunteur extends Utilisateur {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4880204505908196017L;
	
	private Integer empruntMax=3;
	private Integer empruntEffectue=0;
	
	@OneToMany(mappedBy="emprunteur", cascade=CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Document> documentsEmprunts;
	
	public Integer getEmpruntMax() {
		return empruntMax;
	}
	
	public void setEmpruntMax(Integer empruntMax) {
		this.empruntMax = empruntMax;
	}
	
	public Integer getEmpruntEffectue() {
		return empruntEffectue;
	}
	
	public void setEmpruntEffectue(Integer empruntEffectue) {
		this.empruntEffectue = empruntEffectue;
	}

	public List<Document> getDocumentsEmprunts() {
		return documentsEmprunts;
	}

	public void setDocumentsEmpruntés(List<Document> documentsEmpruntés) {
		this.documentsEmprunts = documentsEmpruntés;
	}

	public boolean addDocumentsEmpruntés(Document document) {
		if (this.empruntEffectue < this.empruntMax && document.getEmprunteur() == null) {
			document.setEmprunteur(this);
			return documentsEmprunts.add(document);
		} else return false;		
	}

	public boolean removeDocumentsEmpruntés(Document document) {
		document.setEmprunteur(null);
		return documentsEmprunts.remove(document);
	}	

}
