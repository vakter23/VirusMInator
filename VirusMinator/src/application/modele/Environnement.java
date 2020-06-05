package application.modele;

import java.util.List;

import application.Config;
import application.controleur.Controller;
import application.modele.tourelles.Tourelles;
import application.modele.virus.Virus;
import application.modele.virus.VirusBasirus;
import application.modele.virus.VirusDivirus;
import application.modele.virus.VirusVhealrus;
import application.modele.virus.VirusViboomrus;
import application.modele.virus.VirusViterus;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;

public class Environnement {
	private int width, height, vie;
	private ObservableList<Virus> virusesSurTerrain = FXCollections
			.observableArrayList(); /* les viruses pr�sents sur le terrain */
	private ObservableList<Tourelles> tourelles = FXCollections.observableArrayList();/*La liste des
	 tourelles sur le terrain*/
	private ObservableList<Virus> nextViruses = FXCollections.observableArrayList();/*la liste des virus � 
	ajouter dans les virus pr�sents*/
	private String[][] terrain; 
	private IntegerProperty argent = new SimpleIntegerProperty(15);

	public Environnement(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.terrain = new String[18][40];
		initTerrain();
		this.setVie(60);

	}
	public void incrementerArgent(){
		this.argent.setValue(argent.getValue()+1);
		
	}
	public IntegerProperty getArgentProperty() {
		return this.argent;
	}
	public int getArgent() {
		return this.argent.getValue();
	}
	public void enleverArgent(int somme) {
		this.argent.setValue(argent.getValue()-somme);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void initVirus() {
		this.virusesSurTerrain.clear();
		for (int i = 0; i < Virus.listeVirusAttente.size(); i++) {
			switch (Virus.listeVirusAttente.get(i)) {
			case 1:
				Virus vb = new VirusBasirus(70, 10, 2.0, "VirusBasirus", 0, 288, 200, this);
				this.nextViruses.add(vb);
				break;
			case 2:
				Virus vd = new VirusDivirus(40, 10, 2.0, "VirusDivirus", 0, 288, 200, this);
				this.nextViruses.add(vd);
				break;
			case 3:
				Virus vh = new VirusVhealrus(30, 10, 2.0, "VirusVhealrus", 0, 288, 200, this);
				this.nextViruses.add(vh);
				break;
			case 4:
				Virus vbi = new VirusViboomrus(170, 10, 1.0, "VirusViboomrus", 0, 288, 200, this);
				this.nextViruses.add(vbi);
				break;
			case 5:
				Virus vv = new VirusViterus(30, 10, 3.0, "VirusViterus", 0, 288, 200, this);
				this.nextViruses.add(vv);
				break;
			default:
				break;
			}
			System.out.println("next viruses : " + nextViruses);

			// Virus.listeVirusAttente.remove(i);
		}
	}


	public ObservableList<Virus> getViruses() {
		return virusesSurTerrain;
	}

	public ObservableList<Virus> getNextViruses() {
		return nextViruses;
	}

	public ObservableList<Tourelles> getTourelles() {
		return tourelles;
	}

	public void resetPos(Virus v) {
		v.setX(0);
		v.setY(288);
	}

	public Virus getVirus(String id) {
		for (Virus v : this.virusesSurTerrain) {
			if (v.getId().equals(id)) {
				return v;
			}
		}
		return null;
	}

	public Tourelles getTourelles(String id) {
		for (Tourelles t : this.tourelles) {
			if (t.getId().equals(id)) {
				return t;
			}
		}
		return null;
	}

	public void ajouterVirus(Virus v) {
		virusesSurTerrain.add(v);
		System.out.println(virusesSurTerrain.get(0).getNom());
	}

	public void ajouterTourelles(Tourelles a) {
		tourelles.add(a);
	}

	public boolean dansTerrain(int x, int y) {
		return (0 <= x && x < this.width && 0 <= y && y < this.height);
	}
	/**/
	public void unTour() {
		entreeVirusTerrain();
		deplacerLesViruses();
		faireAgirTourelles();
		ramasserLesMorts();
		gameOver();
	}

	private void gameOver() {
		if (this.getVie() == 0) {
			Controller.getGameLoop().stop();
			System.out.println("D.�.F.A.I.T.E");
		}
		
	}

	public void entreeVirusTerrain() {
		for (int i = 0; i < nextViruses.size(); i++) {
			if (nextViruses.get(i).getTempsSpawn() == Controller.temps) {
				this.virusesSurTerrain.add(nextViruses.get(i));
				System.out.println("Cr�ation Virus");
			}

			// Virus.listeVirusAttente.remove(i);
		}
	}

	public void deplacerLesViruses() {
		for (int i = 0; i < virusesSurTerrain.size(); i++) {
			Virus v = virusesSurTerrain.get(i);
			v.seDeplace(v);
		}
	}

	public void faireAgirTourelles() {
		for (int i = 0; i < tourelles.size(); i++) {
			Tourelles t = tourelles.get(i);
			t.agit();
		}
	}

	public void ramasserLesMorts() {
		for (int i = virusesSurTerrain.size() - 1; i >= 0; i--) {
			Virus v = virusesSurTerrain.get(i);
			if (!v.estVivant()) {
				System.out.println("mort de : " + v.getId());
				/* duplication du virus lors de la mort */
				if (v instanceof VirusDivirus) {
					Virus div1 = new VirusBasirus(40, 5, 2, "VirusBasirus", v.getX(), v.getY(), Controller.temps + 1, this);
					Virus div2 = new VirusBasirus(40, 5, 2, "VirusBasirus", v.getX(), v.getY(), Controller.temps + 200, this);
					System.out.println("Le virus : " + v.getId() + "s'est divis� en deux Virus !");
					virusesSurTerrain.add(div1);
					virusesSurTerrain.add(div2);
				}
				System.out.println(virusesSurTerrain.get(i) + "a �t� supprim�e");
				virusesSurTerrain.remove(i);
			}
		}
	}

	public int getTerrain(int valeurI) {
		for (int i = 0; i < this.terrain.length; i++) {
			for (int j = 0; j < this.terrain[i].length; j++) {
				if (this.terrain[valeurI][j] == "0") {
					return 1;
				}
			}

		}
		return 0;

	}

	public void initTerrain() {
		List<Integer> listeMap = Config.listeMap;
		int x = 0;
		/* Graph(36); */
		for (int i = 0; i < this.terrain.length; i++) {
			for (int j = 0; j < this.terrain[i].length; j++) {

				if (listeMap.get(x) == Config.Herbe) {
					this.terrain[i][j] = "1";

				}

				else if (listeMap.get(x) == Config.Sable) {
					this.terrain[i][j] = "1";

				}

				else if (listeMap.get(x) == Config.SpawnViolet) {
					this.terrain[i][j] = "1";

				}

				else if (listeMap.get(x) == Config.Vert) {
					this.terrain[i][j] = "1";

				}

				else if (listeMap.get(x) == Config.sableChemin) {
					this.terrain[i][j] = "0";

				}

				else if (listeMap.get(x) == Config.SPAWNTOURELLES) {
					this.terrain[i][j] = "1";
				}

				else if (listeMap.get(x) == Config.Hosto) {
					this.terrain[i][j] = "1";

				} else if (listeMap.get(x) == Config.RougeHospital) {
					this.terrain[i][j] = "1";

				}

				x++;
			}
		}

		for (int i = 0; i < this.terrain.length; i++) {
			for (int j = 0; j < this.terrain[i].length; j++) {

				System.out.print(this.terrain[i][j]);
				System.out.print("");

			}
			System.out.println("\t");

		}
		System.out.println("test");

	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}


}
