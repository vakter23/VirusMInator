package application;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javafx.scene.image.ImageView;

public class Config {
	/*public static final int BLOCROUGEHOPITAL = 445;*/
	public static final int BlocSpawnMob = 526;
	public static final int BLocBasDroiteArriveMob = 305;
	public static final int PlacementTourelles = 269;
//	public static final int BlocBlancHopital = 535;
	public static final int Chemin = 376;
	public static final int BordTerrain = 388;
	public static final int Herbe = 219;
	public static final int Sable = 350;
	public static final int BlocVioletSpawnMobSurement = 497;
	public static final int BlocVertSpawnMob = 289;
	public static List<Integer> listeMap = Arrays.asList(BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BlocVertSpawnMob, BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, BordTerrain, BlocVertSpawnMob, BlocVertSpawnMob, BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, Sable, Sable, Sable, Sable, Sable, Sable, Sable, PlacementTourelles, Sable, Sable, Sable, Herbe, Herbe, Herbe, Sable, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, BordTerrain, BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, BlocVertSpawnMob, BlocVioletSpawnMobSurement, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, 526, BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Sable, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, BlocVertSpawnMob, BlocVioletSpawnMobSurement, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BlocVertSpawnMob, BlocVertSpawnMob, BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, Sable, Sable, Sable, Sable, Sable, Sable, Sable, PlacementTourelles, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BlocVertSpawnMob, BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, PlacementTourelles, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BordTerrain, Sable, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable, PlacementTourelles, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, PlacementTourelles, Sable, Sable, Sable, Sable, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, BLocBasDroiteArriveMob, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, PlacementTourelles, Herbe, Herbe, Herbe, Sable, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain);
	
	public static String imageDe(int n) {
		/*if (n == 445)
			return "rougeHopital";
		else*/ if (n == 526)
			return "spawnMob";
		else if (n == 305)
			return "hitBoxHosto";
		else if (n == 269)
			return "spawnTourelles";/*
		else if (n == BlocBlancHopital)
			return "blancHopital";*/
		else if (n == 376)
			return "sableChemin";
		else if (n == 388)
			return "BordTerrain";
		else if (n == 219)
			return "herbe";
		else if (n == 350)
			return "sable";
		else if (n == 497)
			return "violetEnnemi";
		else if (n == 289)
			return "vertEnnemi";
		else
			return null;
	}
	public static ImageView getImg(String... paths) {
		return new ImageView(Paths.get(System.getProperty("user.dir"), paths).toUri().toString());
		// ImageView(Paths.get(Paths.get(System.getProperty("user.dir"),
		// "ressources").toString(), paths).toUri().toString());
	}

}
