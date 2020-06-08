package application.modele.virus;

import java.util.ArrayList;

import application.modele.Environnement;
import application.modele.tourelles.Tourelles;

public class VirusViboomrus extends Virus {

	public VirusViboomrus(int vie, int atq, double vitesse, String nom, int x, int y, int tps, Environnement env) {
		super(vie, atq, vitesse, nom, x, y, tps, env);
	}

	@Override
	protected void appliquerEffets() {
		if(!estVivant()) {
			String idTourellesProche = "t0"; 
			for(int i = 0; i<this.env.getTourelles().size(); i++) {
				/*On cherche la tourelle la plus proche de nous */
				if (this.env.getTourelles().get(i).getX() < this.env.getTourelles(idTourellesProche).getX() && 
					this.env.getTourelles().get(i).getY() < this.env.getTourelles(idTourellesProche).getY() &&
					this.env.getTourelles().get(i).getX() <= this.getX() &&
					this.env.getTourelles().get(i).getY() <= this.getY() ||
					this.env.getTourelles().get(i).getX() >= this.getX() &&
					this.env.getTourelles().get(i).getY() >= this.getY()) {
					idTourellesProche = this.env.getTourelles().get(i).getId();
				}
			}
			this.env.getTourelles(idTourellesProche).setAtqSpeed(this.env.getTourelles(idTourellesProche).getAtqSpeed()/1.5);
		}
	}

	
}
