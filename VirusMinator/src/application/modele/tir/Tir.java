package application.modele.tir;

import application.modele.Environnement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Tir {
	private IntegerProperty xProperty;
	private IntegerProperty yProperty;
	private IntegerProperty baseX; //Position de la Tourelle Tirant ce Tir en X
	private IntegerProperty baseY; //Position de la Tourelle Tirant ce Tir en Y
	private String ID;
	protected Environnement env;
	private int vie, portee;
	private double vitesse;
	private static int compteur;

	public Tir(int x, int y,  Environnement env, int portee) {

		this.setPortee(portee);
		this.xProperty = new SimpleIntegerProperty(x);
		this.yProperty = new SimpleIntegerProperty(y);
		this.baseX = new SimpleIntegerProperty (x);
		this.baseY = new SimpleIntegerProperty (y);
		this.env = env;
		this.vie = 1;
		this.setVitesse(1.0);
		this.ID = "tir" + compteur;
		compteur++;
	}

	public boolean estVivant(){
		if (this.vie>0) {
			return true;
		}
		else {
			return false;
		}
	}
	public void meurt() {
		System.out.println("Methode meurt appliquée");
		this.env.getListeTirs().remove(this);
	}
	public String getId() {
		return ID;
	}

	public final int getX() {
		return xProperty.getValue();
	}

	public final IntegerProperty getXProperty() {
		return xProperty;
	}

	public final int getY() {
		return yProperty.getValue();
	}

	public final IntegerProperty getYProperty() {
		return yProperty;
	}

	public final void setX(int n) {
		xProperty.setValue(n);
	}

	public final void setY(int n) {
		yProperty.setValue(n);
	}

	public abstract void seDeplace();

	public double getVitesse() {
		return vitesse;
	}

	public void setVitesse(double vitesse) {
		this.vitesse = vitesse;
	}

	public int getBaseX() {
		return baseX.getValue();
	}

	public void setBaseX(IntegerProperty baseX) {
		this.baseX = baseX;
	}

	public int getPortee() {
		return portee;
	}

	public void setPortee(int portee) {
		this.portee = portee;
	}

	public int getBaseY() {
		return baseY.getValue();
	}

	public void setBaseY(IntegerProperty baseY) {
		this.baseY = baseY;
	}
	public String toString() {
		return ("Le tir : " + this.getId() + " à la position x = " + this.getX() 
		+ " et y = " + this.getY() + " d'une origine de base X = " + this.getBaseX() + " et baseY : " + this.baseY);
	}
}
