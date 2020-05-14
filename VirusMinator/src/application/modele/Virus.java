package application.modele;

import javafx.scene.image.ImageView;

public class Virus extends Acteurs {

	

	public Virus(ImageView spr,int vie, double vitesse, String nom, int x, int y) {
		super(spr,vie, vitesse, nom, x, y);
		
	}

	public void deplacement() {
		int ax=this.getX();
		int ay= this.getY();
		this.seDeplace();
	}

}
