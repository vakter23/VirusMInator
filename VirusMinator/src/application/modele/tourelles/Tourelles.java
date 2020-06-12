package application.modele.tourelles;

import application.modele.virus.Virus;
import java.util.ArrayList;
import application.modele.Environnement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Tourelles {

	private IntegerProperty x = new SimpleIntegerProperty();
	private IntegerProperty y = new SimpleIntegerProperty();

	// private int x,y;
	private int portee;
	private double atqSpeed; // atq, slow
	private String nom, ID;
	protected Environnement env;
	//private int temps;// Variable pour gerer temps entre le tir des tourelles (1 unité de temps = 1
						// tour) <- variable crée dans environnement
	private static int compteur = 1;
	public int niveau;

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

	public void gestionTir() { // Methode qui gere le missile et réduit les pv du virus quand le missile le
								// touche

	}

	public Virus VirusAPorteeDeTir() {

		// System.out.println("env" + this.env);

		for (int i = 0; i < env.getViruses().size(); i++) {
			// System.out.println(env.getViruses());
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

	public ArrayList<Tourelles> TourelleAPorteeDeTir() { // Utilise pour la tourelle Pingolimbo qui boost la vitesse d'attaque des
												// tourelles dans un certain rayon
		ArrayList<Tourelles> listeTourelle = new ArrayList<Tourelles>();
		for (int i = 0; i < env.getTourelles().size(); i++) {
			// System.out.println(env.getTourelles());
			// if (env.getTourelles().get(i).estVivant()) { (Pas besoin de check ca
			// normalement
			if ((this.getY() - this.portee <= env.getTourelles().get(i).getY()
					&& env.getTourelles().get(i).getY() <= this.getY() + this.portee)
					&& (this.getX() - this.portee <= env.getTourelles().get(i).getX()
							&& env.getTourelles().get(i).getX() <= this.getX() + this.portee)) {
					listeTourelle.add(env.getTourelles().get(i));
			}
			return listeTourelle;
			// }
		}
		return null;

	}

	public ArrayList<Virus> PlusieursVirusAPorteeDeTir() {// return tout les virus a portee de tir pour les tourelles aoe
		// (hydroclaque/mousseuse
		ArrayList<Virus> virusesMultiples = new ArrayList<Virus>();
		for (int i = 0; i < env.getViruses().size(); i++) {
// System.out.println(env.getViruses());
			if (env.getViruses().get(i).estVivant()) {
				if ((this.getY() - this.portee <= env.getViruses().get(i).getY()
						&& env.getViruses().get(i).getY() <= this.getY() + this.portee)
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

		this.setAtqSpeed(this.atqSpeed * boost);

	}

	public abstract void tirer();

	public void agit() {

		if (this.env.getTemps() % this.atqSpeed == 0 && this.VirusAPorteeDeTir() != null) // tentative d'evittement du null pointer
																			// exception ( car virusaporteedetir
																			// retourne null si pas de virus
		{
			tirer();			
			 
		}

		
	}

	@Override
	public String toString() {
		return "Tourelles [x=" + x + ", y=" + y + ", portee=" + portee + ", atqSpeed=" + atqSpeed + ", nom=" + nom
				+ ", ID=" + ID + "]";
	}

	public boolean placementTourelles() {

		return false;

	}

	/**
	 * @return the niveau
	 */
	public int getNiveau() {
		return niveau;
	}

	/**
	 * @param niveau the niveau to set
	 */
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

}
