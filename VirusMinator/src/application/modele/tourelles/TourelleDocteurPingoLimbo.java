package application.modele.tourelles;

public class TourelleDocteurPingoLimbo extends Tourelles{

	
	
	// si il est placé proche de 2 tourelle les tourelles adjacentes prennent une amélioration de vitesse d’attaque

	public TourelleDocteurPingoLimbo(double atq, int portee, double atqSpeed, double slow, String nom, int x, int y) {
		super(0, portee, 0, 0, nom, x, y);
	}

	

	@Override
	public void amelioration() {


		this.setAtq(this.getAtq()*1.2);
		this.setPortee(this.getPortee()+5);
		this.setAtqSpeed(this.getAtqSpeed()+1);		
	}

}
