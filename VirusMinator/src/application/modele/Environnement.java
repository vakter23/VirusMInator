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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {
	private int width, height;
	private ObservableList<Virus> virusesSurTerrain = FXCollections.observableArrayList(); /*les viruses présents sur le terrain*/
	private ObservableList<Tourelles> tourelles = FXCollections.observableArrayList();
	private ObservableList<Virus> nextViruses = FXCollections.observableArrayList();
	private String[][] terrain;

	public Environnement(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.terrain = new String[18][40];
		initTerrain();
		// this.nextViruses.add(new VirusVhealrus(50, 10, 0.0015, "VirusVhealrus", 0,
		// 288));
		// this.nextViruses.add(new VirusViboomrus(50, 10, 0.0035, "VirusBoomrus", 0,
		// 288));
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
				Virus vb = new VirusBasirus(70, 10, 2.0, "VirusBasirus", 0, 288, 200);
				this.nextViruses.add(vb);
				break;
			case 2:
				Virus vd = new VirusDivirus(40, 10, 2.0, "VirusDivirus", 0, 288, 200);
				this.nextViruses.add(vd);
				break;
			case 3:
				Virus vh = new VirusVhealrus(30, 10, 2.0, "VirusVhealrus", 0, 288, 200);
				this.nextViruses.add(vh);
				break;
			case 4:
				Virus vbi = new VirusViboomrus(170, 10, 1.0, "VirusViboomrus", 0, 288, 200);
				this.nextViruses.add(vbi);
				break;
			case 5:
				Virus vv = new VirusViterus(30, 10, 3.0, "VirusViterus", 0, 288, 200);
				this.nextViruses.add(vv);
				break;
			default:
				break;
			}

			// Virus.listeVirusAttente.remove(i);
		}
	}

//	public void initVirus(int nbVirusVague) {
//		this.viruses.clear();
//		for (int i = 0; i<Virus.listeVirusAttente.size(); i++) {
//			nextViruses.add(Virus.listeVirusAttente.get(i));
//			resetPos((nextViruses.get(i)));
//			//Virus.listeVirusAttente.remove(i);
//		}		
////		viruses.add(new VirusDivirus(70, 10, 0.025, "VirusDivirus", 0, 288));
////		viruses.add(new VirusBasirus(50, 10, 0.015, "VirusBasirus", -30, 288));
////		viruses.add(new VirusBasirus(50, 10, 0.015, "VirusBasirus", -60, 288));	
////		viruses.add(new VirusDivirus(70, 10, 0.025, "VirusDivirus", -90, 288));
//	}
	public ObservableList<Virus> getViruses() {
		return virusesSurTerrain;
	}

	public void updateSprite() {
		for (int i = 0; i < nextViruses.size(); i++) {
			switch (Virus.listeVirusAttente.get(i)) {
			case 1:
				if (nextViruses.get(i).getTempsSpawn() == Controller.temps) {
					this.virusesSurTerrain.add(nextViruses.get(i));
				}
				break;
			case 2:

				if (nextViruses.get(i).getTempsSpawn() == Controller.temps) {
					this.virusesSurTerrain.add(nextViruses.get(i));
				}
				break;
			case 3:

				if (nextViruses.get(i).getTempsSpawn() == Controller.temps) {
					this.virusesSurTerrain.add(nextViruses.get(i));
				}
				break;
			case 4:

				if (nextViruses.get(i).getTempsSpawn() == Controller.temps) {
					this.virusesSurTerrain.add(nextViruses.get(i));
				}
				break;
			case 5:
				if (nextViruses.get(i).getTempsSpawn() == Controller.temps) {
					this.virusesSurTerrain.add(nextViruses.get(i));
				}
				break;
			default:
				System.out.println("default");
				break;
			}

			// Virus.listeVirusAttente.remove(i);
		}
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

	public void unTour() {
		updateSprite();
		for (int i = 0; i < virusesSurTerrain.size(); i++) {
			Virus v = virusesSurTerrain.get(i);
			v.seDeplace(v);
		}
		for (int i = 0; i < tourelles.size(); i++) {
			Tourelles t = tourelles.get(i);
			t.agit();
		}
		for (int i = virusesSurTerrain.size() - 1; i >= 0; i--) {
			Virus v = virusesSurTerrain.get(i);
			if (!v.estVivant()) {
				System.out.println("mort de : " + v.getId());
				virusesSurTerrain.remove(i);
			}
		}
		for (int i = 0; i < nextViruses.size(); i++) {
			if (nextViruses.get(i).getTempsSpawn() == Controller.temps) {
				virusesSurTerrain.add(nextViruses.get(i));
				System.out.println("Virus : " + nextViruses.get(i).getNom() + " ajouté !");
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

}
