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
	private static int tpsSuivant;
	
	static public VirusBasirus bas = new VirusBasirus(100, 30, 0.0050, "bas",  0, 288, tpsSuivant);
	static public VirusDivirus div = new VirusDivirus(100, 30, 0.0050, "divirus", 0, 288, 50);
	static public VirusVhealrus vhe = new VirusVhealrus(100, 30, 0.0050, "vhealrus", 0, 288, 100);
	static public VirusViboomrus vib = new VirusViboomrus(100, 30, 0.0050, "boomrus", 0, 288, 150);
	static public VirusViterus vit = new VirusViterus(100, 30, 0.0050, "viterus", 0, 288, 200);

	public static List<Virus> listeVirusAttente = Arrays.asList(bas, bas,div, bas, bas, bas, bas, bas, bas, bas, bas, div,
			 div, div, div, div, div, div, div, div, vhe, vhe, vhe, vhe, vhe, vhe, vhe, vhe, vhe, vhe, vib, vib,
			vib, vib, vib, vib, vib, vib, vib, vib, vit, vit, vit, vit, vit, vit, vit, vit, vit, vit);

	public Virus(int vie, int atq, double vitesse, String nom, int x, int y, int tpsSpawn) { /* Constructeur Virus */
		this.ID = "v"+compteur;
		this.vie = vie;
		this.atq = atq;
		this.setVitesse(vitesse);
		this.nom = nom;
		this.setX(x);
		this.setY(y);
		compteur ++;
		this.tpsPerso += tpsSpawn;
		System.out.println("v"+compteur);
		tpsSuivant++;
		
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
			if(this.getXproperty().getValue()< 520 && this.getYproperty().getValue()<289) {
				int nposX = this.getX() + (3);
				int nposY = this.getY() + (0);
				this.setX(nposX);
				this.setY(nposY);
				}
				else if(this.getXproperty().getValue()>=520 && this.getXproperty().getValue() < 808 && this.getYproperty().getValue()<449){
					int nposX = this.getX() + (0);
					int nposY = this.getY() + (3);
					this.setX(nposX);
					this.setY(nposY);
				}
				else if (this.getXproperty().getValue() >= 808 && this.getYproperty().getValue()<=449 && this.getYproperty().getValue()>288 && this.getXproperty().getValue() <= 1234 ) {
					int nposX = this.getX() + (0);
					int nposY = this.getY() + (-3);
					this.setX(nposX);
					this.setY(nposY);
				}
				else if (this.getXproperty().getValue() == 1235 && this.getYproperty().getValue() == 288){
					int nposX = this.getX() + (0);
					int nposY = this.getY() + (0);
					this.setX(nposX);
					this.setY(nposY);
				}
				else {
					int nposX = this.getX() + (3);
					int nposY = this.getY() + (0);
					this.setX(nposX);
					this.setY(nposY);
				}
				if (this.getYproperty().getValue() == 288 && this.getXproperty().getValue() == 1235) {
					this.setX(1235);
					this.setY(288);
					
				}
				System.out.println(this.getId()+"x : " + this.getX());
				System.out.println(this.getId()+"y : " + this.getY() +"\n");
		}
		else if (v instanceof VirusViboomrus) {
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
				else if (this.getXproperty().getValue() >= 808 && this.getYproperty().getValue()<=449 && this.getYproperty().getValue()>288 && this.getXproperty().getValue() <= 1234 ) {
					int nposX = this.getX() + (0);
					int nposY = this.getY() + (-1);
					this.setX(nposX);
					this.setY(nposY);
				}
				else if (this.getXproperty().getValue() == 1235 && this.getYproperty().getValue() == 288){
					int nposX = this.getX() + (0);
					int nposY = this.getY() + (0);
					this.setX(nposX);
					this.setY(nposY);
				}
				else {
					int nposX = this.getX() + (1);
					int nposY = this.getY() + (0);
					this.setX(nposX);
					this.setY(nposY);
				}
				if (this.getYproperty().getValue() == 288 && this.getXproperty().getValue() == 1235) {
					this.setX(1235);
					this.setY(288);
					
				}
				System.out.println(this.getId()+"x : " + this.getX());
				System.out.println(this.getId()+"y : " + this.getY() +"\n");
		}
		else {
		if(this.getXproperty().getValue()< 520 && this.getYproperty().getValue()<289) {
		int nposX = this.getX() + (2);
		int nposY = this.getY() + (0);
		this.setX(nposX);
		this.setY(nposY);
		}
		else if(this.getXproperty().getValue()>=520 && this.getXproperty().getValue() < 838 && this.getYproperty().getValue()<449){
			int nposX = this.getX() + (0);
			int nposY = this.getY() + (2);
			this.setX(nposX);
			this.setY(nposY);
		}
		else if (this.getXproperty().getValue() >= 838 && this.getYproperty().getValue()<=450 && this.getYproperty().getValue()>288 && this.getXproperty().getValue() <= 1234 ) {
			int nposX = this.getX() + (0);
			int nposY = this.getY() + (-2);
			this.setX(nposX);
			this.setY(nposY);
		}
		else if (this.getXproperty().getValue() == 1235 && (this.getYproperty().getValue() == 288 || this.getYproperty().getValue() < 290)){
			int nposX = this.getX() + (0);
			int nposY = this.getY() + (0);
			this.setX(nposX);
			this.setY(nposY);
		}
		else {
			int nposX = this.getX() + (2);
			int nposY = this.getY() + (0);
			this.setX(nposX);
			this.setY(nposY);
		}
		if (this.getYproperty().getValue() == 288 && this.getXproperty().getValue() == 1235) {
			this.setX(1235);
			this.setY(288);
			
		}
		}
		System.out.println(this.getId()+"x : " + this.getX());
		System.out.println(this.getId()+"y : " + this.getY() +"\n");
		
			
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
		this.vie=(int)newVie;
		
	}
	
	public void slowVirus(double slow) {
		
		this.setVitesse(this.vitesse/slow);
		
	}
}
