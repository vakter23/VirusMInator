package application.modele.tourelles;

public class TourelleHydroClaque extends Tourelles{

	
	//cette tourelle dispose d’un petit champs de tir mais asperge les ennemis non-stop

	
	public TourelleHydroClaque(double atq, int portee, double atqSpeed, double slow, String nom, int x, int y) {
		super(atq, portee, atqSpeed, 0, nom, x, y);
	}

	

	
	public void amelioration() {
		
		this.setAtq(this.getAtq()*1.2);
		this.setPortee(this.getPortee()+5);
		this.setAtqSpeed(this.getAtqSpeed()+1);
		
	}
	
}
