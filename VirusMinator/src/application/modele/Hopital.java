package application.modele;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Hopital {


	private DoubleProperty vieProperty = new SimpleDoubleProperty();
	
	/**
	* constructeur de la classe hopital 
	* initialise la vie de l'hopital a 100 points de vie.
	*/
	public Hopital() {
		this.setVie(100);
	}
	
	/**
	* accesseur de valeur de la property vie
	* @return la valeur de vieProperty
	*/
	public final double getVie() {
		return this.vieProperty.getValue();
	}

	/**
	* accesseur de la property vie
	* @return vieProperty
	*/
	public final DoubleProperty getVieProperty() {
		return this.vieProperty;
	}

    /**
	* modificateur de valeur de la vieProperty
	*/
	public final void setVie(double n) {
		this.vieProperty.setValue(n);

	}

}
