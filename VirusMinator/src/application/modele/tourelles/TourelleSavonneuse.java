package application.modele.tourelles;

import application.modele.Environnement;
import application.modele.tir.Tir;
import application.modele.tir.TirAvecDegats;
import application.modele.virus.Virus;

public class TourelleSavonneuse extends TourellesAvecDegats {

	// cette tourelle (tourelle de base) inflige dégât basique

	public TourelleSavonneuse(int portee, double atqSpeed, String nom, int x, int y, Environnement env) {
		super(portee, atqSpeed, nom, x, y, env);

		this.setAtq(20);

	}

	@Override
	public void amelioration() {

		this.setAtq(this.getAtq() * 1.2);
		this.setPortee(this.getPortee() + 5);
		this.setAtqSpeed(this.getAtqSpeed() + 1);

	}

	@Override
	public void tirer() {
		Virus v = VirusAPorteeDeTir();
		System.out.println("avant tirer cette tourelle vise " + v);
		System.out.println(v.getVie());
		Tir t1 = new TirAvecDegats(this.getXProperty(), this.getYProperty(), v, this.env, this.getAtq());
		this.env.ajouterListeTirs(t1);
		System.out.println(env.getListeTirs());

		// VirusAPorteeDeTir().setVie(VirusAPorteeDeTir().getVie()-this.getAtq());
		// code pour tirer / apelle de la méthode tir

	}

	
}
