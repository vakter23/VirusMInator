package application.modele.tourelles;

import application.modele.Environnement;

public class TourellesAvecDegats extends Tourelles {

	private int attaque;
	
	public TourellesAvecDegats(int attaque,int portee, double atqSpeed, String nom, int x, int y, Environnement env) {
		super(portee, atqSpeed, nom, x, y, env);

		this.attaque=attaque;
	
	}

	@Override
	public void amelioration() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tirer() {
		// TODO Auto-generated method stub
		
	}

	
	

}
