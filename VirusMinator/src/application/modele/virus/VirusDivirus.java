package application.modele.virus;

import application.controleur.Controller;
import application.modele.Environnement;

public class VirusDivirus extends Virus {

	public VirusDivirus(int x, int y, int tps,Environnement env) {
		super(60, 10, 2.0, "VirusDivirus", x, y, tps, env);
	}

	@Override
	protected void appliquerEffets() {
		if(!this.estVivant()) {
			if(this.getX() != 1104 && this.getY() != 288) {
				Virus div1 = new VirusBasirus(this.getX(), this.getY(), Controller.temps + 1, this.env);
				Virus div2 = new VirusBasirus(this.getX(), this.getY(), Controller.temps + 200, this.env);
				System.out.println("Le virus : " + this.getId() + "s'est divisé en deux Virus !");
				this.env.virusesSurTerrain.add(div1);
				this.env.virusesSurTerrain.add(div2);
			}		
	}
	}
}
