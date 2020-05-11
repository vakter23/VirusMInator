package application.controleur;

import java.util.Arrays;
import java.util.List;

public class controleur {

	private static final int BLOCROUGEHOPITAL = 445;
	private static final int BlocSpawnMob = 477;
	private static final int BLocBasDroiteArriveMob = 400;
	private static final int BlocRougeHopital = BLOCROUGEHOPITAL;
	private static final int PlacementTourelles = 364;
	private static final int BlocBlancHopital = 535;
	private static final int Chemin = 243;
	private static final int BordTerrain = 255;
	private static final int Herbe = 170;
	private static final int Sable = 217;
	private static final int BlocVioletSpawnMobSurement = 448;
	private static final int BlocVertSpawnMob = 384;

	public static void main(String[] args) {

		List<Integer> listeMap = Arrays.asList(BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain,
				BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain,
				BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain,
				BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain,
				BordTerrain, BordTerrain, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain,
				BordTerrain, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable,
				Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Sable,
				Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
				Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BlocVertSpawnMob,
				BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
				Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable,
				Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BlocVertSpawnMob, BlocVertSpawnMob,
				BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
				Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable,
				Sable, Sable, Sable, Sable, Sable, BordTerrain, BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement,
				BlocVertSpawnMob, BlocVioletSpawnMobSurement, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
				Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable,
				Sable, Sable, Sable, Sable, BordTerrain, BlocSpawnMob, BlocVioletSpawnMobSurement,
				BlocVioletSpawnMobSurement, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin,
				Chemin, Chemin, Chemin, Chemin, Chemin, Sable, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable,
				Sable, Sable, Sable, Sable, Sable, BordTerrain, BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement,
				BlocVertSpawnMob, BlocVioletSpawnMobSurement, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
				Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
				Sable, Sable, Sable, Sable, Sable, BordTerrain, BlocVertSpawnMob, BlocVertSpawnMob,
				BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
				Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
				Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BlocVertSpawnMob, BlocVioletSpawnMobSurement,
				BlocVioletSpawnMobSurement, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
				Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
				Sable, Sable, Sable, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
				Sable, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable,
				Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BordTerrain, Sable, Sable, Sable,
				Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable,
				Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain,
				BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
				Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
				Sable, Sable, Sable, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable,
				Sable, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable,
				Sable, Sable, Sable, Sable, BlocBlancHopital, BlocBlancHopital, BlocBlancHopital, Sable, Chemin,
				BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable,
				Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BlocBlancHopital,
				BLOCROUGEHOPITAL, BlocBlancHopital, BLOCROUGEHOPITAL, BlocBlancHopital, Chemin, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable,
				Sable, Sable, Sable, Sable, Sable, Sable, BlocBlancHopital, BLOCROUGEHOPITAL, BlocBlancHopital, BLOCROUGEHOPITAL,
				BlocBlancHopital, Chemin, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin,
				Chemin, Chemin, Chemin, BlocBlancHopital, BLOCROUGEHOPITAL, BLOCROUGEHOPITAL, BLOCROUGEHOPITAL, BlocBlancHopital, BLocBasDroiteArriveMob,
				BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BlocBlancHopital,
				BLOCROUGEHOPITAL, BlocBlancHopital, BLOCROUGEHOPITAL, BlocBlancHopital, Chemin, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, BlocBlancHopital, BLOCROUGEHOPITAL, BlocBlancHopital, BLOCROUGEHOPITAL, BlocBlancHopital,
				Chemin, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				BlocBlancHopital, BlocBlancHopital, BlocBlancHopital, Herbe, Chemin, BordTerrain, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain,
				BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe,
				BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain,
				BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain,
				BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain,
				BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain,
				BordTerrain);
		String tabMap[][] = new String[32][32];

		int x = 0;

		for (int i = 0; i < tabMap.length; i++) {

			for (int j = 0; j < tabMap[i].length; j++) {

				if (listeMap.get(x) == BordTerrain) {
					tabMap[i][j] = "1";
				}

				else if (listeMap.get(x) == Herbe) {
					tabMap[i][j] = "1";

				}

				else if (listeMap.get(x) == Sable) {
					tabMap[i][j] = "1";

				}
				else if (listeMap.get(x) == BLOCROUGEHOPITAL) {
					tabMap[i][j] = "1";

				}


				else if (listeMap.get(x) == BlocVioletSpawnMobSurement) {
					tabMap[i][j] = "1";

				}

				else if (listeMap.get(x) == BlocVertSpawnMob) {
					tabMap[i][j] = "1";

				}

				else if (listeMap.get(x) == Chemin) {
					tabMap[i][j] = "0";

				}

				else if (listeMap.get(x) == BlocBlancHopital) {
					tabMap[i][j] = "1";

				}

				else if (listeMap.get(x) == PlacementTourelles) {
					tabMap[i][j] = "1";

				}

				else if (listeMap.get(x) == BlocRougeHopital) {
					tabMap[i][j] = "1";

				}

				else if (listeMap.get(x) == BLocBasDroiteArriveMob) {
					tabMap[i][j] = "1";

				}

				else if (listeMap.get(x) == BlocSpawnMob) {
					tabMap[i][j] = "1";

				}

				x++;
			}
		}

		for (int i = 0; i < tabMap.length; i++) {
			for (int j = 0; j < tabMap[i].length; j++) {

				System.out.print(tabMap[i][j]);
				System.out.print("");

			}
			System.out.println("\t");

		}
		System.out.println("test");

	}
}
