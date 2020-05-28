package application.modele.tourelles;

import application.modele.Environnement;

public class TourelleSilliteBang extends TourellesAvecDegats {

	// puissante tourelle qui balance des rockets de super loin mais prend du temps
	// à recharger. (tours qui tirent à un endroit désigné à la souris)
	
	
	
	public TourelleSilliteBang(int attaque, int portee, double atqSpeed, String nom, int x, int y, Environnement env) {
		super(attaque, portee, atqSpeed, nom, x, y, env);
	}



	@Override
	public void amelioration() {

		this.setAtq(this.getAtq() * 1.2);
		this.setPortee(this.getPortee() + 5);
		this.setAtqSpeed(this.getAtqSpeed() + 1);

	}

	@Override
	public void tirer() {

		double newVie = (VirusAPorteeDeTir().getVie() - this.getAtq());
		VirusAPorteeDeTir().setVie(newVie);
		//VirusAPorteeDeTir().setVie(VirusAPorteeDeTir().getVie()-this.getAtq());
		//code pour tirer / apelle de la méthode tir
		
	}

}
