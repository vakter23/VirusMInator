package application.modele.tourelles;

import application.modele.Environnement;
import application.modele.tir.Tir;
import application.modele.tir.TirAvecDegats;
import application.modele.virus.Virus;

public class TourelleSavonneuse extends TourellesAvecDegats {

	// cette tourelle (tourelle de base) ne possÚde aucune specificitÚ

	public TourelleSavonneuse(int x, int y, Environnement env) {
		super(75, 50, "TourelleSavonneuse", x, y, env);
		this.setAtq(25);

	}

	@Override
	public void amelioration() {
    	if(this.niveau < 3) {

		this.setAtq(this.getAtq() * 1.2);
		this.setPortee(this.getPortee() + 5);
		this.setAtqSpeed(this.getAtqSpeed() + 1);
		niveau++;
    	}
	}

	@Override
	public void tirer() {
		Virus v = VirusAPorteeDeTir();
		
		Tir t1 = new TirAvecDegats(this.getX(), this.getY(), v, this.env, this.getAtq(), this.getPortee());
		this.env.ajouterListeTirs(t1);
		
	}

	
}
