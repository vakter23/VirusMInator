package application.modele.tourelles;

import java.util.ArrayList;

import application.modele.Environnement;
import application.modele.tir.Tir;
import application.modele.tir.TirAvecDegats;
import application.modele.tir.TirSansDegats;
import application.modele.virus.Virus;

public class TourelleDocteurPingoLimbo extends Tourelles {
	private double boostAtqSpeed;

	private int niveau = 1;

	
	public TourelleDocteurPingoLimbo(int portee, double atqSpeed, String nom, int x, int y, Environnement env) {
		super(portee, atqSpeed, nom, x, y, env);

		this.boostAtqSpeed = 1.2;
	}

	public void setBoostatqSpeed(double boostAtqSpeed2) {
		this.boostAtqSpeed = boostAtqSpeed2;
	}

	@Override
	public void amelioration() {

		if(niveau<3) {
		
		this.setBoostatqSpeed(boostAtqSpeed + 2);
		this.setPortee(this.getPortee() + 5);
		this.setAtqSpeed(this.getAtqSpeed() + 1);
		
		niveau++;
		}
	}

	@Override
	public void tirer() {
		ArrayList<Tourelles> liste = TourelleAPorteeDeTir();
		for (int i = 0; i < liste.size(); i++) {
			Tir t1 = new TirSansDegats(this.getXProperty(), this.getYProperty(), this.env);
			this.env.ajouterListeTirs(t1);
			TourelleAPorteeDeTir().get(i).boostAttaqueSpeed(boostAtqSpeed);

		}

	}

}
