package application.virus;

public class VirusViboomrus extends Virus {

	public VirusViboomrus(int vie, int atq, double vitesse, String nom, int x, int y) {
		super(vie, atq, 0.035, nom, 0, 288);
	}
	public void agit() {
		int ax=this.getX();
		int ay= this.getY();
		this.seDeplace();
		System.out.println("M " + this.getId()+ " se deplace de " + ax + ","+ ay + "vers " + this.getX()+ ","+ this.getY());
	}

}
