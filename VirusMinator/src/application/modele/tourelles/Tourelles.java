package application.modele.tourelles;

import application.modele.virus.Virus;
import application.modele.virus.VirusBasirus;
import application.modele.Environnement;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Tourelles {

	private IntegerProperty x = new SimpleIntegerProperty();
	private IntegerProperty y = new SimpleIntegerProperty();

	// private int x,y;
	private int portee;
	private double atqSpeed, atq, slow;
	private String nom, ID;
	protected Environnement env;
	private int temps;//Variable pour gerer temps entre le tir des tourelles (1 unité de temps = 1 tour) <- variable crée dans environnement

	public Tourelles(double atq, int portee, double atqSpeed, double slow, String nom, int x,
			int y) { /* Constructeur tourelles */

		this.setAtq(atq);
		this.setPortee(portee);
		this.setAtqSpeed(atqSpeed);
		this.setSlow(slow);
		this.nom = nom;
		this.setX(x);
		this.setY(y);

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

	public double getAtq() {
		return atq;
	}

	public void setAtq(double atq2) {
		this.atq = atq2;
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

	public double getSlow() {
		return slow;
	}

	public void setSlow(double slow) {
		this.slow = slow;
	}

	public void Tir() {// Methode qui fait que la tourelle tir

		if (VirusAPorteeDeTir() != null) {
			
			Tourelles t = new TourelleHydroClaque(10, 10, 10, 0, nom, 9, 9);
			
			Virus v = new VirusBasirus(10, 10, 10, nom, 9, 9);
			
			env.ajouterVirus(v);
			
			
			t.VirusAPorteeDeTir();
			
			System.out.println(t.VirusAPorteeDeTir());
			
			System.out.println(VirusAPorteeDeTir().getVie());


		}

	}
	
	/*public static void main(String[] args) {
		
			Environnement e1 = new Environnement(500, 500);
		
			Tourelles t = new TourelleHydroClaque(10, 10, 10, 0, "nom", 9, 9);
			
			Virus v = new VirusBasirus(10, 10, 10, "noom", 9, 9);
			
			e1.ajouterVirus(v);
			
			
			t.VirusAPorteeDeTir();
			
			System.out.println(t.VirusAPorteeDeTir());
			
			
			for (int i = 0; i < e1.getViruses().size(); i++) {
				if (e1.getViruses().get(i).estVivant()) {
					if ((t.getY() - t.portee <= e1.getViruses().get(i).getY()
							&& e1.getViruses().get(i).getY() <= t.getY() + t.portee)
							&& (t.getX() - t.portee <= e1.getViruses().get(i).getX()
									&& e1.getViruses().get(i).getX() <= t.getX() + t.portee)) {
						e1.getViruses().get(i);
					}
				}
			}
			
			System.out.println(t.VirusAPorteeDeTir());

			
			
			//System.out.println(VirusAPorteeDeTir().getVie());


		}*/
	
	
	public void gestionTir() { //Methode qui gere le missile et réduit les pv du virus quand le missile le touche
		
		
	}

	public Virus VirusAPorteeDeTir() {

		for (int i = 0; i < env.getViruses().size(); i++) {
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
	
	public void agit() {
		
		if (temps % this.atqSpeed ==0)
		{
			
			//code pour tirer / apelle de la méthode tir
		}
	}

	public boolean placementTourelles() {

		return false;

	}

}
