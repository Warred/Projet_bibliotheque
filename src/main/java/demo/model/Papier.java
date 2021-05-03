package demo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="LIVRE")
public class Papier extends Document{
	
	private Integer nombrePage;

	private String typeDePublication; //livre, magazine, journal, flyer, autre

	public Integer getNombrePage() {
		return nombrePage;
	}

	public void setNombrePage(Integer nombrePage) {
		this.nombrePage = nombrePage;
	}

	public String getTypeDePublication() {
		return typeDePublication;
	}

	public void setTypeDePublication(String typeDePublication) {
		this.typeDePublication = typeDePublication;
	}	

}
