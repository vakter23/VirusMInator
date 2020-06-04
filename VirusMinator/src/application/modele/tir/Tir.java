package application.modele.tir;

import application.modele.Environnement;
import javafx.beans.property.IntegerProperty;

public abstract class Tir {
	private IntegerProperty xProperty;
	private IntegerProperty yProperty;
//	private int destinationX;
//	private int destinationY;
	private String ID;
	protected Environnement env;
	private static int compteur;

	public Tir(int x, int y/*, int destinationX, int destinationY*/) {
		this.xProperty.set(x);
		this.yProperty.set(y);
//		this.destinationX = destinationX;
//		this.destinationY = destinationY;
		this.ID = "tir" + compteur;
		compteur++;
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

	public abstract void agit();
}
