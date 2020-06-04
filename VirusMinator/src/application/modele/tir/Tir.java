package application.modele.tir;

import application.modele.Environnement;
import javafx.beans.property.IntegerProperty;

public class Tir {
	private int atq;
	private IntegerProperty xProperty;
	private IntegerProperty yProperty;
	private int destinationX;
	private int destinationY;
	private String ID;
	private int portee;
	protected Environnement env;
	private static int compteur;
	
	//public Tir (int atq, int x, int y, int portee, int destinationX, int destinationY) {
	public Tir ( int x, int y) {

		//this.atq = atq;
		this.xProperty.set(x);
		this.yProperty.set(y);
		//this.destinationX = destinationX;
		//this.destinationY = destinationY;
		//this.portee = portee;
		this.ID = "tir"+compteur;
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

	
}
