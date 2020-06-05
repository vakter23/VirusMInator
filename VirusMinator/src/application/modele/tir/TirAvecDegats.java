package application.modele.tir;

import application.modele.Environnement;
import application.modele.virus.Virus;
import javafx.beans.property.IntegerProperty;

public class TirAvecDegats extends Tir {

	private double atq;
	private Virus v;
	public TirAvecDegats(IntegerProperty x, IntegerProperty y, Virus v,Environnement env) {
		super(x, y, env);
		this.v=v;
	}

	/**
	 * @return the atq
	 */
	public double getAtq() {
		return atq;
	}
	/**
	 * @param atq the atq to set
	 */
	public void setAtq(double atq) {
		this.atq = atq;
	}
public void seDeplace() {
	int vecteurX = (v.getX() - this.getX())/2;
    int vecteurY = (v.getY() - this.getY())/2;
    this.setX(this.getX()+ vecteurX);
    this.setY(this.getY()+ vecteurY);
    if(this.getX() == v.getX() && this.getY() == v.getY()) {
    	agit();
    }
}
	@Override
	public void agit() {
		
	}

}
