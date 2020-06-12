package application.modele.virus;

import java.util.Arrays;
import java.util.List;

import application.modele.Environnement;
import application.modele.Graph;
import application.modele.Hopital;
import application.modele.Sommet;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Virus {
	private IntegerProperty xProperty = new SimpleIntegerProperty();
	private IntegerProperty yProperty = new SimpleIntegerProperty();
	private int dx, dy; // direction
	private int atq, vie, pvMax;
	private double vitesse; // vitesse= vitesse de deplacement
	private String nom, ID;
	private int compteur;
	private int tpsPerso;
	private static int tpsSuivant = 200;
	protected Environnement env;
	public static int compteurDeplacement = 0;

	/*
	 * 1 = basirus 2 = divirus 3 = healrus 4 = boomirus 5 = viterus
	 */
	public static List<Integer> listeVirusAttente = Arrays.asList(1, 1,1,1,1,1,1,1,1,1);/* liste des viruses a ajouter */
	public static List<Integer> listeVirusAttente2 = Arrays.asList(2, 2, 3, 4, 5);

	public Virus(int vie, int atq, double vitesse, String nom, int x, int y, int tpsSpawn,
			Environnement env) { /* Constructeur Virus */
		this.ID = "v" + compteur;
		this.vie = vie;
		this.pvMax = vie;
		this.atq = atq;
		this.setVitesse(vitesse);
		this.nom = nom;
		this.setX(x);
		this.setY(y);
		compteurDeplacement++;
		this.env = env;
		this.tpsPerso = tpsSuivant + tpsSpawn;
		System.out.println("v" + compteurDeplacement);
		tpsSuivant += 400;
		// System.out.println(this.toString());
	}

	public Virus(int vie, int x, int y) {
		this.ID = "v" + compteurDeplacement;
		this.vie = vie;
		this.pvMax = vie;
		this.atq = 10;
		this.setVitesse(vitesse);
		this.nom = "Virus";
		this.setX(x);
		this.setY(y);
		compteurDeplacement++;
		this.env = env;
		this.tpsPerso = tpsSuivant;
		System.out.println("v" + compteurDeplacement);
		tpsSuivant += 400;
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

	public final int getPvMax() {
		return this.pvMax;
	}

	public boolean estVivant() {
		return this.vie > 0;
	}

	public void agit() {
	        if (compteur < 37) {
	            try {
	            if(Graph.getSommetDansLordre().get(compteur+1).getX() > Graph.getSommetDansLordre().get(compteur).getX()) {
	                this.dy = 1;
	                this.setY((this.getY()+ (int)vitesse)*dy);
	                if (this.getY() == Graph.getSommetDansLordre().get(compteur+1).getX()*32) {
	                    compteur++;
	                }
	            } if(Graph.getSommetDansLordre().get(compteur+1).getY() > Graph.getSommetDansLordre().get(compteur).getY()) {
	                this.dx = 1;
	                this.setX((this.getX()+ (int)vitesse*dx));
	                if (this.getX() == Graph.getSommetDansLordre().get(compteur+1).getY()*32) {
	                    compteur++;
	                }
	            }
	            if(Graph.getSommetDansLordre().get(compteur+1).getX() < Graph.getSommetDansLordre().get(compteur).getX()) {
	                this.dy = -1;
	                this.setY((this.getY()+ (int)vitesse*dy));
	                if (this.getY() == Graph.getSommetDansLordre().get(compteur+1).getX()*32) {
	                    compteur++;
	                }
	            }
	            this.appliquerEffets();
	        } catch (Exception e) {
	            if ( compteur == 37) {
	                infligerDegats(this.atq);
	                System.out.println("Le virus à infligé ses dégats ! ");
	                this.meurt();
	                this.appliquerEffets();
	            }
	        }
	        }
	        
	    }
	

	public void seDeplacer() {
		if (compteur < 37) {
			this.setY(Graph.getSommetDansLordre().get(compteur).getX() * 32);
			this.setX(Graph.getSommetDansLordre().get(compteur).getY() * 32);
			System.out.println(this.toString());
			compteur++;
		}

	}

	/* Changer les 1, 2, et 0 en vitesse des virus */
	public void agit(Virus v) {
		if (v instanceof VirusViterus) {
			if (this.getXproperty().getValue() < 520 && this.getYproperty().getValue() < 289) {
				int nposX = this.getX() + (int) (v.getVitesse());
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() >= 520 && this.getXproperty().getValue() < 808
					&& this.getYproperty().getValue() < 449) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() + ((int) (v.getVitesse()));
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() >= 809 && this.getYproperty().getValue() <= 450
					&& this.getYproperty().getValue() > 288 && this.getXproperty().getValue() <= 1234) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() + ((int) (-v.getVitesse()));
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() == 1235 && this.getYproperty().getValue() == 288) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			} else {
				int nposX = this.getX() + ((int) (v.getVitesse()));
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			}
			if (this.getYproperty().getValue() == 288 && this.getXproperty().getValue() == 1235) {
				this.setX(1235);
				this.setY(288);

			}

			if (this.getYproperty().getValue() >= 288 && this.getXproperty().getValue() >= 1104) {
				v.meurt();
				v.infligerDegats(v.getAtq());

			}
			System.out.println(this.getId() + "x : " + this.getX());
			System.out.println(this.getId() + "y : " + this.getY() + "\n");
		} else if (v instanceof VirusViboomrus) {
			if (this.getXproperty().getValue() < 520 && this.getYproperty().getValue() < 289) {
				int nposX = this.getX() + ((int) (v.getVitesse()));
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() >= 520 && this.getXproperty().getValue() < 808
					&& this.getYproperty().getValue() < 449) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() + ((int) (v.getVitesse()));
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() >= 809 && this.getYproperty().getValue() <= 450
					&& this.getYproperty().getValue() > 288 && this.getXproperty().getValue() <= 1234) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() + ((int) (-v.getVitesse()));
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() == 1235 && this.getYproperty().getValue() == 288) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			} else {
				int nposX = this.getX() + ((int) (v.getVitesse()));
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			}
			if (this.getYproperty().getValue() == 288 && this.getXproperty().getValue() == 1235) {
				this.setX(1235);
				this.setY(288);

			}

			if (this.getYproperty().getValue() >= 288 && this.getXproperty().getValue() >= 1104) {
				v.meurt();
				v.infligerDegats(v.getAtq());

			}
			System.out.println(this.getId() + "x : " + this.getX());
			System.out.println(this.getId() + "y : " + this.getY() + "\n");
		} else {
			if (this.getXproperty().getValue() < 520 && this.getYproperty().getValue() < 289) {
				int nposX = this.getX() + ((int) (v.getVitesse()));
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() >= 520 && this.getXproperty().getValue() < 838
					&& this.getYproperty().getValue() < 449) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() + ((int) (v.getVitesse()));
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() >= 838 && this.getYproperty().getValue() <= 450
					&& this.getYproperty().getValue() > 288 && this.getXproperty().getValue() <= 1234) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() + ((int) (-v.getVitesse()));
				this.setX(nposX);
				this.setY(nposY);
			} else if (this.getXproperty().getValue() == 1235
					&& (this.getYproperty().getValue() == 288 || this.getYproperty().getValue() < 290)) {
				int nposX = this.getX() + (0);
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			} else {
				int nposX = this.getX() + ((int) (v.getVitesse()));
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
			}
			if (this.getYproperty().getValue() >= 288 && this.getXproperty().getValue() >= 1104) {
				v.meurt();
				v.infligerDegats(v.getAtq());

			}
		}
		System.out.println(this.getId() + "x : " + this.getX());
		System.out.println(this.getId() + "y : " + this.getY() + "\n");
		v.appliquerEffets();
	}

	/* Changer les 1, 2, et 0 en vitesse des virus */
	/*
	 * public void agitOBS(Virus v) { /* Disparaitra quand on ajoute le BFS if (v
	 * instanceof VirusViterus) { if (this.getXproperty().getValue() < 520 &&
	 * this.getYproperty().getValue() < 289) { int nposX = this.getX() + (int)
	 * (v.getVitesse()); int nposY = this.getY() + (0); this.setX(nposX);
	 * this.setY(nposY); } else if (this.getXproperty().getValue() >= 520 &&
	 * this.getXproperty().getValue() < 808 && this.getYproperty().getValue() < 449)
	 * { int nposX = this.getX() + (0); int nposY = this.getY() + ((int)
	 * (v.getVitesse())); this.setX(nposX); this.setY(nposY); } else if
	 * (this.getXproperty().getValue() >= 809 && this.getYproperty().getValue() <=
	 * 450 && this.getYproperty().getValue() > 288 && this.getXproperty().getValue()
	 * <= 1234) { int nposX = this.getX() + (0); int nposY = this.getY() + ((int)
	 * (-v.getVitesse())); this.setX(nposX); this.setY(nposY); } else if
	 * (this.getXproperty().getValue() == 1235 && this.getYproperty().getValue() ==
	 * 288) { int nposX = this.getX() + (0); int nposY = this.getY() + (0);
	 * this.setX(nposX); this.setY(nposY); } else { int nposX = this.getX() + ((int)
	 * (v.getVitesse())); int nposY = this.getY() + (0); this.setX(nposX);
	 * this.setY(nposY); } if (this.getYproperty().getValue() == 288 &&
	 * this.getXproperty().getValue() == 1235) { this.setX(1235); this.setY(288);
	 * 
	 * }
	 * 
	 * if (this.getYproperty().getValue() >= 288 && this.getXproperty().getValue()
	 * >= 1104) { v.meurt(); v.infligerDegats(v.getAtq());
	 * 
	 * } // System.out.println(this.getId() + "x : " + this.getX()); //
	 * System.out.println(this.getId() + "y : " + this.getY() + "\n"); } else if (v
	 * instanceof VirusViboomrus) { if (this.getXproperty().getValue() < 520 &&
	 * this.getYproperty().getValue() < 289) { int nposX = this.getX() + ((int)
	 * (v.getVitesse())); int nposY = this.getY() + (0); this.setX(nposX);
	 * this.setY(nposY); } else if (this.getXproperty().getValue() >= 520 &&
	 * this.getXproperty().getValue() < 808 && this.getYproperty().getValue() < 449)
	 * { int nposX = this.getX() + (0); int nposY = this.getY() + ((int)
	 * (v.getVitesse())); this.setX(nposX); this.setY(nposY); } else if
	 * (this.getXproperty().getValue() >= 809 && this.getYproperty().getValue() <=
	 * 450 && this.getYproperty().getValue() > 288 && this.getXproperty().getValue()
	 * <= 1234) { int nposX = this.getX() + (0); int nposY = this.getY() + ((int)
	 * (-v.getVitesse())); this.setX(nposX); this.setY(nposY); } else if
	 * (this.getXproperty().getValue() == 1235 && this.getYproperty().getValue() ==
	 * 288) { int nposX = this.getX() + (0); int nposY = this.getY() + (0);
	 * this.setX(nposX); this.setY(nposY); } else { int nposX = this.getX() + ((int)
	 * (v.getVitesse())); int nposY = this.getY() + (0); this.setX(nposX);
	 * this.setY(nposY); } if (this.getYproperty().getValue() == 288 &&
	 * this.getXproperty().getValue() == 1235) { this.setX(1235); this.setY(288);
	 * 
	 * }
	 * 
	 * if (this.getYproperty().getValue() >= 288 && this.getXproperty().getValue()
	 * >= 1104) { v.meurt(); v.infligerDegats(v.getAtq());
	 * 
	 * } // System.out.println(this.getId() + "x : " + this.getX()); //
	 * System.out.println(this.getId() + "y : " + this.getY() + "\n"); } else { if
	 * (this.getXproperty().getValue() < 520 && this.getYproperty().getValue() <
	 * 289) { int nposX = this.getX() + ((int) (v.getVitesse())); int nposY =
	 * this.getY() + (0); this.setX(nposX); this.setY(nposY); } else if
	 * (this.getXproperty().getValue() >= 520 && this.getXproperty().getValue() <
	 * 838 && this.getYproperty().getValue() < 449) { int nposX = this.getX() + (0);
	 * int nposY = this.getY() + ((int) (v.getVitesse())); this.setX(nposX);
	 * this.setY(nposY); } else if (this.getXproperty().getValue() >= 838 &&
	 * this.getYproperty().getValue() <= 450 && this.getYproperty().getValue() > 288
	 * && this.getXproperty().getValue() <= 1234) { int nposX = this.getX() + (0);
	 * int nposY = this.getY() + ((int) (-v.getVitesse())); this.setX(nposX);
	 * this.setY(nposY); } else if (this.getXproperty().getValue() == 1235 &&
	 * (this.getYproperty().getValue() == 288 || this.getYproperty().getValue() <
	 * 290)) { int nposX = this.getX() + (0); int nposY = this.getY() + (0);
	 * this.setX(nposX); this.setY(nposY); } else { int nposX = this.getX() + ((int)
	 * (v.getVitesse())); int nposY = this.getY() + (0); this.setX(nposX);
	 * this.setY(nposY); } if (this.getYproperty().getValue() >= 288 &&
	 * this.getXproperty().getValue() >= 1104) {/* Infliger des dégats à l'hopital
	 */
	/*
	 * Tout ce qui est du déplacement = méthode se déplacer. Méthode agir =
	 * seDéplacer + appliquerEffets supprimer le instance of de seDéplacer et le
	 * coder dans chaque Viruses différents des autres
	 * 
	 * v.meurt(); v.infligerDegats(v.getAtq()); /* créer methode creer tir en
	 * abstraite pour factoriser le code (Public Tir creerTir(){}
	 * 
	 * 
	 * } } /* On aurait pu faire une classe effet avec des sous classes et les
	 * ajouter en tant qu'attribut
	 * 
	 * // System.out.println(this.getId() + "x : " + this.getX()); //
	 * System.out.println(this.getId() + "y : " + this.getY() + "\n");
	 * v.appliquerEffets(); }
	 */

	protected abstract void appliquerEffets();

	private void infligerDegats(int atq2) {
		this.env.getHopital().setVie(this.env.getHopital().getVie() - atq2);
	}

	private int getAtq() {
		return this.atq;
	}

	private void meurt() {
		this.vie = 0;

	}

	/**
	 * @return the vitesse
	 */
	public double getVitesse() {
		return vitesse;
	}

	public void slowVirus(double slow) {

		this.setVitesse(this.vitesse / slow);

	}

	/**
	 * @param vitesse the vitesse to set
	 */
	public void setVitesse(double vitesse) {
		if (vitesse < 1) {
			this.vitesse = 1.0;
		} else {
			this.vitesse = vitesse;
		}
	}

	public void setVie(double newVie) {
		this.vie = (int) newVie;

	}

}