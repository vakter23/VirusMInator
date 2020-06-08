package application.modele.tir;

import application.modele.Environnement;
import javafx.beans.property.IntegerProperty;

public class TirSansDegats extends Tir {
	
	public TirSansDegats(IntegerProperty x, IntegerProperty y,Environnement env) {
		super(x, y, env);
	}

	@Override
	public void agit() {
		
	}
}