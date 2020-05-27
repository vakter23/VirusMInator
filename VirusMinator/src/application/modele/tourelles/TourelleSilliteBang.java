package application.modele.tourelles;

import application.modele.Environnement;

public class TourelleSilliteBang extends Tourelles {

	// puissante tourelle qui balance des rockets de super loin mais prend du temps
	// à recharger. (tours qui tirent à un endroit désigné à la souris)

	public TourelleSilliteBang(double atq, int portee, double atqSpeed, double slow, String nom, int x, int y,Environnement env) {
		super(atq, portee, atqSpeed, 0, nom, x, y,env);
	}

	@Override
	public void amelioration() {

		this.setAtq(this.getAtq() * 1.2);
		this.setPortee(this.getPortee() + 5);
		this.setAtqSpeed(this.getAtqSpeed() + 1);

	}

}
