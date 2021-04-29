package demo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue(value="LIVRE")
public class Livre extends Document{
	
	@NotNull(message = "Le nombre de page est obligatoire!")
	private Integer nombrePage;
	
	@Size (min=1, message = "La taille du support est forcement d'au moins une page!")
	@NotEmpty (message = "Le type de support est obligatoire!")
	private String typeDePublication; //livre, magazine, journal, flyer, autre

	public Integer getNombrePage() {
		return nombrePage;
	}

	public void setNombrePage(Integer nombrePage) {
		this.nombrePage = nombrePage;
	}
	
	

}
