package application.modele.tir;
import application.modele.Environnement;
import application.modele.virus.Virus;

public class TirSansDegats extends Tir { //Tir de la tourelle avastiVirus qui Ralentisse

private Virus v;

    public TirSansDegats(int x, int y, Environnement env, int portee, Virus v) {
        super(x, y, env, portee);
        this.v = v;
    }


    @Override
    public void seDeplace() {

        if (v.getX() < this.getX()) {
            this.setX((int) (this.getX() - this.getVitesse()));
        } else {
            this.setX((int) (this.getX() + this.getVitesse()));
        }
        if (v.getY() < this.getY()) {
            this.setY((int) (this.getY() - this.getVitesse()));
        } else {
            this.setY((int) (this.getY() + this.getVitesse()));
        }
            this.appliquerSlow(v);
            
    if (this.v.estVivant() &&( v.getX()> this.getBaseX()+this.getPortee() 
    || v.getY()>this.getBaseY()+this.getPortee())) {
        this.meurt();
        this.enleverSlow(v);
    }
    if (!this.estVivant())
        this.meurt();
    }
    private void enleverSlow(Virus virusVise) { //Quand le virus sort de la portee de la tourelleAvastivirus le virus recupere sa vitesse initiale
        virusVise.setVitesse(virusVise.getVitesse()*2);
    }
    private void appliquerSlow(Virus virusVise) {
        virusVise.setVitesse(virusVise.getVitesse()/2);

    }
}

