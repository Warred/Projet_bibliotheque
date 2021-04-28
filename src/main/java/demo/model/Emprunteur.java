package demo.model;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue(value="EMPRUNTEUR")
public class Emprunteur extends Utilisateur {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4880204505908196017L;
	
	private Integer empruntMax=3;
	private Integer empruntEffectue=0;
	
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
	
	

}
