package application.modele.tir;

import application.modele.Environnement;
import application.modele.virus.Virus;
import javafx.beans.property.IntegerProperty;
import javafx.geometry.Point2D;

public abstract class Tir {
	private IntegerProperty xProperty;
	private IntegerProperty yProperty;
	private IntegerProperty baseX;
	private IntegerProperty baseY;
//	private int destinationX;
//	private int destinationY;
	private String ID;
	protected Environnement env;
	private int vie, portee;
	private double vitesse;
	private static int compteur;

	public Tir(IntegerProperty x, IntegerProperty y,  Environnement env, int portee/* , int destinationX,
	 int destinationY */) {
/*ajouter une vitesse au tirs peut-être ?*/
		this.setPortee(portee);
		this.xProperty = x;
		this.yProperty = y;
		this.setBaseX(x);
		this.setBaseY(y);
		this.env = env;
		this.vie = 1;
		this.setVitesse(2.0);
//		this.destinationX = destinationX;
//		this.destinationY = destinationY;
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

	public abstract void agit();

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
}
