package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Magasin {
	private int argentDuDebut = 20;
	private IntegerProperty argent = new SimpleIntegerProperty();

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

}
