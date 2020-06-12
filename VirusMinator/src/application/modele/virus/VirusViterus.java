package application.modele.virus;

import application.modele.Environnement;

public class VirusViterus extends Virus {
	/**
	 * Ce virus n'a pas d'effet, mais a bien moins de point de vie et va beaucoup
	 * plus vite qu'une tourelle de base
	 */
	public VirusViterus(int x, int y, int tps, Environnement env) {
		super(25, 10, 4, "VirusViterus", x, y, tps, env);
	}

	@Override
	protected void appliquerEffets() {

	}

}
