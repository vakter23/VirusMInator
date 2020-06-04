package application.modele.tourelles;

import application.modele.Environnement;
import application.modele.tir.Tir;
import application.modele.tir.TirAvecDegats;
import application.modele.tir.TirSansDegats;
import application.modele.virus.Virus;
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
		Virus v = VirusAPorteeDeTir();
		double newVie = (v.getVie() - this.getAtq());
		v.setVie(newVie);
		Tir t1 = new TirAvecDegats(this.getX(),this.getY(),v);
		this.env.ajouterListeTirs(t1);
		//VirusAPorteeDeTir().setVie(VirusAPorteeDeTir().getVie()-this.getAtq());
		//code pour tirer / apelle de la méthode tir
		
		
	}
	
}
