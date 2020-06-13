package application.modele.virus;

import application.modele.Environnement;
import application.modele.Graph;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Virus {
	private IntegerProperty xProperty = new SimpleIntegerProperty();
	private IntegerProperty yProperty = new SimpleIntegerProperty();
	private int dx, dy; // direction
	private int atq, vie, pvMax;
	private int vitesse; // vitesse= vitesse de deplacement
	private String nom, ID;
	private int compteur;
	private int tpsPerso;
	private static int tpsSuivant = 200;
	protected Environnement env;
	public static int compteurIdViruses = 0;

	

	/**
	 * liste des viruses a ajouter dans la liste "virusesSuivants" de la classe
	 * "Environnement"
	 */
	public Virus(int vie, int atq, int vitesse, String nom, int x, int y, int tpsSpawn,
			Environnement env) { /* Constructeur Virus */

		this.ID = "v" + compteurIdViruses;	/**
											 * L'ID des viruses est la lettre v et un nombre qui augmente à chaque virus
											 * créé
											 */
		this.vie = vie;
		this.pvMax = vie;
		this.atq = atq;
		this.setVitesse(vitesse); /**/
		this.nom = nom;
		this.setX(x);
		this.setY(y);
		compteurIdViruses++;
		this.env = env;
		this.tpsPerso = tpsSuivant + tpsSpawn;
		tpsSuivant += 400;
	}

	@Override
	public String toString() { /* La méthode toString des viruses */
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

	public final int getPvMax() {
		return this.pvMax;
	}

	/** cette méthode retourne vrai tant que le virus a plus d'un point de vie */
	public boolean estVivant() {
		return this.vie > 0;
	}

	public void agit() {
		if (compteur == 37) {
			infligerDegats(this.atq);
			this.meurt();
			this.appliquerEffets();
			/** on rappelle la méthode pour les viruses qui ont un effet à leurs morts */
		}
		if (compteur < 37) {
			try { /** Cette partie de la méthode modifie la position du virus dans le modèle */
				if (Graph.getSommetDansLordre().get(compteur + 1).getX() > Graph.getSommetDansLordre().get(compteur)
						.getX()) {
					this.dy = 1;
					this.setY((this.getY() + (int) vitesse) * dy);
					if (this.getY() == Graph.getSommetDansLordre().get(compteur + 1).getX() * 32 ||
							this.getY()+1 == Graph.getSommetDansLordre().get(compteur + 1).getX() * 32 
					/** On multiplie par la taille d'une tuile pour obtenir la vue */) {
						compteur++;
					}
				}
				if (Graph.getSommetDansLordre().get(compteur + 1).getY() > Graph.getSommetDansLordre().get(compteur)
						.getY()) {
					this.dx = 1;
					this.setX((this.getX() + (int) vitesse * dx));
					if (this.getX() == Graph.getSommetDansLordre().get(compteur + 1).getY() * 32 ||
							this.getX() +1 == Graph.getSommetDansLordre().get(compteur + 1).getY() * 32	) {
						compteur++;
					}
				}
				if (Graph.getSommetDansLordre().get(compteur + 1).getX() < Graph.getSommetDansLordre().get(compteur)
						.getX()) {
					this.dy = -1;
					this.setY((this.getY() + (int) vitesse * dy));
					if (this.getY() == Graph.getSommetDansLordre().get(compteur + 1).getX() * 32 || 
						this.getY()+1 == Graph.getSommetDansLordre().get(compteur + 1).getX() * 32) {
						compteur++;
					}
				} /**
					 * une fois que le virus déplacé, on vérifie si il a un effet à appliquer et
					 * l'applique si besoin
					 */
			} catch (Exception e) {
				/**
				 * on "attrape" le cas ou le compteur dépasse la taille maximale des sommets du
				 * BFS, et on inflige les dégats équivalents à son attaque
				 */
				if (compteur == 37) {
					this.meurt();
					infligerDegats(this.atq);
					
					this.appliquerEffets();
					/** on rappelle la méthode pour les viruses qui ont un effet à leurs morts */
				}
			}
		}

	}

	protected abstract void appliquerEffets();

	private void infligerDegats(int atq2) {
		this.env.getHopital().setVie(this.env.getHopital().getVie() - atq2);
	}


	private void meurt() {
		this.setVie(0);

	}

	/**
	 * @return retourne l'argent
	 */
	public int getVitesse() {
		return vitesse;
	}

	public void slowVirus(double slow) {

		this.setVitesse((int) (this.vitesse / slow));

	}

	/**
	 * @param Prend en paramètre un int et change la vitesse 
	 */
	public void setVitesse(int vitesse) {
		if (vitesse < 1) {
			this.vitesse = 1;
		} else {
			this.vitesse = vitesse;
		}
	}

	public void setVie(double newVie) {
		this.vie = (int) newVie;

	}

}