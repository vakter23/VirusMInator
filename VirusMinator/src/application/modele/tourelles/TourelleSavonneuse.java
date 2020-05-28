package application.modele.tourelles;

import application.modele.Environnement;

public class TourelleSavonneuse extends Tourelles {

	// cette tourelle (tourelle de base) inflige dégât basique

	public TourelleSavonneuse(double atq, int portee, double atqSpeed, double slow, String nom, int x, int y,Environnement e1) {
		super(atq, portee, atqSpeed, 0, nom, x, y, e1);
	}

	@Override
	public void amelioration() {

		this.setAtq(this.getAtq() * 1.2);
		this.setPortee(this.getPortee() + 5);
		this.setAtqSpeed(this.getAtqSpeed() + 1);

	}

}
