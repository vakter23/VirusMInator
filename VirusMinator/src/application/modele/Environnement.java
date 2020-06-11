package application.modele;

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
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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

	public Environnement(int width, int height, Magasin magasin) {
		super();
		this.width = width;
		this.height = height;
		this.terrain = new String[18][40];
		initTerrain();
		this.setMagasin(magasin);
		this.hopital = new Hopital();
//		this.getHopital.setVie(60);

	}

	public void incrementerArgent() {
		this.argent.setValue(argent.getValue() + 1);
	}

	public IntegerProperty getArgentProperty() {
		return this.argent;
	}

	public int getArgent() {
		return this.argent.getValue();
	}

	public void enleverArgent(int somme) {
		this.argent.setValue(argent.getValue() - somme);
	}
	public void ajouterArgent(int somme){
		this.argent.setValue(argent.getValue() + somme);
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
				this.virusesSuivants.add(vb);
				break;
			case 2:
				Virus vd = new VirusDivirus(40, 10, 2.0, "VirusDivirus", 0, 288, 200, this);
				this.virusesSuivants.add(vd);
				break;
			case 3:
				Virus vh = new VirusVhealrus(30, 10, 2.0, "VirusVhealrus", 0, 288, 200, this);
				this.virusesSuivants.add(vh);
				break;
			case 4:
				Virus vbi = new VirusViboomrus(170, 10, 1.0, "VirusViboomrus", 0, 288, 200, this);
				this.virusesSuivants.add(vbi);
				break;
			case 5:
				Virus vv = new VirusViterus(70, 10, 3.0, "VirusViterus", 0, 288, 200, this);
				this.virusesSuivants.add(vv);
				break;
			default:
				break;
			}
			

			// Virus.listeVirusAttente.remove(i);
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

	public void resetPos(Virus v) { /*à détruire une fois que le BFS est la*/
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
		/*System.out.println(virusesSurTerrain.get(0).getNom());*/
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
		gameOver();

	}

	public void entreeVirusTerrain() {
		for (int i = 0; i < virusesSuivants.size(); i++) {
			if (virusesSuivants.get(i).getTempsSpawn() == Controller.temps) {
				this.virusesSurTerrain.add(virusesSuivants.get(i));
				System.out.println(" Virus ajouté : " + virusesSuivants.get(i));
				System.out.println("Création Virus");
			}

			// Virus.listeVirusAttente.remove(i);
		}
	}

	public void deplacerLesViruses() {
		for (int i = 0; i < virusesSurTerrain.size(); i++) {
			Virus v = virusesSurTerrain.get(i);
			v.agit(v);
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
				System.out.println("mort de : " + v.getId());
				v.agit(v);
				System.out.println(virusesSurTerrain.get(i) + "a été supprimée");
				virusesSurTerrain.remove(i);
			}
		}
	}

	private void gameOver() {
		if (this.getVie() == 0) {
			Controller.getGameLoop().stop();
			System.out.println("D.É.F.A.I.T.E");
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
//				System.out.println("le tir : " + t + "a atteint sa cible");
//				System.out.println(listeTirs.get(i) + " a été supprimé");
				listeTirs.remove(i);
			}
		}
	}

	public void ajouterListeTirs(Tir t) {
		listeTirs.add(t);
		// System.out.println(t);
	}

	public ObservableList<Tir> getListeTirs() {
		return listeTirs;
	}

	public void setListeTirs(ObservableList<Tir> listeTirs) {
		this.listeTirs = listeTirs;
	}

	public int getTerrain(int valeurI, int valeurJ) {
		for (int i = 0; i < this.terrain.length; i++) {
			for (int j = 0; j < this.terrain[i].length; j++) {
				if (this.terrain[valeurI][valeurJ] == "0") {
					return 1;
				}
			}

		}
		return 0;

	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
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
	public static int [][] getTerrainInt(){
        int [][] terrainInt = new int[18][40];
       List<Integer> listeMap = Config.listeMap;
       int x = 0;
       /*Graph(36);*/
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

               }
               else if (listeMap.get(x) == Config.RougeHospital) {
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

	public double getTemps() {
		return Controller.temps;
	}

	public static boolean estUnChemin(int i, int j) {
        if(terrain[i][j] == "0") {
            return true;
        }
        return false;
    }

}
