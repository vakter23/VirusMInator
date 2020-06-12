package application.modele.virus;

import application.modele.Environnement;

public class VirusViterus extends Virus {

	public VirusViterus(int x, int y, int tps,Environnement env) {
		super(25, 10, 4.0, "VirusViterus", x, y, tps, env);
	}

	@Override
	protected void appliquerEffets() {
		
	}

}
