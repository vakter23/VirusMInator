package application.virus;

import java.util.Arrays;
import java.util.List;

import application.modele.Environnement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.ListView;

public abstract class Virus {
	public static int compteur = 0;
	private IntegerProperty xProperty;
	private IntegerProperty yProperty;
	private int dx, dy; // direction
	private int atq, vie; // ok le V
	private double vitesse; // vitesse= vitesse de deplacement
	private String nom, ID;
	protected Environnement env;
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
		this.xProperty = new SimpleIntegerProperty(x);
		this.yProperty = new SimpleIntegerProperty(y);
		this.ID = "V" + compteur;
		compteur++;

	}

	public Virus(int vie, int atq, double vitesse, String nom) { /* Constructeur Virus */

		this.vie = vie;
		this.atq = atq;
		this.vitesse = vitesse;
		this.nom = nom;
		this.xProperty = new SimpleIntegerProperty(0);
		this.yProperty = new SimpleIntegerProperty(288);
		this.ID = "V" + compteur;
		compteur++;

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

	public final double getVitesse() {
		return this.vitesse;
	}

	public boolean estVivant() {
		return this.vie > 0;
	}

	public void seDeplace() {
		/*
		 * int posX = 0; for (int i = 0; i < listeVirusAttente.size(); i++) { if
		 * (this.getTerrain(i) == 0) { listeVirusAttente.get(i)
		 * .setX(listeVirusAttente.get(i).getX()+ 32);
		 * panneauEnnemis.getChildren().get(i).setTranslateY(panneauEnnemis.getChildren(
		 * ).get(i).getTranslateY()); } else if (1 == 1) {
		 * panneauEnnemis.getChildren().get(i).setTranslateX(panneauEnnemis.getChildren(
		 * ).get(i).getTranslateX()); panneauEnnemis.getChildren().get(i)
		 * .setTranslateY(panneauEnnemis.getChildren().get(i).getTranslateY() + 32); }
		 * posX += 32; }
		 */
		int nposX = this.getX() + (32);
		int nposY = this.getY() + (0);
		this.setX(nposX);
		this.setY(nposY);
		System.out.println(this.getX());
		System.out.println(this.getY());
	}

}
