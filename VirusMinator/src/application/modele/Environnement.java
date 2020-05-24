package application.modele;

import java.util.List;

import application.Config;
import application.modele.tourelles.Tourelles;
import application.modele.virus.Virus;
import application.modele.virus.VirusVhealrus;
import application.modele.virus.VirusViboomrus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {
	private int width, height;
	private ObservableList<Virus> viruses;
	private ObservableList<Tourelles> tourelles;
	private ObservableList<Virus> nextViruses ;
	private String[][] terrain;

	public Environnement(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.terrain = new String[18][40];
		this.tourelles = FXCollections.observableArrayList();
		this.viruses = FXCollections.observableArrayList();
		this.nextViruses =  FXCollections.observableArrayList();
		initTerrain();
		this.nextViruses.add(new VirusVhealrus(50, 10, 0.0015, "VirusVhealrus", 0, 288));
		this.nextViruses.add(new VirusViboomrus(50, 10, 0.0035, "VirusBoomrus", 0, 288));
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public ObservableList<Virus> getViruses() {
		return nextViruses;
	}

	public ObservableList<Tourelles> getTourelles() {
		return tourelles;
	}

	public Virus getVirus(String id) {
		for (Virus v : this.viruses) {
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

	public void ajouterVirus(Virus a) {
		viruses.add(a);
	}

	public void ajouterTourelles(Tourelles a) {
		tourelles.add(a);
	}

	public boolean dansTerrain(int x, int y){
		return (0 <= x && x<this.width && 0<=y && y< this.height);
	}
	public void initTerrain() {
		List<Integer> listeMap = Config.listeMap;
		int x = 0;

		for (int i = 0; i < this.terrain.length; i++) {

			for (int j = 0; j < this.terrain[i].length; j++) {

				if (listeMap.get(x) == Config.Herbe) {
					this.terrain[i][j] = "1";

				}

				else if (listeMap.get(x) == Config.Sable) {
					this.terrain[i][j] = "1";

//				} else if (listeMap.get(x) == Config.BLOCROUGEHOPITAL) {
//					this.terrain[i][j] = "1";

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

//				else if (listeMap.get(x) == Config.BlocBlancHopital) {
//					this.terrain[i][j] = "1";
//
//				}

				else if (listeMap.get(x) == Config.SpawnMob) {
					this.terrain[i][j] = "1";

				}

//				else if (listeMap.get(x) == Config.BLOCROUGEHOPITAL) {
//					this.terrain[i][j] = "1";
//
//				}

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
