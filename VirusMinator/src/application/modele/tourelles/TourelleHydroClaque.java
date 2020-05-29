package application.modele.tourelles;

import application.modele.Environnement;

public class TourelleHydroClaque extends TourellesAvecDegats{

	

	//cette tourelle dispose d’un petit champs de tir mais asperge les ennemis non-stop

	
	
	public TourelleHydroClaque(int portee, double atqSpeed, String nom, int x, int y, Environnement env) {
		super(portee, atqSpeed, nom, x, y, env);
		
		this.setAtq(18);
	}



	
	public void amelioration() {
		
		this.setAtq(this.getAtq()*1.2);
		this.setPortee(this.getPortee()+5);
		this.setAtqSpeed(this.getAtqSpeed()+1);
		
	}




	@Override
	public void tirer() {
		
		double newVie = (VirusAPorteeDeTir().getVie() - this.getAtq());
		VirusAPorteeDeTir().setVie(newVie);
		//VirusAPorteeDeTir().setVie(VirusAPorteeDeTir().getVie()-this.getAtq());
		//code pour tirer / apelle de la méthode tir
		
		
	}
	
}
