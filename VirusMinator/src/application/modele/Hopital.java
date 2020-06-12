package application.modele;

import application.controleur.Controller;

import application.controleur.Controller;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Hopital {

	private DoubleProperty vieProperty = new SimpleDoubleProperty();
	public Hopital() {
		this.setVie(100);
	}
	
	/*DEPLACER DANS CONTROLLER*/
	private void gameOver() {
		if (this.getVie() == 0) {
			Controller.getGameLoop().stop();
			System.out.println("D.É.F.A.I.T.E");
		}

	}

	public final double getVie() {
		return this.vieProperty.getValue();
	}

	public final DoubleProperty getVieProperty() {
		return this.vieProperty;
	}

	public final void setVie(double n) {
		this.vieProperty.setValue(n);

	}

}
