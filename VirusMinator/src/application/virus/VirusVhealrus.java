package application.virus;

public class VirusVhealrus extends Virus{

	public VirusVhealrus(int vie, int atq, double vitesse, String nom, int x, int y) {
		super(vie, atq, vitesse, nom, x, y);
	}
	public void agit() {
		int ax=this.getX();
		int ay= this.getY();
		this.seDeplace();
		System.out.println("M " + this.getId()+ " se deplace de " + ax + ","+ ay + "vers " + this.getX()+ ","+ this.getY());
	}

}
