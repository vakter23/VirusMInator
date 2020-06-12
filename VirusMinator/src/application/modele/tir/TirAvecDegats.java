package application.modele.tir;

import application.modele.Environnement;
import application.modele.virus.Virus;
public class TirAvecDegats extends Tir {

	private double atq;
	private Virus v; //Cible du Tir

	public TirAvecDegats(int x, int y, Virus v, Environnement env, double atq, int portee) {
		super(x, y, env, portee);
		this.v = v;
		this.atq = atq;
	}

	
	public double getAtq() {
		return atq;
	}

	
	public void setAtq(double atq) {
		this.atq = atq;
	}

	public void seDeplace() {
		

		if (v.getX() < this.getX()) {
			this.setX((int) (this.getX() - this.getVitesse()));
		} else {
			this.setX((int) (this.getX() + this.getVitesse()));
		}
		if (v.getY() < this.getY()) {
			this.setY((int) (this.getY() - this.getVitesse()));	//Déplacement du Tir Vers le virus ciblé
		} else {
			this.setY((int) (this.getY() + this.getVitesse()));
		}

		if (this.getX() <= v.getX() && this.getY() <= v.getY()) {
			this.appliquerDégats();
			this.meurt();
			System.out.println("Ce tir meurt : " + this);
			v.getVie();
		}
		if (!this.v.estVivant()) {
			this.meurt();
		}

		if (!this.v.estVivant()
				|| (v.getX() > this.getBaseX() + this.getPortee() 
				||  v.getY() > this.getBaseY() + this.getPortee())) {
			this.meurt();
		}

	}

	public void appliquerDégats() {
		double newVie = this.v.getVie() - this.getAtq();
		this.v.setVie(newVie);
		System.out.println("La vie du virus est maintenant de : " + newVie);
	}


	public String toString() {
		return ("Le tir : " + this.getId() + " à la position x = " + this.getX() + " et y = " + this.getY()
				+ " d'une origine de base X = " + this.getBaseX() + " et baseY : " + this.getBaseY()
				+ " et vise le Virus : " + this.v);
	}

}
