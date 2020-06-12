package application.modele.virus;

import java.util.ArrayList;

import application.modele.Environnement;
import application.modele.tourelles.Tourelles;

public class VirusViboomrus extends Virus {

	public VirusViboomrus(int x, int y, int tps, Environnement env) {
		super(120, 10, 1.0, "VirusViboomrus", x, y, tps, env);
	}

	@Override
	protected void appliquerEffets() {
		if(!estVivant() && this.getX()!= 288 && this.getY() != 1104) {
			try {
			String idTourellesProche = this.env.getTourelles().get(1).getId(); 
			for(int i = 0; i<this.env.getTourelles().size(); i++) {
				/*On cherche la tourelle la plus proche de nous */
				System.out.println("L'attaque speed est sensée être réduite");
				if (this.env.getTourelles().get(i).getX() < this.env.getTourelle(idTourellesProche).getX() && 
					this.env.getTourelles().get(i).getY() < this.env.getTourelle(idTourellesProche).getY() &&
					this.env.getTourelles().get(i).getX() <= this.getX() &&
					this.env.getTourelles().get(i).getY() <= this.getY() ||
					this.env.getTourelles().get(i).getX() >= this.getX() &&
					this.env.getTourelles().get(i).getY() >= this.getY()) {
					idTourellesProche = this.env.getTourelles().get(i).getId();
				}
			}
			this.env.getTourelle(idTourellesProche).setAtqSpeed(this.env.getTourelle(idTourellesProche).getAtqSpeed()*1.5);
			System.out.println(this.env.getTourelle(idTourellesProche).getAtqSpeed());
		} catch (Exception e) {
			System.out.println("Il n'y a pas de tourelles, le Virus n'applique pas son effet !");
		}
			
			
		}
	}

	
}
