package application.modele;

import application.controleur.Controller;

public class Hopital {

	private int vie;
	private int x, y;
	public Hopital() {
		this.x = 1088;
		this.y = 288;
		this.vie = 60;
	}
	
	/*DEPLACER DANS CONTROLLER*/
	private void gameOver() {
		if (this.getVie() == 0) {
			Controller.getGameLoop().stop();
			System.out.println("D.É.F.A.I.T.E");
		}

	}

	/**
	 * @return the vie
	 */
	public int getVie() {
		return vie;
	}
	/**
	 * @param vie the vie to set
	 */
	public void setVie(int vie) {
		this.vie = vie;
	}
}
