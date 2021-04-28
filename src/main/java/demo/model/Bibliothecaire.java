package demo.model;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue(value="BIBLIO")
public class Bibliothecaire extends Utilisateur {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2055638775345286934L;
	
}
