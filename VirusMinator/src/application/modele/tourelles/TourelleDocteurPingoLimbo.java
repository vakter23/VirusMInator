package application.modele.tourelles;

import java.util.ArrayList;
import application.modele.Environnement;
import application.modele.tir.Tir;
import application.modele.tir.TirSansDegats;

public class TourelleDocteurPingoLimbo extends Tourelles {
	private double boostAtqSpeed;

	public TourelleDocteurPingoLimbo(int x, int y, Environnement env) {
		super(500, 1, "TourelleDocteurPingoLimbo", x, y, env);

		this.boostAtqSpeed = 0.8; /*l'attaque speed doit diminuer pour que la tourelle
		frappe plus vite*/
	}

	public void setBoostatqSpeed(double boostAtqSpeed2) {
		this.boostAtqSpeed = boostAtqSpeed2;
	}

	@Override
	public void amelioration() {
		
		this.setBoostatqSpeed(boostAtqSpeed - 0.1);
		this.setPortee(this.getPortee() + 5);
		
	}

	@Override
	public void tirer() {
		ArrayList<Tourelles> liste = TourelleAPorteeDeTir();
		for (int i = 0; i < liste.size(); i++) {
			System.out.println("Les tourelles buffées : " + liste);
			//Tir t1 = new TirSansDegats(this.getXProperty(), this.getYProperty(), this.env, this.getPortee());
			//this.env.ajouterListeTirs(t1);
			if (TourelleAPorteeDeTir().get(i).getAtqSpeed() != 1) {
			TourelleAPorteeDeTir().get(i).boostAttaqueSpeed(boostAtqSpeed);
			TourelleAPorteeDeTir().get(i).setBuff(true);
			}
		}

	}

	
}
