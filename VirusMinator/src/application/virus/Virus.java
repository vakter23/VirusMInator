package application.virus;

import java.util.Arrays;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Virus {
	private IntegerProperty xProperty = new SimpleIntegerProperty();
	private IntegerProperty yProperty = new SimpleIntegerProperty();
	private int dx, dy; // direction
	private int atq, vie; // ok le V
	private double vitesse; // vitesse= vitesse de deplacement
	private String nom, ID;

	static public VirusBasirus bas = new VirusBasirus(100, 30, 10, "bas", 200, 400);
	static public VirusDivirus div = new VirusDivirus(100, 30, 10, "divirus", 100, 200);
	static public VirusVhealrus vhe = new VirusVhealrus(100, 30, 10, "vhealrus", 500, 500);
	static public VirusViboomrus vib = new VirusViboomrus(100, 30, 10, "boomrus", 100, 100);
	static public VirusViterus vit = new VirusViterus(100, 30, 10, "viterus", 50, 500);

	public static List<Virus> listeVirusAttente = Arrays.asList(bas, bas, bas, bas, bas, bas, bas, bas, bas, bas, div,
			div, div, div, div, div, div, div, div, div, vhe, vhe, vhe, vhe, vhe, vhe, vhe, vhe, vhe, vhe, vib, vib,
			vib, vib, vib, vib, vib, vib, vib, vib, vit, vit, vit, vit, vit, vit, vit, vit, vit, vit);

	public Virus(int vie, int atq, double vitesse, String nom, int x, int y) { /* Constructeur Virus */
		this.vie = vie;
		this.atq = atq;
		this.vitesse = vitesse;
		this.nom = nom;
		this.setX(x);
		this.setY(y);

	}
	public Virus(int vie, int atq, double vitesse, String nom) { /* Constructeur Virus */

		this.vie = vie;
		this.atq = atq;
		this.vitesse = vitesse;
		this.nom = nom;
		this.setX(0);
		this.setY(352);

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
		;
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

	public boolean estVivant() {
		return this.vie > 0;
	}

	public void seDeplace() {
		double nbRandom = Math.random() * (1);
		double nbRandom2 = Math.random() * (1);
		// nbRandom=Math.round(nbRandom);

		if (this.getX() + (nbRandom) > 1024 || this.getX() + (nbRandom) < 0
				|| (this.getY() + (nbRandom2) > 1024 || (this.getY() + (nbRandom2) < 0))) {

			nbRandom = Math.random() * (1);
			nbRandom2 = Math.random() * (1);

		}

		int nposX = (int) (this.getX() + (nbRandom));
		int nposY = (int) (this.getY() + (nbRandom2));

	}

}
