package application.modele.virus;

import application.modele.Environnement;

public class VirusBasirus extends Virus {

	public VirusBasirus(int x, int y, int tps,Environnement env) {
		super(60, 10, 2.0, "VirusBasirus", x, y, tps, env);
	}

	@Override
	protected void appliquerEffets() {
		
	}

}
