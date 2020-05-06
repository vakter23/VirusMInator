package application.controleur;

import java.util.Arrays;
import java.util.List;

import com.sun.javafx.fxml.expression.LiteralExpression;

public class controleur {

	private static final int BlocSpawnMob = 477;
	private static final int BLocBasDroiteArriveMob = 400;
	private static final int BlocRougeHopital = 445;
	private static final int PlacementTourelles = 364;
	private static final int BlocBlancHopital = 535;
	private static final int Chemin = 243;
	private static final int BordTerrain = 255;
	private static final int Herbe = 170;
	private static final int Sable = 217;
	private static final int BlocVioletSpawnMobSurement = 448;
	private static final int BlocVertSpawnMob = 384;

	public static void main(String[] args) {

		List<Integer> listeMap  = Arrays.asList(BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BlocVertSpawnMob, BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, 206, 207, Sable, Sable, BordTerrain, BlocVertSpawnMob, BlocVertSpawnMob, BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, BlocVertSpawnMob, BlocVioletSpawnMobSurement, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BlocSpawnMob, BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Sable, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, BlocVertSpawnMob, BlocVioletSpawnMobSurement, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BlocVertSpawnMob, BlocVertSpawnMob, BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BlocVertSpawnMob, BlocVioletSpawnMobSurement, BlocVioletSpawnMobSurement, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BordTerrain, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BlocBlancHopital, BlocBlancHopital, BlocBlancHopital, Sable, Chemin, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BlocBlancHopital, 445, BlocBlancHopital, 445, BlocBlancHopital, Chemin, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Chemin, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BlocBlancHopital, 445, BlocBlancHopital, 445, BlocBlancHopital, Chemin, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, Chemin, BlocBlancHopital, 445, 445, 445, BlocBlancHopital, BLocBasDroiteArriveMob, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, Sable, BlocBlancHopital, 445, BlocBlancHopital, 445, BlocBlancHopital, Chemin, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BlocBlancHopital, 445, BlocBlancHopital, 445, BlocBlancHopital, Chemin, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BlocBlancHopital, BlocBlancHopital, BlocBlancHopital, Herbe, Chemin, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, Herbe, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain, BordTerrain);
		String tabMap[][] = new String[32][32];

		
		for (int i = 0; i <tabMap.length; i++) {
			for (int j = 0; j <tabMap[i].length; j++) {
				
			 
				
			
			
				if(listeMap.get(i)==BordTerrain) {
					tabMap[i][j]= "BordTerrain";
				}
					
				else if(listeMap.get(i)==Herbe) {
					tabMap[i][j]= "Herbe";

				}
				
				else if(listeMap.get(i)==Sable) {
					tabMap[i][j]= "Sable";

				}
				
				else if(listeMap.get(i)==BlocVioletSpawnMobSurement) {
					tabMap[i][j]= "BlocVioletSpawnMobSurement";

				}
				
				
				else if(listeMap.get(i)==BlocVertSpawnMob) {
					tabMap[i][j]= "BlocVertSpawnMob";

				}
				
				else if(listeMap.get(i)==Chemin) {
					tabMap[i][j]= "Chemin";

				}
				
				else if(listeMap.get(i)==BlocBlancHopital) {
					tabMap[i][j]= "BlocBlancHopital";

				}
				
				else if(listeMap.get(i)==PlacementTourelles) {
					tabMap[i][j]= "PlacementTourelles";

				}
				
				else if(listeMap.get(i)==BlocRougeHopital) {
					tabMap[i][j]= "BlocRougeHopital";

				}
				
				else if(listeMap.get(i)==BLocBasDroiteArriveMob) {
					tabMap[i][j]= "BLocBasDroiteArriveMob";

				}
				
				else if(listeMap.get(i)==BlocSpawnMob) {
					tabMap[i][j]= "BlocSpawnMob";

				}
				
				
			}
		}
		
		
		for (int i = 0; i < tabMap.length; i++) {
			for (int j = 0; j < 32; j++) {

			System.out.println(tabMap[i][j]);
		}
		}
		System.out.println("test");
	

	}
}
