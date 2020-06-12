package application.modele.virus;

import application.modele.Environnement;

public class VirusViterus extends Virus {

	public VirusViterus(int vie, int atq, double vitesse, String nom, int x, int y, int tps,Environnement env) {
		super(45, 10, 3.0, "VirusViterus", x, y, tps, env);
	}

	@Override
	protected void appliquerEffets() {
		
		
	}

}
