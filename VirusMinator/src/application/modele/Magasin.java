package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Magasin {
	private int argentDuDebut = 20;
	private IntegerProperty argent = new SimpleIntegerProperty();
	public final static int prixSavonneuse = 7;
	public final static int avastirus = 5;
	public final static int gelHydroClaque = 9;
	public final static int siliteBang = 12;
	public final static int drPingoLimbo = 12;


	public Magasin() {
		this.argent.set(argentDuDebut);
	}

	public void incrementerArgent() {
		this.argent.setValue(argent.getValue() + 1);

	}

	public IntegerProperty getArgentProperty() {
		return this.argent;
	}

	public int getArgent() {
		return this.argent.getValue();
	}

	public void enleverArgent(int somme) {
		this.argent.setValue(argent.getValue() - somme);
	}

	public void ajouterArgent(int somme) {
		this.argent.setValue(argent.getValue() + somme);
		
	}

}

