package application.modele.tourelles;

import java.util.ArrayList;

import application.modele.Environnement;
import application.modele.tir.Tir;
import application.modele.tir.TirAvecDegats;
import application.modele.tir.TirSansDegats;
import application.modele.virus.Virus;

public class TourelleHydroClaque extends TourellesAvecDegats {

	// cette tourelle dispose d’un petit champs de tir mais asperge les ennemis
	// non-stop

	private int niveau = 1;
	
	public TourelleHydroClaque(int portee, double atqSpeed, String nom, int x, int y, Environnement env) {
		super(portee, atqSpeed, nom, x, y, env);

		this.setAtq(18);
	}

	public void amelioration() {

		if(niveau<3) {
		
		this.setAtq(this.getAtq() * 1.2);
		this.setPortee(this.getPortee() + 5);
		this.setAtqSpeed(this.getAtqSpeed() + 1);

		niveau++;
		}
	}

	@Override
	public void tirer() {
		ArrayList<Virus> v = PlusieursVirusAPorteeDeTir();
		for (int i = 0; i < v.size(); i++) {
			Tir t1 = new TirAvecDegats(this.getXProperty(), this.getYProperty(), v.get(i), this.env);
			this.env.ajouterListeTirs(t1);
			double newVie = (v.get(i).getVie() - this.getAtq());
			v.get(i).setVie(newVie);
		}
		// VirusAPorteeDeTir().setVie(VirusAPorteeDeTir().getVie()-this.getAtq());
		// code pour tirer / apelle de la méthode tir

	}

}
