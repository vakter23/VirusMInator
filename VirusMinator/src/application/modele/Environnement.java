package application.modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import application.Config;
import application.controleur.Controller;
import application.modele.tir.Tir;
import application.modele.tourelles.Tourelles;
import application.modele.virus.Virus;
import application.modele.virus.VirusBasirus;
import application.modele.virus.VirusDivirus;
import application.modele.virus.VirusVhealrus;
import application.modele.virus.VirusViboomrus;
import application.modele.virus.VirusViterus;
import application.modele.Magasin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {
	private int width, height;
	public ObservableList<Virus> virusesSurTerrain = FXCollections
			.observableArrayList(); /* les viruses présents sur le terrain */
	private ObservableList<Tourelles> tourelles = FXCollections
			.observableArrayList();/*
									 * La liste des tourelles sur le terrain
									 */
	private ObservableList<Virus> virusesSuivants = FXCollections
			.observableArrayList();/*
									 * la liste des virus à ajouter dans les virus présents
									 */
	public ObservableList<Tir> listeTirs = FXCollections.observableArrayList();
	private static String[][] terrain;
	private Magasin magasin;
	private Hopital hopital;
	private static int nbVirusesVague = 10;

	public Environnement(int width, int height, Magasin magasin) {
		super();
		this.width = width;
		this.height = height;
		terrain = new String[18][40];
		initTerrain();
		this.setMagasin(magasin);
		this.hopital = new Hopital();

	}

	public void nouvelleVague() {
		/*
		 * 1 = basirus 2 = divirus 3 = healrus 4 = boomirus 5 = viterus
		 */
		ArrayList<Integer> listeVirusesAjout = new ArrayList<Integer>();
		for (int i = 0; i < nbVirusesVague; i++) {
			int virusAleatoire = (int) (Math.random() * 5 + 1);
			listeVirusesAjout.add(virusAleatoire);
		}
		initVirus(listeVirusesAjout);
		nbVirusesVague += 10;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void initVirus(ArrayList<Integer> listeVirusAttente) {
		this.virusesSurTerrain.clear();
		for (int i = 0; i < listeVirusAttente.size(); i++) {
			switch (listeVirusAttente.get(i)) {
			case 1:
				Virus vb = new VirusBasirus(0, 288, 200, this);
				this.virusesSuivants.add(vb);
				break;
			case 2:
				Virus vd = new VirusDivirus(0, 288, 200, this);
				this.virusesSuivants.add(vd);
				break;
			case 3:
				Virus vh = new VirusVhealrus(0, 288, 200, this);
				this.virusesSuivants.add(vh);
				break;
			case 4:
				Virus vbi = new VirusViboomrus(0, 288, 200, this);
				this.virusesSuivants.add(vbi);
				break;
			case 5:
				Virus vv = new VirusViterus(0, 288, 200, this);
				this.virusesSuivants.add(vv);
				break;
			default:
				break;
			}
		}
	}

	public ObservableList<Virus> getViruses() {
		return virusesSurTerrain;
	}

	public ObservableList<Virus> getNextViruses() {
		return virusesSuivants;
	}

	public ObservableList<Tourelles> getTourelles() {
		return tourelles;
	}

	public void resetPos(Virus v) { /* à détruire une fois que le BFS est la */
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

	public Tourelles getTourelle(String id) {
		for (Tourelles t : this.tourelles) {
			if (t.getId().equals(id)) {
				return t;
			}
		}
		return null;
	}

	public void ajouterVirus(Virus v) {
		virusesSurTerrain.add(v);
	}

	public void ajouterTourelles(Tourelles a) {
		tourelles.add(a);
	}

	public boolean dansTerrain(int x, int y) {
		return (0 <= x && x < this.width && 0 <= y && y < this.height);
	}

	public void unTour() {
		entreeVirusTerrain();
		deplacerLesViruses();
		faireAgirTourelles();
		ramasserLesViruses();

	}

	public void entreeVirusTerrain() {
		Iterator<Virus> it = virusesSuivants.iterator();
		while (it.hasNext()) {
			Virus v = it.next();
			if (v.getTempsSpawn() == Controller.temps) {
				this.virusesSurTerrain.add(v);
				it.remove();
			}
		}
	}

	public void deplacerLesViruses() {
		for (int i = 0; i < virusesSurTerrain.size(); i++) {
			Virus v = virusesSurTerrain.get(i);
			v.agit();
		}
	}

	public void faireAgirTourelles() {
		for (int i = 0; i < tourelles.size(); i++) {
			Tourelles t = tourelles.get(i);
			t.agit();
		}
	}

	/**
	 * @return the magasin
	 */
	public Magasin getMagasin() {
		return magasin;
	}

	/**
	 * @param magasin the magasin to set
	 */
	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	/**
	 * @return the hopital
	 */
	public Hopital getHopital() {
		return hopital;
	}

	/**
	 * @param hopital the hopital to set
	 */
	public void setHopital(Hopital hopital) {
		this.hopital = hopital;
	}

	public void ramasserLesViruses() {
		for (int i = virusesSurTerrain.size() - 1; i >= 0; i--) {
			Virus v = virusesSurTerrain.get(i);
			if (!v.estVivant()) {
				v.agit();
				virusesSurTerrain.remove(i);
			}
		}
	}

	public void unTourTir() {
		for (int i = 0; i < listeTirs.size(); i++) {
			listeTirs.get(i).seDeplace();
		}
		ramasserLesTirs();
	}

	public void ramasserLesTirs() {
		for (int i = listeTirs.size() - 1; i >= 0; i--) {
			Tir t = listeTirs.get(i);
			if (!t.estVivant()) {
				listeTirs.remove(i);
			}
		}
	}

	public void ajouterListeTirs(Tir t) {
		listeTirs.add(t);
	}

	public ObservableList<Tir> getListeTirs() {
		return listeTirs;
	}

	public void setListeTirs(ObservableList<Tir> listeTirs) {
		this.listeTirs = listeTirs;
	}

	public int getTerrain(int valeurI, int valeurJ) {
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain[i].length; j++) {
				if (terrain[valeurI][valeurJ] == "0") {
					return 1;
				}
			}

		}
		return 0;

	}

	public ObservableList<Tir> getTirs() {
		return this.listeTirs;
	}

	public Tir getTir(String id) {
		for (Tir t : this.listeTirs) {
			if (t.getId().equals(id)) {
				return t;
			}
		}
		return null;
	}

	public static int[][] getTerrainInt() {
		int[][] terrainInt = new int[18][40];
		List<Integer> listeMap = Config.listeMap;
		int x = 0;
		/* Graph(36); */
		for (int i = 0; i < terrainInt.length; i++) {

			for (int j = 0; j < terrainInt[i].length; j++) {

				if (listeMap.get(x) == Config.Herbe) {
					terrainInt[i][j] = 1;

				}

				else if (listeMap.get(x) == Config.Sable) {
					terrainInt[i][j] = 1;

				}

				else if (listeMap.get(x) == Config.SpawnViolet) {
					terrainInt[i][j] = 1;

				}

				else if (listeMap.get(x) == Config.Vert) {
					terrainInt[i][j] = 1;

				}

				else if (listeMap.get(x) == Config.sableChemin) {
					terrainInt[i][j] = 0;

				}

				else if (listeMap.get(x) == Config.SPAWNTOURELLES) {
					terrainInt[i][j] = 1;
				}

				else if (listeMap.get(x) == Config.Hosto) {
					terrainInt[i][j] = 1;

				} else if (listeMap.get(x) == Config.RougeHospital) {
					terrainInt[i][j] = 1;

				}

				x++;
			}
		}

		return terrainInt;
	}

	public void initTerrain() {
		List<Integer> listeMap = Config.listeMap;
		int x = 0;
		/* Graph(36); */
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain[i].length; j++) {

				if (listeMap.get(x) == Config.Herbe) {
					terrain[i][j] = "1";

				}

				else if (listeMap.get(x) == Config.Sable) {
					terrain[i][j] = "1";

				}

				else if (listeMap.get(x) == Config.SpawnViolet) {
					terrain[i][j] = "1";

				}

				else if (listeMap.get(x) == Config.Vert) {
					terrain[i][j] = "1";

				}

				else if (listeMap.get(x) == Config.sableChemin) {
					terrain[i][j] = "0";

				}

				else if (listeMap.get(x) == Config.SPAWNTOURELLES) {
					terrain[i][j] = "1";
				}

				else if (listeMap.get(x) == Config.Hosto) {

					terrain[i][j] = "1";

				} else if (listeMap.get(x) == Config.RougeHospital) {
					terrain[i][j] = "1";

				}

				x++;
			}
			terrain[9][35] = "0";
		}

	}

	public double getTemps() {
		return Controller.temps;
	}

	public static boolean estUnChemin(int i, int j) {
		if (terrain[i][j] == "0") {
			return true;
		}
		return false;
	}

}
