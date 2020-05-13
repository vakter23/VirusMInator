package application.modele;

public class Virus extends Acteurs {

	

	public Virus(int vie, double vitesse, String nom, int x, int y) {
		super(vie, vitesse, nom, x, y);
		
	}

	public void deplacement() {
		int ax=this.getX();
		int ay= this.getY();
		this.seDeplace();
	}

}
