package application.modele.tourelles;

import application.modele.Environnement;

public abstract class TourellesAvecDegats extends Tourelles { //Classe qui regroupe toute les tourelles infligeant des dégats

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
