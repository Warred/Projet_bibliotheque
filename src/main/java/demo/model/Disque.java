package demo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="DISQUE")
public class Disque extends Document{
	
	private Integer dureeMinutes;
	
	private String typeDisque;//CD OU DVD???? LASERDISK LOL!!

	public Integer getDureeMinutes() {
		return dureeMinutes;
	}

	public void setDureeMinutes(Integer dureeMinutes) {
		this.dureeMinutes = dureeMinutes;
	}

	public String getTypeDisque() {
		return typeDisque;
	}

	public void setTypeDisque(String typeDisque) {
		this.typeDisque = typeDisque;
	}
	
	
	

}
