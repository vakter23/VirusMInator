package application.modele.virus;

import java.util.ArrayList;

import application.modele.Environnement;
import application.modele.tourelles.Tourelles;

public class VirusViboomrus extends Virus {

	public VirusViboomrus(int x, int y, int tps, Environnement env) {
		super(120, 10, 1, "VirusViboomrus", x, y, tps, env);
	}

	@Override
	protected void appliquerEffets() {
		if (!estVivant() && this.getX() != 288 && this.getY() != 1104) {
			try {
				String idTourellesProche = this.env.getTourelles().get(0).getId();
				for (int i = 0; i < this.env.getTourelles().size(); i++) {
					/** On cherche la tourelle la plus proche de nous */
					if (this.env.getTourelles().get(i).getX() < this.env.getTourelle(idTourellesProche).getX()
							&& this.env.getTourelles().get(i).getY() < this.env.getTourelle(idTourellesProche).getY()
							&& this.env.getTourelles().get(i).getX() <= this.getX()
							&& this.env.getTourelles().get(i).getY() <= this.getY()
							|| this.env.getTourelles().get(i).getX() >= this.getX()
									&& this.env.getTourelles().get(i).getY() >= this.getY()) {
						/**
						 * Si la tourelle est plus proche de nous que la précédente, on change l'id de
						 * "idTourellesProche" en celui ci
						 */
						idTourellesProche = this.env.getTourelles().get(i).getId();
					}
				}
				System.out.println("atqSpeed avant " + this.env.getTourelle(idTourellesProche).getAtqSpeed());
				this.env.getTourelle(idTourellesProche)
						.setAtqSpeed(this.env.getTourelle(idTourellesProche).getAtqSpeed() * 2);
				/**
				 * La tourelle la plus proche voit sa vitesse d'attaque divisée par 2, car
				 * multiplier la vitesse d'attaque divise la vitesse d'attaque dans la réalité
				 */
				System.out.println("L'attaque speed est sensée être réduite");
				System.out.println(this.env.getTourelle(idTourellesProche).getAtqSpeed());
			} catch (Exception e) {
				/** On attrape le cas ou il n'y a pas de tourelles et on affiche ce message */
				System.out.println("Il n'y a pas de tourelles, le Virus n'applique pas son effet !");
			}

		}
	}

}
