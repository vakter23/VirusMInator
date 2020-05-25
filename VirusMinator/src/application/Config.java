package application;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javafx.scene.image.ImageView;

public class Config {
	public static final int sableChemin = 2025;
	public static final int Vert = 2029;
	public static final int SPAWNTOURELLES = 2039;
	public static final int Hosto = 2023;
	public static final int RougeHospital = 2022;
	public static final int SpawnViolet = 2026;
	public static final int Sable = 2020;
	public static final int Herbe = 2024;

	public static List<Integer> listeMap = Arrays.asList(Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable,
			Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable,
			Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable,
			Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe,
			Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
			Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Hosto, Hosto, Hosto, Hosto,
			Hosto, SpawnViolet, SpawnViolet, SpawnViolet, SpawnViolet, SpawnViolet, SpawnViolet, Sable, Sable, Sable,
			Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
			Sable, Sable, Sable, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Hosto, RougeHospital, Hosto,
			RougeHospital, Hosto, Vert, SpawnViolet, Vert, Vert, SpawnViolet, SpawnViolet, Sable, Sable, Sable, Sable,
			Sable, Sable, Sable, Sable, Sable, Sable, SPAWNTOURELLES, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
			Sable, SPAWNTOURELLES, Sable, Sable, Sable, Sable, Sable, Sable, Sable, SPAWNTOURELLES, Sable, Hosto,
			RougeHospital, Hosto, RougeHospital, Hosto, SpawnViolet, SpawnViolet, SpawnViolet, SpawnViolet, Vert,
			SpawnViolet, sableChemin, sableChemin, sableChemin, sableChemin, sableChemin, sableChemin, sableChemin,
			sableChemin, sableChemin, sableChemin, sableChemin, SPAWNTOURELLES, Sable, Sable, Sable, Sable, Sable,
			Sable, SPAWNTOURELLES, sableChemin, sableChemin, sableChemin, sableChemin, sableChemin, sableChemin,
			sableChemin, sableChemin, sableChemin, sableChemin, Hosto, RougeHospital, RougeHospital, RougeHospital,
			Hosto, Vert, SpawnViolet, Vert, Vert, SpawnViolet, SpawnViolet, Sable, Sable, Sable, Sable, Sable, Sable,
			Sable, Sable, Sable, SPAWNTOURELLES, sableChemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
			sableChemin, SPAWNTOURELLES, Sable, Sable, Sable, Sable, SPAWNTOURELLES, Sable, Sable, Sable, Hosto,
			RougeHospital, Hosto, RougeHospital, Hosto, SpawnViolet, SpawnViolet, SpawnViolet, SpawnViolet, SpawnViolet,
			SpawnViolet, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, sableChemin, Sable,
			Sable, Sable, Sable, Sable, Sable, Sable, Sable, sableChemin, Sable, Sable, Sable, Sable, Sable, Sable,
			Sable, Sable, Sable, Hosto, RougeHospital, Hosto, RougeHospital, Hosto, Sable, Sable, Sable, Sable, Sable,
			Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, sableChemin, SPAWNTOURELLES,
			Sable, Sable, Sable, Sable, Sable, Sable, SPAWNTOURELLES, sableChemin, Sable, Sable, Sable, Sable, Sable,
			Sable, Sable, Sable, Sable, Hosto, Hosto, Hosto, Hosto, Hosto, Sable, Sable, Sable, Sable, Sable, Sable,
			Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, SPAWNTOURELLES, sableChemin, sableChemin,
			sableChemin, sableChemin, sableChemin, sableChemin, sableChemin, sableChemin, sableChemin, sableChemin,
			SPAWNTOURELLES, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
			Sable, SPAWNTOURELLES, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, SPAWNTOURELLES, Sable, Sable,
			Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe);

	public static String imageDe(int n) {
		if (n == Herbe)
			return "herbe";
		else if (n == Sable)
			return "sable";
		else if (n == SpawnViolet)
			return "violetEnnemi";
		else if (n == RougeHospital)
			return "rougeHopital";
		else if (n == Hosto)
			return "hitBoxHosto";
		else if (n == Vert)
			return "vertEnnemi";
		else if (n == SPAWNTOURELLES)
			return "spawnTourelles";
		else if (n == sableChemin)
			return "sableChemin";
		else
			return null;
	}

	public static ImageView getImg(String... paths) {
		return new ImageView(Paths.get(System.getProperty("user.dir"), paths).toUri().toString());
	}

}
