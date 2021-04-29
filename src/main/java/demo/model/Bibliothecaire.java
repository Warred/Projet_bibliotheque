package demo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="BIBLIOTHECAIRE")
public class Bibliothecaire extends Utilisateur {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2055638775345286934L;
	
}
