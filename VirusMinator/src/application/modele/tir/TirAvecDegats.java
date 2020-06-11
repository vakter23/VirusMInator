package application.modele.tir;

import application.modele.Environnement;
import application.modele.virus.Virus;
import javafx.beans.property.IntegerProperty;

public class TirAvecDegats extends Tir {

	private double atq;
	private Virus v;

	public TirAvecDegats(int x, int y, Virus v, Environnement env, double atq, int portee) {
		super(x, y, env, portee);
		this.v = v;
		this.atq = atq;
	}

	/**
	 * @return the atq
	 */
	public double getAtq() {
		return atq;
	}

	/**
	 * @param atq the atq to set
	 */
	public void setAtq(double atq) {
		this.atq = atq;
	}

	public void seDeplace() {
		/* verifPortee(); */

		if (v.getX() < this.getX()) {
			this.setX((int) (this.getX() - this.getVitesse()));
		} else {
			this.setX((int) (this.getX() + this.getVitesse()));
		}
		if (v.getY() < this.getY()) {
			this.setY((int) (this.getY() - this.getVitesse()));
		} else {
			this.setY((int) (this.getY() + this.getVitesse()));
		}

		if (this.getX() <= v.getX() && this.getY() <= v.getY()) {
			this.appliquerDégats();
			this.meurt();
			System.out.println("Ce tir meurt : " + this);
			v.getVie();
		}

	}

	public void verifPortee() {
		/*
		 * gérer les cas X>;Y<, check X>;Y>, check X<;Y>, check X<;Y<, check X>;Y<
		 */
		if (v.getX() < this.getBaseX() - getPortee()) {
			if (v.getY() < this.getBaseY() - getPortee()) {
				this.meurt();
			} else if (v.getY() > this.getBaseY() + getPortee()) {
				this.meurt();
			}
		} else if (v.getX() > this.getBaseX() + getPortee()) {
			if (v.getY() < this.getBaseY() - getPortee()) {
				this.meurt();
			} else if (v.getY() > this.getBaseY() + getPortee()) {
				this.meurt();
			}
		}

	}

	public void appliquerDégats() {
		double newVie = this.v.getVie() - this.getAtq();
		this.v.setVie(newVie);
		System.out.println("La vie du virus est maintenant de : " + newVie);
	}

//	
//	
//	double distanceX = (v.getX() - this.getX());
//	double distanceY = (v.getY() - this.getY());
//	int nposX = this.getX() + ((int) distanceX/4);
//	int nposY = this.getY() + ((int) distanceY/4);
//    this.setX(nposX);
//    this.setY(nposY);
//    
//}
	public String toString() {
		return ("Le tir : " + this.getId() + " à la position x = " + this.getX() + " et y = " + this.getY()
				+ " d'une origine de base X = " + this.getBaseX() + " et baseY : " + this.getBaseY()
				+ " et vise le Virus : " + this.v);
	}

}
