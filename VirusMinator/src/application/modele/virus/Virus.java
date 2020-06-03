package application.modele.virus;

import java.util.Arrays;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Virus {
	private IntegerProperty xProperty = new SimpleIntegerProperty();
	private IntegerProperty yProperty = new SimpleIntegerProperty();
	private int dx, dy; // direction
	private int atq, vie;
	private double vitesse; // vitesse= vitesse de deplacement
	private String nom, ID;
	public static int compteur;
	private int tpsPerso;
	private static int tpsSuivant = 200;

	public static List<Integer> listeVirusAttente = Arrays.asList(1,1,1,2,2,2,3,2,3,3,4);/*liste des viruses a ajouter*/

	public Virus(int vie, int atq, double vitesse, String nom, int x, int y, int tpsSpawn) { /* Constructeur Virus */
		this.ID = "v" + compteur;
		this.vie = vie;
		this.atq = atq;
		this.setVitesse(vitesse);
		this.nom = nom;
		this.setX(x);
		this.setY(y);
		compteur++;
		
		this.tpsPerso = tpsSuivant+tpsSpawn;
		System.out.println("v" + compteur);
		tpsSuivant += 175;
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "Virus [xProperty=" + xProperty + ", yProperty=" + yProperty + ", dx=" + dx + ", dy=" + dy + ", atq="
				+ atq + ", vie=" + vie + ", vitesse=" + vitesse + ", nom=" + nom + ", ID=" + ID + ", tpsPerso="
				+ tpsPerso + "]";
	}

	public int getTempsSpawn() {
		return tpsPerso;
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

	}

	public final int getVie() {
		return vie;

	}

	public boolean estVivant() {
		return this.vie > 0;
	}

	/* Changer les 1, 2, et 0 en vitesse des virus */
	public void seDeplace(Virus v) {
		if (v instanceof VirusViterus) {
			if (this.getXproperty().getValue() < 520 && this.getYproperty().getValue() < 289) {
				int nposX = this.getX() +(int) (v.getVitesse());
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() >= 520 && this.getXproperty().getValue() < 808
					&& this.getYproperty().getValue() < 449) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() +((int) (v.getVitesse()));
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() >= 808 && this.getYproperty().getValue() <= 449
					&& this.getYproperty().getValue() > 288 && this.getXproperty().getValue() <= 1234) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() +((int) (-v.getVitesse()));
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() == 1235 && this.getYproperty().getValue() == 288) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			} else {
				int nposX = this.getX() +((int) (v.getVitesse()));
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			}
			if (this.getYproperty().getValue() == 288 && this.getXproperty().getValue() == 1235) {
				this.setX(1235);
				this.setY(288);

			}
			System.out.println(this.getId() + "x : " + this.getX());
			System.out.println(this.getId() + "y : " + this.getY() + "\n");
		} else if (v instanceof VirusViboomrus) {
			if (this.getXproperty().getValue() < 520 && this.getYproperty().getValue() < 289) {
				int nposX = this.getX() +((int) (v.getVitesse()));
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() >= 520 && this.getXproperty().getValue() < 808
					&& this.getYproperty().getValue() < 449) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() +((int) (v.getVitesse()));
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() >= 809 && this.getYproperty().getValue() <= 450
					&& this.getYproperty().getValue() > 288 && this.getXproperty().getValue() <= 1234) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() +((int) (-v.getVitesse()));
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() == 1235 && this.getYproperty().getValue() == 288) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			} else {
				int nposX = this.getX() +((int) (v.getVitesse()));
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			}
			if (this.getYproperty().getValue() == 288 && this.getXproperty().getValue() == 1235) {
				this.setX(1235);
				this.setY(288);

			}
			System.out.println(this.getId() + "x : " + this.getX());
			System.out.println(this.getId() + "y : " + this.getY() + "\n");
		} else {
			if (this.getXproperty().getValue() < 520 && this.getYproperty().getValue() < 289) {
				int nposX = this.getX() +((int) (v.getVitesse()));
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() >= 520 && this.getXproperty().getValue() < 838
					&& this.getYproperty().getValue() < 449) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() +((int) (v.getVitesse()));
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() >= 838 && this.getYproperty().getValue() <= 450
					&& this.getYproperty().getValue() > 288 && this.getXproperty().getValue() <= 1234) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() +((int) (-v.getVitesse()));
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() == 1235
					&& (this.getYproperty().getValue() == 288 || this.getYproperty().getValue() < 290)) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			} else {
				int nposX = this.getX() +((int) (v.getVitesse()));
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			}
			if (this.getYproperty().getValue() == 288 && this.getXproperty().getValue() >= 1235) {
				this.setX(1235);
				this.setY(288);

			}
		}
		System.out.println(this.getId() + "x : " + this.getX());
		System.out.println(this.getId() + "y : " + this.getY() + "\n");

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

	public void setVie(double newVie) {
		this.vie = (int) newVie;

	}

	/*
	 * bas, bas,div, bas, bas, bas, bas, bas, bas, bas, bas, div, div, div, div,
	 * div, div, div, div, div, vhe, vhe, vhe, vhe, vhe, vhe, vhe, vhe, vhe, vhe,
	 * vib, vib, vib, vib, vib, vib, vib, vib, vib, vib, vit, vit, vit, vit, vit,
	 * vit, vit, vit, vit, vit
	 *
	 *
	 * 
	 * liste de virus souhaitée
	 */
}