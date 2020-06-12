package application.modele.virus;

import java.util.ArrayList;

import application.modele.Environnement;

public class VirusVhealrus extends Virus {

	public VirusVhealrus(int x, int y, int tps, Environnement env) {
		super(30, 5, 2, "VirusVhealrus", x, y, tps, env);
	}

	@Override
	protected void appliquerEffets() {
		for (Virus virus : this.env.getViruses()) {
			/** On rend 5 point de vie à chaque Viruses */
			virus.setVie(virus.getVie() + 5);
			if (virus.getVie() > virus.getPvMax()) {
				virus.setVie(virus.getPvMax());

			}
		}
	}
}
