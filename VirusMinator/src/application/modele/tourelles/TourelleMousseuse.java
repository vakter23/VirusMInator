package application.modele.tourelles;

import application.modele.Environnement;

public class TourelleMousseuse extends Tourelles { // == TourelleAvastiVirus

	
	// cette tourelle ralentit les ennemis mais inflige peu/pas de dégâts

	public TourelleMousseuse(double atq, int portee, double atqSpeed, String nom, int x, int y,Environnement env) {
		super(portee, atqSpeed,  nom, x, y,env);
	}
	

	@Override
	public void amelioration() {


		this.setAtq(this.getAtq()*1.2);
		this.setPortee(this.getPortee()+5);
		this.setAtqSpeed(this.getAtqSpeed()+1);		
	}


	@Override
	public void tirer() {


		 // Tourelles qui slow (Mousseuse/AvastiVirus)
		
		/*double newVitesse = (VirusAPorteeDeTir().getVitesse()-this.getSlow());
		VirusAPorteeDeTir().setVitesse(newVitesse);*/
		
		VirusAPorteeDeTir().slowVirus();
		
	}

}
