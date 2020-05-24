package application;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javafx.scene.image.ImageView;

public class Config {
	public static final int sableChemin = 2025;
	public static final int Vert = 2029;
	public static final int SpawnMob = 2039;
	public static final int Hosto = 2023;
	public static final int RougeHospital = 2022;
	public static final int SpawnViolet = 2026;
	public static final int Sable = 2020;
	public static final int Herbe = 2024;
	public static final int entree = 4124;
	public static final int sortie = 2031;

	
	public static List<Integer> listeMap = Arrays.asList(Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable,
			Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable,
			Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Sable, Sable,
			Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
			Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Hosto, Hosto, Hosto, Hosto, Hosto,
			SpawnViolet, SpawnViolet, SpawnViolet, SpawnViolet, SpawnViolet, SpawnViolet, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
			Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Hosto,
			RougeHospital, Hosto, RougeHospital, Hosto, Vert, SpawnViolet, Vert, Vert, SpawnViolet, SpawnViolet, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
			Sable, Sable, SpawnMob, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, SpawnMob, Sable, Sable, Sable, Sable, Sable, Sable,
			Sable, SpawnMob, Sable, Hosto, RougeHospital, Hosto, RougeHospital, Hosto, SpawnViolet, SpawnViolet, SpawnViolet, SpawnViolet, Vert, SpawnViolet, sableChemin, sableChemin, sableChemin, sableChemin,
			sableChemin, sableChemin, sableChemin, sableChemin, sableChemin, sableChemin, sableChemin, SpawnMob, Sable, Sable, Sable, Sable, Sable, Sable, SpawnMob, sableChemin, sableChemin, sableChemin,
			sableChemin, sableChemin, sableChemin, sableChemin, sableChemin, sableChemin, sableChemin, Hosto, RougeHospital, RougeHospital, RougeHospital, Hosto, Vert, SpawnViolet, Vert, Vert, SpawnViolet, SpawnViolet,
			Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, SpawnMob, sableChemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
			Sable, sableChemin, SpawnMob, Sable, Sable, Sable, Sable, SpawnMob, Sable, Sable, Sable, Hosto, RougeHospital, Hosto, RougeHospital, Hosto, SpawnViolet, SpawnViolet,
			SpawnViolet, SpawnViolet, SpawnViolet, SpawnViolet, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, sableChemin, Sable, Sable, Sable,
			Sable, Sable, Sable, Sable, Sable, sableChemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Hosto, RougeHospital, Hosto,
			RougeHospital, Hosto, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
			sableChemin, SpawnMob, Sable, Sable, Sable, Sable, Sable, Sable, SpawnMob, sableChemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
			Sable, Hosto, Hosto, Hosto, Hosto, Hosto, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
			Sable, Sable, Sable, SpawnMob, sableChemin, sableChemin, sableChemin, sableChemin, sableChemin, sableChemin, sableChemin, sableChemin, sableChemin, sableChemin, SpawnMob, Sable, Sable, Sable,
			Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, SpawnMob, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, SpawnMob,
			Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable,
			Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
			Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe);

	public static String imageDe(int n) {
		/*
		 * if (n == 445) return "rougeHopital"; else
		 */ if (n == Herbe)
			return "herbe";
		 else if(n== Sable)
			 return "sable";
		 else if(n== SpawnViolet)
			 return "violetEnnemi";		 
		 else if(n== RougeHospital)
				 return "rougeHopital";
		else if (n == Hosto)
			 return "hitBoxHosto";
		 else if(n== Vert)
			 return "vertEnnemi";
		 else if(n==SpawnMob)
			 return "spawnTourelles";
		 else if(n==sableChemin)
			 return "sableChemin";




		/*
		 * else if (n == 305) return "hitBoxHosto"; else if (n == 269) return
		 * "spawnTourelles";/* else if (n == BlocBlancHopital) return "blancHopital";
		 */
		/*
		 * else if (n == 376) return "sableChemin"; else if (n == 388) return
		 * "BordTerrain"; else if (n == 219) return "herbe"; else if (n == 350) return
		 * "sable"; else if (n == 497) return "violetEnnemi"; else if (n == 289) return
		 * "vertEnnemi";
		 */
		else
			return null;
	}

	public static ImageView getImg(String... paths) {
		return new ImageView(Paths.get(System.getProperty("user.dir"), paths).toUri().toString());
		// ImageView(Paths.get(Paths.get(System.getProperty("user.dir"),
		// "ressources").toString(), paths).toUri().toString());
	}

}
