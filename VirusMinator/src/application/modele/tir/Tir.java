package application.modele.tir;

import application.modele.Environnement;
import application.modele.virus.Virus;
import javafx.beans.property.IntegerProperty;
import javafx.geometry.Point2D;

public abstract class Tir {
	private IntegerProperty xProperty;
	private IntegerProperty yProperty;
//	private int destinationX;
//	private int destinationY;
	private String ID;
	protected Environnement env;
	private int vie;
	private static int compteur;

	public Tir(IntegerProperty x, IntegerProperty y, Environnement env/* , int destinationX, int destinationY */) {
/*ajouter une vitesse au tirs peut-être ?*/
		this.xProperty = x;
		this.yProperty = y;
		this.env = env;
		this.vie = 1;
//		this.destinationX = destinationX;
//		this.destinationY = destinationY;
		this.ID = "t" + compteur;
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
		this.vie=0;
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
}
