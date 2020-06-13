package application.modele.tourelles;

import java.util.ArrayList;
import application.modele.Environnement;
public class TourelleDocteurPingoLimbo extends Tourelles {

	private double boostAtqSpeed; //Variable indiquant la quantité d'augmentation de 
				     //l'attaque des tourelles a proximité

	//Cette Tourelle augmente la vitesse d'attaque des Tourelles a sa porté

	public TourelleDocteurPingoLimbo(int x, int y, Environnement env) {
		super(500, 1, "TourelleDocteurPingoLimbo", x, y, env);

		this.boostAtqSpeed = 0.8; 
		/*l'attaque speed doit diminuer pour que la tourelle frappe plus vite*/
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
		ArrayList<Tourelles> liste = tourelleAPorteeDeTir();
		for (int i = 0; i < liste.size(); i++) {
			if (tourelleAPorteeDeTir().get(i).getAtqSpeed() != 1) { //La vitesse d'attaque ne peut descendre en dessous de 1
			tourelleAPorteeDeTir().get(i).boostAttaqueSpeed(boostAtqSpeed);
			tourelleAPorteeDeTir().get(i).setBuff(true); //Boolean verifiant si la tourelle a deja recu un buff pour ne pas les cumuelrs a l'infinie
			}
		}

	}

	
}
