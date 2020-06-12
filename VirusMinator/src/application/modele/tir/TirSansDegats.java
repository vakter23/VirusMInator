package application.modele.tir;

import java.util.ArrayList;

import application.modele.Environnement;
import application.modele.virus.Virus;
import javafx.beans.property.IntegerProperty;

public class TirSansDegats extends Tir {
private Virus v;
	public TirSansDegats(int x, int y, Environnement env, int portee, Virus v) {
		super(x, y, env, portee);
		this.v = v;
	}


	@Override
	public void seDeplace() {

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
			this.appliquerSlow(v);
			
	if (this.v.estVivant() &&( v.getX()> this.getBaseX()+this.getPortee() 
	|| v.getY()>this.getBaseY()+this.getPortee())) {
		this.meurt();
		System.out.println("Le tir est hors de portée");
		this.enleverSlow(v);
	}
		
	}
	private void enleverSlow(Virus virusVise) {
		virusVise.setVitesse(virusVise.getVitesse()*2);
	}
	private void appliquerSlow(Virus virusVise) {
		virusVise.setVitesse(virusVise.getVitesse()/2);

	}
}