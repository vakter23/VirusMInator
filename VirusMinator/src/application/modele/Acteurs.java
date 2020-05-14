package application.modele;

import javafx.scene.image.ImageView;

public class Acteurs {

	private ImageView sprite;
	private int x, y;
	private int dx, dy; // direction
	private int atq, portée, vie;
	private double atqSpeed, vitesse; // vitesse= vitesse de deplacement
	private String nom, ID;

	public Acteurs(ImageView sprit, int vie, double vitesse, String nom, int x, int y) { /* Constructeur Virus */
		this.vie = vie;
		this.vitesse = vitesse;
		this.nom = nom;
		this.x = x;
		this.y = y;
		this.sprite = sprit;
	}

	public Acteurs(ImageView sprit, int atq, int portée, double atqSpeed, String nom, int x,
			int y) { /* Constructeur tourelles */

		this.atq = atq;
		this.portée = portée;
		this.atqSpeed = atqSpeed;
		this.nom = nom;
		this.x = x;
		this.y = y;

	}

	

	public String getNom() {
		return nom;
	}

	public String getId() {
		return ID;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int setX(int n) {
		return this.x = n;
	}

	public int setY(int n) {

		return this.y = n;

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