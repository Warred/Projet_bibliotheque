package demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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
	
	@OneToMany(mappedBy="emprunteur", cascade=CascadeType.REFRESH)
	@JsonIdentityInfo(
			  generator = ObjectIdGenerators.PropertyGenerator.class , 
			  property = "id")
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
			this.empruntEffectue++;
			return documentsEmprunts.add(document);
		} else return false;		
	}

	public boolean removeDocumentsEmpruntés(Document document) {
		document.setEmprunteur(null);
		this.empruntEffectue--;
		return documentsEmprunts.remove(document);
	}	

}
