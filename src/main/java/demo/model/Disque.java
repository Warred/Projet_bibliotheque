package demo.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue(value="DISQUE")
public class Disque extends Document{
	
	@NotNull(message = "La durée en minutes est obligatoire!")
	private Integer dureeMinutes;
	
	@NotNull(message = "Le type de disque numérique est obligatoire!")
	private String typeDisque;//CD OU DVD???? LASERDISK LOL!!
	
	
	

}
