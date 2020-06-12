package application.modele.tourelles;

import application.modele.virus.Virus;
import java.util.ArrayList;
import application.modele.Environnement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Tourelles {

	private IntegerProperty x = new SimpleIntegerProperty(); // Position en X
	private IntegerProperty y = new SimpleIntegerProperty(); //Postion en Y

	// private int x,y;
	private int portee;
	private double atqSpeed; 
	private String nom, ID;
	protected Environnement env;
	private boolean buff = false;//Variable indiquant si la tourelle a deja recu un buff
	
	private static int compteur = 1; //Variable pour attribuer des ID Croissant aux tourelles

	public int niveau; //Variable servant a limiter le nombre d'amélioration des tourelles

	public Tourelles(int portee, double atqSpeed, String nom, int x, int y, Environnement env) { /* Constructeur tourelles */
		this.setPortee(portee);
		this.setAtqSpeed(atqSpeed);
		this.nom = nom;
		this.ID = "t" + compteur;
		this.setX(x);
		this.setY(y);
		this.env = env;
		this.niveau = 1;
		
		compteur++;
	}

	public abstract void amelioration(); 

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

	public void gestionTir() { // Methode qui gere le missile et réduit les pv ou ralentis du virus quand le missile le
								// touche

	}

	public Virus VirusAPorteeDeTir() { 


		for (int i = 0; i < env.getViruses().size(); i++) {
			
			if (env.getViruses().get(i).estVivant()) {
				if ((this.getY() - this.portee <= env.getViruses().get(i).getY()
						&& env.getViruses().get(i).getY() <= this.getY() + this.portee)   //Verification si on trouve un Virus dnas la zone de chaque tourelle ,
						&& (this.getX() - this.portee <= env.getViruses().get(i).getX()  //en additionnant ou en soustrayant la portee de la tourelle a sa position en X ou a sa position en Y	 
								&& env.getViruses().get(i).getX() <= this.getX() + this.portee)) {
					return env.getViruses().get(i);
				}
			}
		}
		return null;

	}

	public ArrayList<Tourelles> TourelleAPorteeDeTir() { // Utilise pour la tourelle Pingolimbo qui boost la vitesse d'attaque des
												// tourelles dans un certain rayon et pour le Virus Viboomrus qui ralentit la vitesse 
		ArrayList<Tourelles> listeTourelle = new ArrayList<Tourelles>();		//d'attaque de la tourelle la plus proche de son lieu de decés
		for (int i = 0; i < env.getTourelles().size(); i++) {
			// System.out.println(env.getTourelles());
			// if (env.getTourelles().get(i).estVivant()) { (Pas besoin de check ca
			// normalement
			if ((this.getY() - this.portee <= env.getTourelles().get(i).getY()
					&& env.getTourelles().get(i).getY() <= this.getY() + this.portee)  //Meme facon de faire que pour VirusAPorteeDeTir
					&& (this.getX() - this.portee <= env.getTourelles().get(i).getX()
							&& env.getTourelles().get(i).getX() <= this.getX() + this.portee)) {
					listeTourelle.add(env.getTourelles().get(i));
			}
			
		
		}
		return listeTourelle;

	}

	public ArrayList<Virus> PlusieursVirusAPorteeDeTir() {	// return tout les virus a portee de tir pour les tourelles qui tir sur plusieurs Virus
		
		ArrayList<Virus> virusesMultiples = new ArrayList<Virus>();
		for (int i = 0; i < env.getViruses().size(); i++) {

			if (env.getViruses().get(i).estVivant()) {
				if ((this.getY() - this.portee <= env.getViruses().get(i).getY()
						&& env.getViruses().get(i).getY() <= this.getY() + this.portee)  //Meme facon de faire que pour VirusAPorteeDeTir
						&& (this.getX() - this.portee <= env.getViruses().get(i).getX()
								&& env.getViruses().get(i).getX() <= this.getX() + this.portee)) {
					Virus virus = env.getViruses().get(i);
					virusesMultiples.add(virus);
					
				}
			}
		}
		return virusesMultiples;

	}

	public void boostAttaqueSpeed(double boost) {
		if(!this.buff) {
		this.setAtqSpeed(this.atqSpeed * boost);
		}
	}

	public abstract void tirer();

	public void agit() {

		if (this.env.getTemps() % this.atqSpeed == 0 && this.VirusAPorteeDeTir() != null) // tentative d'evittement du null pointer
																			
		{
			tirer();			
			 
		}

		
	}

	@Override
	public String toString() {
		return "Tourelles [x=" + x + ", y=" + y + ", portee=" + portee + ", atqSpeed=" + atqSpeed + ", nom=" + nom
				+ ", ID=" + ID + "]";
	}

	

	
	public int getNiveau() {
		return niveau;
	}

	
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public void setBuff(boolean b) {
		this.buff = true;
		
	}

}
