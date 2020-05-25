package application.modele.virus;

import java.util.Arrays;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Virus {
	private IntegerProperty xProperty = new SimpleIntegerProperty();
	private IntegerProperty yProperty = new SimpleIntegerProperty();
	private int dx, dy; // direction
	private int atq; 
	private double vitesse, vie; // vitesse= vitesse de deplacement
	private String nom, ID;

	static public VirusBasirus bas = new VirusBasirus(100, 30, 10, "bas", 200, 400);
	static public VirusDivirus div = new VirusDivirus(100, 30, 10, "divirus", 100, 200);
	static public VirusVhealrus vhe = new VirusVhealrus(100, 30, 10, "vhealrus", 500, 500);
	static public VirusViboomrus vib = new VirusViboomrus(100, 30, 10, "boomrus", 100, 100);
	static public VirusViterus vit = new VirusViterus(100, 30, 10, "viterus", 50, 500);

	public static List<Virus> listeVirusAttente = Arrays.asList(bas, bas, bas, bas, bas, bas, bas, bas, bas, bas, div,
			div, div, div, div, div, div, div, div, div, vhe, vhe, vhe, vhe, vhe, vhe, vhe, vhe, vhe, vhe, vib, vib,
			vib, vib, vib, vib, vib, vib, vib, vib, vit, vit, vit, vit, vit, vit, vit, vit, vit, vit);

	public Virus(double vie, int atq, double vitesse, String nom, int x, int y) { /* Constructeur Virus */

		this.vie = vie;
		this.atq = atq;
		this.setVitesse(vitesse);
		this.nom = nom;
		this.setX(x);
		this.setY(y);

	}

	public String getNom() {

		return nom;

	}

	public String getId() {

		return ID;

	}

	public final int getX() {
		return this.xProperty.getValue();
	}

	public final IntegerProperty getXproperty() {
		return this.xProperty;
	}

	public final void setX(int n) {
		this.xProperty.setValue(n);
		
	}

	public final int getY() {
		return this.yProperty.getValue();
	}

	public final IntegerProperty getYproperty() {
		return this.yProperty;
	}

	public final void setY(int n) {
		this.yProperty.setValue(n);
		;
	}

	public final double  getVie() {
		return vie;

	}

	public boolean estVivant() {
		return this.vie > 0;
	}

	public void seDeplace() {
		if(this.getXproperty().getValue()< 520 && this.getYproperty().getValue()<289) {
		int nposX = this.getX() + (1);
		int nposY = this.getY() + (0);
		this.setX(nposX);
		this.setY(nposY);
		}
		else if(this.getXproperty().getValue()>=520 && this.getXproperty().getValue() < 808 && this.getYproperty().getValue()<449){
			int nposX = this.getX() + (0);
			int nposY = this.getY() + (1);
			this.setX(nposX);
			this.setY(nposY);
		}
		else if (this.getXproperty().getValue() >= 808 && this.getYproperty().getValue()<=449 && this.getYproperty().getValue()>288) {
			int nposX = this.getX() + (0);
			int nposY = this.getY() + (-1);
			this.setX(nposX);
			this.setY(nposY);
		}
		else {
			int nposX = this.getX() + (1);
			int nposY = this.getY() + (0);
			this.setX(nposX);
			this.setY(nposY);
		}
		if (this.getYproperty().getValue() == 1140 && this.getXproperty().getValue() == 280) {
			this.setX(280);
			this.setY(1140);
			
		}
		System.out.println("x : " + this.getX());
		System.out.println("y : " + this.getY());
		
			
		}
	

	/**
	 * @return the vitesse
	 */
	public double getVitesse() {
		return vitesse;
	}

	/**
	 * @param vitesse the vitesse to set
	 */
	public void setVitesse(double vitesse) {
		this.vitesse = vitesse;
	}

}
