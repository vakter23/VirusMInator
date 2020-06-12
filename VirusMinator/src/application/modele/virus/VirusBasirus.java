package application.modele.virus;

import application.modele.Environnement;

public class VirusBasirus extends Virus {
	/**
	 * Le virus le plus basique, il n'a pas d'effets et ne possède pas d'une grande
	 * vie ni d'une grande vitesse. Les autres viruses sont équilibrés autour de lui
	 */
	public VirusBasirus(int x, int y, int tps, Environnement env) {
		super(60, 10, 2, "VirusBasirus", x, y, tps, env);
	}

	@Override
	protected void appliquerEffets() {

	}

}
