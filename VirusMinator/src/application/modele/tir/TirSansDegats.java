package application.modele.tir;

import application.modele.Environnement;
import javafx.beans.property.IntegerProperty;

public class TirSansDegats extends Tir {
	
	public TirSansDegats(IntegerProperty x, IntegerProperty y,Environnement env) {
		super(x, y,env);
	}

	@Override
	public void agit() {
		
	}

	@Override
	public void seDeplace() {/*
		int vecteurX = (v.getX() - this.getX())/2;
        int vecteurY = (v.getY() - this.getY())/2;
        this.setX(this.getX()+ vecteurX);
        this.setY(this.getY()+ vecteurY);
        
	*/
		
	}
	
}
