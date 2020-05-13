package application.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.TilePane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import application.Config;
import application.modele.Environnement;

public class Controller implements Initializable {

	@FXML
	private TilePane map;

	@FXML
	private Button TourGBas;

	@FXML
	private Button TourDBas;

	@FXML
	private Button TourDHaut;

	@FXML
	private Button TourDMid;

	@FXML
	private Button TourGHaut;

	/*
	 * private static final int BLOCROUGEHOPITAL = 445; private static final int
	 * BlocSpawnMob = 477; private static final int BLocBasDroiteArriveMob = 400;
	 * private static final int BlocRougeHopital = BLOCROUGEHOPITAL; private static
	 * final int PlacementTourelles = 364; private static final int BlocBlancHopital
	 * = 535; private static final int Chemin = 243; private static final int
	 * BordTerrain = 255; private static final int Herbe = 170; private static final
	 * int Sable = 217; private static final int BlocVioletSpawnMobSurement = 448;
	 * private static final int BlocVertSpawnMob = 384;
	 * 
	 * 
	 * public void tableauDeInt() {
	 * 
	 * 
	 * List<Integer> listeMap = Arrays.asList(BordTerrain, BordTerrain, BordTerrain,
	 * BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain,
	 * BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain,
	 * BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain,
	 * BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain,
	 * BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain,
	 * BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Sable,
	 * Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable,
	 * Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable,
	 * Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Sable, Sable, Sable,
	 * Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Sable, Sable,
	 * Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BlocVertSpawnMob,
	 * BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, Sable, Sable, Sable,
	 * Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable,
	 * Sable, Sable, Sable, BordTerrain, BlocVertSpawnMob, BlocVertSpawnMob,
	 * BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, Sable, Sable, Sable,
	 * Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
	 * Sable, Sable, BordTerrain, BlocVioletSpawnMobSurement,
	 * BlocVioletSpawnMobSurement, BlocVertSpawnMob, BlocVioletSpawnMobSurement,
	 * Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
	 * Sable, Sable, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable,
	 * Sable, Sable, Sable, Sable, Sable, BordTerrain, BlocSpawnMob,
	 * BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, Chemin, Chemin,
	 * Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin,
	 * Chemin, Chemin, Chemin, Sable, Herbe, Herbe, Sable, Sable, Sable, Sable,
	 * Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain,
	 * BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, BlocVertSpawnMob,
	 * BlocVioletSpawnMobSurement, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
	 * Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable,
	 * Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain,
	 * BlocVertSpawnMob, BlocVertSpawnMob, BlocVioletSpawnMobSurement,
	 * BlocVioletSpawnMobSurement, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
	 * Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable,
	 * Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain,
	 * BlocVertSpawnMob, BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement,
	 * Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
	 * Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
	 * Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BordTerrain, Sable,
	 * Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
	 * Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
	 * Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BordTerrain,
	 * Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
	 * Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable,
	 * Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain,
	 * BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable,
	 * Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable,
	 * Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
	 * BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable,
	 * Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable,
	 * Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BlocBlancHopital,
	 * BlocBlancHopital, BlocBlancHopital, Sable, Chemin, BordTerrain, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
	 * Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
	 * Sable, BlocBlancHopital, BLOCROUGEHOPITAL, BlocBlancHopital,
	 * BLOCROUGEHOPITAL, BlocBlancHopital, Chemin, BordTerrain, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable,
	 * Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
	 * BlocBlancHopital, BLOCROUGEHOPITAL, BlocBlancHopital, BLOCROUGEHOPITAL,
	 * BlocBlancHopital, Chemin, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Chemin,
	 * Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin,
	 * BlocBlancHopital, BLOCROUGEHOPITAL, BLOCROUGEHOPITAL, BLOCROUGEHOPITAL,
	 * BlocBlancHopital, BLocBasDroiteArriveMob, BordTerrain, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
	 * BlocBlancHopital, BLOCROUGEHOPITAL, BlocBlancHopital, BLOCROUGEHOPITAL,
	 * BlocBlancHopital, Chemin, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * BlocBlancHopital, BLOCROUGEHOPITAL, BlocBlancHopital, BLOCROUGEHOPITAL,
	 * BlocBlancHopital, Chemin, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * BlocBlancHopital, BlocBlancHopital, BlocBlancHopital, Herbe, Chemin,
	 * BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
	 * Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, BordTerrain,
	 * BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain,
	 * BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain,
	 * BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain,
	 * BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain,
	 * BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain,
	 * BordTerrain); String tabMap[][] = new String[32][32]; Déplacé dans
	 * Config.java
	 * 
	 */

	/*
	 * 
	 * int x = 0;
	 * 
	 * for (int i = 0; i < tabMap.length; i++) {
	 * 
	 * for (int j = 0; j < tabMap[i].length; j++) {
	 * 
	 * if (listeMap.get(x) == BordTerrain) { tabMap[i][j] = "1";
	 * 
	 * 
	 * }
	 * 
	 * else if (listeMap.get(x) == Herbe) { tabMap[i][j] = "1";
	 * 
	 * }
	 * 
	 * else if (listeMap.get(x) == Sable) { tabMap[i][j] = "1";
	 * 
	 * } else if (listeMap.get(x) == BLOCROUGEHOPITAL) { tabMap[i][j] = "1";
	 * 
	 * }
	 * 
	 * 
	 * else if (listeMap.get(x) == BlocVioletSpawnMobSurement) { tabMap[i][j] = "1";
	 * 
	 * }
	 * 
	 * else if (listeMap.get(x) == BlocVertSpawnMob) { tabMap[i][j] = "1";
	 * 
	 * }
	 * 
	 * else if (listeMap.get(x) == Chemin) { tabMap[i][j] = "0";
	 * 
	 * }
	 * 
	 * else if (listeMap.get(x) == BlocBlancHopital) { tabMap[i][j] = "1";
	 * 
	 * }
	 * 
	 * else if (listeMap.get(x) == PlacementTourelles) { tabMap[i][j] = "1";
	 * 
	 * }
	 * 
	 * else if (listeMap.get(x) == BlocRougeHopital) { tabMap[i][j] = "1";
	 * 
	 * }
	 * 
	 * else if (listeMap.get(x) == BLocBasDroiteArriveMob) { tabMap[i][j] = "1";
	 * 
	 * }
	 * 
	 * else if (listeMap.get(x) == BlocSpawnMob) { tabMap[i][j] = "1";
	 * 
	 * }
	 * 
	 * x++; } }
	 * 
	 * for (int i = 0; i < tabMap.length; i++) { for (int j = 0; j <
	 * tabMap[i].length; j++) {
	 * 
	 * System.out.print(tabMap[i][j]); System.out.print("");
	 * 
	 * } System.out.println("\t");
	 * 
	 * } System.out.println("test");
	 * 
	 * }
	 * 
	 * Déplacé dans Environnement.java
	 * 
	 * 
	 * public String imageDe(int n) { if(n == 243) return "chemin.png"; else if () }
	 * Déplacé et complété dans Config.java
	 */

	public void creerTerrainVue() {
		
		ImageView herbe = getImg("/src/ressources/tiles/herbe.png");
		ImageView bordTerrain = getImg("/src/ressources/tiles/BordTerrain.png");
		
		for(int i = 0; i < Config.listeMap.size(); i++){
			Config.imageDe(Config.listeMap.get(i));
			
		}

	}

	@FXML
	void turrets(ActionEvent event) {
		/*
		 * Dans cette methode, il faudra coder l'affichage lors du clic des differentes
		 * tourelles dispo on peut aussi (peut-etre) y coder les pdv mais probablement
		 * pas optimal
		 * test zebi
		 */
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		

	}

	private static ImageView getImg(String... paths) {
		return new ImageView(Paths.get(System.getProperty("user.dir"), paths).toUri().toString());
		// ImageView(Paths.get(Paths.get(System.getProperty("user.dir"),
		// "ressources").toString(), paths).toUri().toString());
	}

}
