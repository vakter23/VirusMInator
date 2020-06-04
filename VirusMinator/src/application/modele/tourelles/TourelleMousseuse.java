package application.modele.tourelles;

import application.modele.Environnement;
import application.modele.tir.TirSansDegats;
public class TourelleMousseuse extends Tourelles { // == TourelleAvastiVirus

	// cette tourelle ralentit les ennemis mais inflige peu/pas de dégâts
	
	private double slow;
	

	public TourelleMousseuse( int portee, double atqSpeed, String nom, int x, int y,Environnement env) {
		super(portee, atqSpeed,  nom, x, y,env);
		
		this.slow=1.2;
	}
	
	public void setSlow(double slow) {
	this.slow = slow;
	}
	

	@Override
	public void amelioration() {


		this.setSlow(slow+2);
		this.setPortee(this.getPortee()+5);
		this.setAtqSpeed(this.getAtqSpeed()+1);		
	}


	@Override
	public void tirer() {


		 // Tourelles qui slow (Mousseuse/AvastiVirus)
		
		/*double newVitesse = (VirusAPorteeDeTir().getVitesse()-this.getSlow());
		VirusAPorteeDeTir().setVitesse(newVitesse);*/
		
		VirusAPorteeDeTir().slowVirus(this.slow);
	}

}
