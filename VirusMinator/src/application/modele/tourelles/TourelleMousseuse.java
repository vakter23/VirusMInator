package application.modele.tourelles;

import java.util.ArrayList;

import application.modele.Environnement;
import application.modele.tir.Tir;
import application.modele.tir.TirSansDegats;
import application.modele.virus.Virus;
public class TourelleMousseuse extends Tourelles { // == TourelleAvastiVirus

    // cette tourelle ralentit les ennemis mais inflige peu/pas de dégâts
    
    private double slow;
    

    public TourelleMousseuse(int x, int y,Environnement env) {
        super(75, 1, "TourelleMousseuse", x, y,env);
        this.slow=2;
    }
    
    public void setSlow(double slow) {
    this.slow = slow;
    }
    

    @Override
    public void amelioration() {
    	if(this.niveau < 3) {
        this.setSlow(slow+1);
        this.setPortee(this.getPortee()+10); 
        niveau++;
    	}
    }


    @Override
    public void tirer() {

        ArrayList<Virus> listeV = PlusieursVirusAPorteeDeTir();
        for (int i = 0; i < listeV.size(); i++) {
            Tir t1 = new TirSansDegats(this.getX(), this.getY(), this.env, this.getPortee(),listeV.get(i));
            this.env.ajouterListeTirs(t1);
        }
        
//          Tourelles qui slow (Mousseuse/AvastiVirus)
        
//        double newVitesse = (VirusAPorteeDeTir().getVitesse()-this.getSlow());
//        VirusAPorteeDeTir().setVitesse(newVitesse);
        
    }

}
