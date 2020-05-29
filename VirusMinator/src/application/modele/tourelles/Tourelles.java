package application.modele.tourelles;

import application.modele.virus.Virus;
import application.modele.virus.VirusBasirus;
import application.modele.Environnement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Tourelles {

	private IntegerProperty x = new SimpleIntegerProperty();
	private IntegerProperty y = new SimpleIntegerProperty();

	// private int x,y;
	private int portee;
	private double atqSpeed; //atq, slow
	private String nom, ID;
	protected Environnement env;
	private int temps;//Variable pour gerer temps entre le tir des tourelles (1 unité de temps = 1 tour) <- variable crée dans environnement

	
	public Tourelles( int portee, double atqSpeed,  String nom, int x,
			int y ,Environnement env) { /* Constructeur tourelles */

		this.setPortee(portee);
		this.setAtqSpeed(atqSpeed);
		this.nom = nom;
		this.setX(x);
		this.setY(y);
		this.env=env;

	}

	public abstract void amelioration(); // Ou coder argent necessaire a amelioration

	public String getNom() {

		return nom;

	}

	public String getId() {

		return ID;

	}

	public final int getX() {
		return x.getValue();
	}

	public final IntegerProperty getXProperty() {
		return x;
	}

	public final int getY() {
		return y.getValue();
	}

	public final IntegerProperty getYProperty() {
		return y;
	}

	public final void setX(int n) {
		x.setValue(n);
	}

	public final void setY(int n) {
		y.setValue(n);
	}

	

	public int getPortee() {
		return portee;
	}

	public void setPortee(int portee) {
		this.portee = portee;
	}

	public double getAtqSpeed() {
		return atqSpeed;
	}

	public void setAtqSpeed(double atqSpeed) {
		this.atqSpeed = atqSpeed;
	}

	

	

	
	
	public static void main(String[] args) {
		
			Environnement e1 = new Environnement(500, 500);
		
			
			Tourelles t = new TourelleHydroClaque(10, 10, "nom", 9, 9, e1);
			
			Virus v = new VirusBasirus(11, 10, 10, "noom", 9, 9);
			
			System.out.println(v.getVie());
	
				e1.ajouterVirus(v);
			
			
			System.out.println("ou");
			System.out.println(v.getVie());
			
			
			
			//double newVie = (t.VirusAPorteeDeTir().getVie() - t.getAtq());
			//t.VirusAPorteeDeTir().setVie(newVie);
			
			System.out.println("where");
			System.out.println(v.getVie());

			
			/*for (int i = 0; i < e1.getViruses().size(); i++) {
				if (e1.getViruses().get(i).estVivant()) {
					if ((t.getY() - t.portee <= e1.getViruses().get(i).getY()
							&& e1.getViruses().get(i).getY() <= t.getY() + t.portee)
							&& (t.getX() - t.portee <= e1.getViruses().get(i).getX()
									&& e1.getViruses().get(i).getX() <= t.getX() + t.portee)) {
						e1.getViruses().get(i);
					}
				}
			}*/
			

			
			
			//System.out.println(VirusAPorteeDeTir().getVie());


		}
	
	
	public void gestionTir() { //Methode qui gere le missile et réduit les pv du virus quand le missile le touche
		
		
	}

	public Virus VirusAPorteeDeTir() {

		//System.out.println("env" + this.env);
		
		for (int i = 0; i < env.getViruses().size(); i++) {
			//System.out.println(env.getViruses());
			if (env.getViruses().get(i).estVivant()) {
				if ((this.getY() - this.portee <= env.getViruses().get(i).getY()
						&& env.getViruses().get(i).getY() <= this.getY() + this.portee)
						&& (this.getX() - this.portee <= env.getViruses().get(i).getX()
								&& env.getViruses().get(i).getX() <= this.getX() + this.portee)) {
					return env.getViruses().get(i);
				}
			}
		}
		return null;

	}
	
	
	public Tourelles TourelleAPorteeDeTir() { //Utilise pour la tourelle Pingolimbo qui boost la vitesse d'attaque des tourelles dans un certain rayon

		
		
		for (int i = 0; i < env.getTourelles().size(); i++) {
			//System.out.println(env.getTourelles());
			//if (env.getTourelles().get(i).estVivant()) { (Pas besoin de check ca normalement
				if ((this.getY() - this.portee <= env.getTourelles().get(i).getY()
						&& env.getTourelles().get(i).getY() <= this.getY() + this.portee)
						&& (this.getX() - this.portee <= env.getTourelles().get(i).getX()
								&& env.getTourelles().get(i).getX() <= this.getX() + this.portee)) {
					return env.getTourelles().get(i);
				}
			//}
		}
		return null;

	}
	
	
	
	public void boostAttaqueSpeed(double boost) {
		
		this.setAtqSpeed(this.atqSpeed*boost);
		
	}
	
	public abstract void tirer();
		
		
	
	
	public void agit() {
		
		if (temps % this.atqSpeed == 0  && this.VirusAPorteeDeTir() != null) // tentative d'evittement du null pointer exception ( car virusaporteedetir retourne null si pas de virus
		{
			
			tirer();
			
		}
			
		/*	if(this.atq>0) {	

			double newVie = (VirusAPorteeDeTir().getVie() - this.getAtq());
			VirusAPorteeDeTir().setVie(newVie);
			//VirusAPorteeDeTir().setVie(VirusAPorteeDeTir().getVie()-this.getAtq());
			//code pour tirer / apelle de la méthode tir
			}
	
	
			else if (slow>0) { // Tourelles qui slow (Mousseuse/AvastiVirus)
		
				//double newVitesse = (VirusAPorteeDeTir().getVitesse()-this.getSlow());
				//VirusAPorteeDeTir().setVitesse(newVitesse);
				
				VirusAPorteeDeTir().slowVirus();
	
			}
			
			else {//TOurelle PingoLimbo
				
				TourelleAPorteeDeTir().boostAttaqueSpeed();
				
			}
		}*/
	}

	public boolean placementTourelles() {

		return false;

	}

}
