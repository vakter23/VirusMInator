package application.modele.tir;

import java.util.ArrayList;

import application.modele.Environnement;
import application.modele.virus.Virus;
import javafx.beans.property.IntegerProperty;

public class TirSansDegats extends Tir {
private Virus v;
	public TirSansDegats(int x, int y, Environnement env, int portee, Virus v) {
		super(x, y, env, portee);
		this.v = v;
	}


	@Override
	public void seDeplace() {

		if (v.getX() < this.getX()) {
			this.setX((int) (this.getX() - this.getVitesse()));
		} else {
			this.setX((int) (this.getX() + this.getVitesse()));
		}
		if (v.getY() < this.getY()) {
			this.setY((int) (this.getY() - this.getVitesse()));
		} else {
			this.setY((int) (this.getY() + this.getVitesse()));
		}

		if (this.getX() == v.getX() && this.getY() == v.getY()) {
			System.out.println("Ce tir meurt : " + this);
			this.meurt();
			this.appliquerEffet(v);
			System.out.println(v.getVie());

		}
	}

	private void appliquerEffet(Virus virusVise) {
		virusVise.setVitesse(getVitesse() / 2);

	}
}