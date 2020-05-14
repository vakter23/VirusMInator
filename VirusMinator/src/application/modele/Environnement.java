package application.modele;

import java.util.List;

import application.Config;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {
	private int width, height;
	private ObservableList<Acteurs> acteurs = FXCollections.observableArrayList();
	private String[][] terrain;

	public Environnement() {
		super();
		this.width = width;
		this.height = height;
		this.terrain = new String[32][32];
		initTerrain();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public ObservableList<Acteurs> getActeurs() {
		return acteurs;
	}
	public Acteurs getActeur(String id) {
		for(Acteurs a:this.acteurs){
			if(a.getId().equals(id)){
				return a;
			}
		}
		return null;
	}
	public void ajouter(Acteurs a){
		acteurs.add(a);
	}
	public boolean dansTerrain(int x, int y){
		return (0 <= x && x<this.width && 0<=y && y< this.height);
	}
	public void initTerrain() {
		List<Integer> listeMap = Config.listeMap;
		int x = 0;

		for (int i = 0; i < this.terrain.length; i++) {

			for (int j = 0; j < this.terrain[i].length; j++) {

				if (listeMap.get(x) == Config.BordTerrain) {
					this.terrain[i][j] = "1";

				}

				else if (listeMap.get(x) == Config.Herbe) {
					this.terrain[i][j] = "1";

				}

				else if (listeMap.get(x) == Config.Sable) {
					this.terrain[i][j] = "1";

				} else if (listeMap.get(x) == Config.BLOCROUGEHOPITAL) {
					this.terrain[i][j] = "1";

				}

				else if (listeMap.get(x) == Config.BlocVioletSpawnMobSurement) {
					this.terrain[i][j] = "1";

				}

				else if (listeMap.get(x) == Config.BlocVertSpawnMob) {
					this.terrain[i][j] = "1";

				}

				else if (listeMap.get(x) == Config.Chemin) {
					this.terrain[i][j] = "0";

				}

				else if (listeMap.get(x) == Config.BlocBlancHopital) {
					this.terrain[i][j] = "1";

				}

				else if (listeMap.get(x) == Config.PlacementTourelles) {
					this.terrain[i][j] = "1";

				}

				else if (listeMap.get(x) == Config.BLOCROUGEHOPITAL) {
					this.terrain[i][j] = "1";

				}

				else if (listeMap.get(x) == Config.BLocBasDroiteArriveMob) {
					this.terrain[i][j] = "1";

				}

				else if (listeMap.get(x) == Config.BlocSpawnMob) {
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
