import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import application.modele.Environnement;
import application.modele.tourelles.TourelleDocteurPingoLimbo;
import application.modele.tourelles.TourelleMousseuse;
import application.modele.tourelles.TourelleSavonneuse;
import application.modele.virus.Virus;
import application.modele.virus.VirusBasirus;
import application.modele.virus.VirusVhealrus;

public class testTourellesViruses {
    private Virus v1;
    private Virus v2;
    private Virus v3;
    private Environnement env;
    private ArrayList<Virus> testliste = new ArrayList<Virus>();
    private TourelleMousseuse t1;
    private TourelleMousseuse t2;
    private TourelleDocteurPingoLimbo t3;
    private TourelleSavonneuse t4;
    
    @Before
    public void setUp() throws Exception{
        this.env = new Environnement(500, 500, null);
        this.v1 = new VirusBasirus(50, 50, 0, env);
        this.v2 = new VirusVhealrus(50, 50, 0, env);
        this.v3 = new VirusBasirus(0, 0, 0, env);
        this.t1 = new TourelleMousseuse(100, 100, env);
        this.t2 = new TourelleMousseuse(10, 10, env);
        this.t3 = new TourelleDocteurPingoLimbo(40, 40, env);
        this.t4 = new TourelleSavonneuse(48,48,env);
       

    }
    @Test
    public void testListeRempli(){
        this.env.ajouterVirus(v1);
        this.env.ajouterVirus(v2);
        this.env.ajouterVirus(v3);
        this.env.ajouterTourelles(t1);
        this.env.ajouterTourelles(t2);
        this.env.ajouterTourelles(t4);
        assertTrue(env.getTourelles().size()==3);
    }
    @Test
    public void testVieApresTir() {
    	this.env.ajouterVirus(v1);
        this.env.ajouterTourelles(t4);
        this.t4.tirer();
        this.env.unTourTir();
        assertEquals(35,v1.getVie());
    }
    
    @Test
    public void testAtqSpeed() {
    	this.env.ajouterTourelles(t4);
    	this.env.ajouterTourelles(t3);
    	this.t3.tirer();
    	assertEquals((Double)40.0, (Double)t4.getAtqSpeed());
    }
    @Test
    public void testMaxAtqSpeed() {
    	this.env.ajouterTourelles(t2);
    	this.env.ajouterTourelles(t3);
    	this.t3.tirer();
    	assertEquals((Double)1.0, (Double)t2.getAtqSpeed());
    }
    @Test
    public void testBonusesConsecutifs() {
    	this.env.ajouterTourelles(t4);
    	this.env.ajouterTourelles(t3);
    	this.env.ajouterVirus(v1);
    	this.t3.tirer();
    	this.t3.tirer();
    	assertEquals((Double)40.0, (Double)t4.getAtqSpeed());
    }
    @Test
    public void testNouvelleVague() {
    	this.env.nouvelleVague();
    	assertEquals(10, this.env.getNextViruses().size());
    	/*On ne teste pas le cas ou l'on recrée une vague car on utilise pas le controlleur*/
    }
    @Test
    public void testUnTir() {
    	this.env.ajouterTourelles(t3);
    	this.env.ajouterVirus(v1);
    	this.t2.tirer();
    	assertEquals(1, this.env.listeTirs.size());
    }
    @Test
    public void testPlusieursTirs() {
    	this.env.ajouterTourelles(t3);
    	this.env.ajouterVirus(v1);
    	this.t2.tirer();
    	this.t2.tirer();
    	assertEquals(2, this.env.listeTirs.size());
    }

}