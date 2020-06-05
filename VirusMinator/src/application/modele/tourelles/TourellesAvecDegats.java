package application.modele.tourelles;

import application.modele.Environnement;
import application.modele.tir.TirAvecDegats;

public abstract class TourellesAvecDegats extends Tourelles {
	private double attaque;

	public TourellesAvecDegats(int portee, double atqSpeed, String nom, int x, int y, Environnement env) {
		super(portee, atqSpeed, nom, x, y, env);
	}

	
	
	
	public double getAtq() {
		return attaque;
	}

	public void setAtq(double atq2) {
		this.attaque = atq2;
	
	
	}
}
