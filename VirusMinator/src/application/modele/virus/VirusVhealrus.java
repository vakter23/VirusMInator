package application.modele.virus;

import java.util.ArrayList;

import application.modele.Environnement;

public class VirusVhealrus extends Virus {

	public VirusVhealrus(int x, int y, int tps,Environnement env) {
		super(30, 5, 2.0, "VirusVhealrus", x, y, tps, env);
	}

	@Override
	protected void appliquerEffets() {
		// return tout les virus a portee de tir pour les tourelles aoe
				// (hydroclaque/mousseuse
				ArrayList<Virus> virusesMultiples = new ArrayList<Virus>();
				for (int i = 0; i < env.getViruses().size(); i++) {
		// System.out.println(env.getViruses());
					if (env.getViruses().get(i).estVivant()) {
						if ((this.getY() - 320 <= env.getViruses().get(i).getY()
								&& env.getViruses().get(i).getY() <= this.getY() + 320)
								&& (this.getX() - 320 <= env.getViruses().get(i).getX()
										&& env.getViruses().get(i).getX() <= this.getX() + 320)) {
							Virus virus = env.getViruses().get(i);
							virusesMultiples.add(virus);
							
						}
					}
				}
				for (Virus virus : virusesMultiples) {
					//System.out.println("vie avant soin" + virus.getVie());
					virus.setVie(virus.getVie()+5);
					if(virus.getVie()>virus.getPvMax()) {
						virus.setVie(virus.getPvMax());
						
					}
					
					//System.out.println("vie après soin : " + virus.getVie());
				}
				//System.out.println("le Vhealrus a soigné ses alliés !");
				

			}
		
	}





