package application.modele.tourelles;

import application.modele.Environnement;
import application.modele.tir.Tir;
import application.modele.tir.TirAvecDegats;
import application.modele.virus.Virus;

public class TourelleSilliteBang extends TourellesAvecDegats {

	

	// Tourelle ayant une grande portee de Tir
	
	
	public TourelleSilliteBang(int x, int y, Environnement env) {
		super(250, 2000, "TourelleSilliteBang", x, y, env);		
		this.setAtq(1000);

	}


	@Override
	public void amelioration() {
    	if(this.niveau < 3) {

		this.setAtq(this.getAtq() * 1.2);
		this.setPortee(this.getPortee() + 5);
		this.setAtqSpeed(this.getAtqSpeed() - 10);
		niveau++;
    	}
	}

	@Override
	public void tirer() {

		Virus v = VirusAPorteeDeTir();
		Tir t1 = new TirAvecDegats(this.getX(), this.getY(), v, this.env,this.getAtq(), this.getPortee());
		this.env.ajouterListeTirs(t1);
		
			}


	

}
