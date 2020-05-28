package application.modele.tourelles;

import application.modele.Environnement;

public class TourelleDocteurPingoLimbo extends Tourelles{
	// si il est placé proche de 2 tourelle les tourelles adjacentes prennent une amélioration de vitesse d’attaque

	
	
	public TourelleDocteurPingoLimbo(int portee, double atqSpeed, String nom, int x, int y, Environnement env) {
		super(portee, atqSpeed, nom, x, y, env);
	}


	@Override
	public void amelioration() {


		this.setAtq(this.getAtq()*1.2);
		this.setPortee(this.getPortee()+5);
		this.setAtqSpeed(this.getAtqSpeed()+1);		
	}



	@Override
	public void tirer() {
			
		TourelleAPorteeDeTir().boostAttaqueSpeed();


}
}
