package application.modele.tourelles;

import application.modele.Environnement;

public class TourelleSavonneuse extends TourellesAvecDegats {
	

	// cette tourelle (tourelle de base) inflige dégât basique
	private int niveau =1;

	
	public TourelleSavonneuse(int portee, double atqSpeed, String nom, int x, int y, Environnement env) {
		super(portee, atqSpeed, nom, x, y, env);
		
		this.setAtq(18);

	}
	


public void amelioration() {

		
		if(this.niveau<3) {
		
		this.setAtq(this.getAtq() * 1.2);
		this.setPortee(this.getPortee() + 5);
		this.setAtqSpeed(this.getAtqSpeed() + 1);

		this.niveau++;
		}
	}

	@Override
	public void tirer() {


		double newVie = (VirusAPorteeDeTir().getVie() - this.getAtq());
		VirusAPorteeDeTir().setVie(newVie);
		//VirusAPorteeDeTir().setVie(VirusAPorteeDeTir().getVie()-this.getAtq());
		//code pour tirer / apelle de la méthode tir
		
	}

}
