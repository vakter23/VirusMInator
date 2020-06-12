import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import application.modele.Environnement;
import application.modele.tourelles.TourelleMousseuse;
import application.modele.tourelles.Tourelles;
import application.modele.virus.Virus;
import application.modele.virus.VirusBasirus;

class TourellesTest {
	private Virus v1;
	private Virus v2;
	private Virus v3;
	private Environnement env;
	private TourelleMousseuse t1;
	private TourelleMousseuse t2;
	private TourelleMousseuse t3;
	private TourelleMousseuse t4;
	
	@Before
	public void setUp() throws Exception{
		this.env = new Environnement(500, 500);
		Virus v1 = new VirusBasirus(50, 50, 0, env);
		Virus v2 = new VirusBasirus(50, 50, 0, env);
		Virus v3 = new VirusBasirus(0, 0, 0, env);
		TourelleMousseuse t1 = new TourelleMousseuse(100, 100, env);
		TourelleMousseuse t2 = new TourelleMousseuse(10, 10, env);
		TourelleMousseuse t3 = new TourelleMousseuse(40, 40, env);
		TourelleMousseuse t4 = new TourelleMousseuse(400, 400, env);
	}
//	@Test
//	public void listeDe2Tourelles(){
//		t1.TourelleAPorteeDeTir();
//		ArrayList<Tourelles> listeT= new ArrayList<Tourelles>();
//		listeT.add(t2);
//		listeT.add(t3);
//		assertArrayEquals(t1.TourelleAPorteeDeTir(), listeT);
//	}
//	@Test
//	public void listeDe2Viruses(){
//		t1.TourelleAPorteeDeTir();
//		ArrayList<Tourelles> listeT= new ArrayList<Tourelles>();
//		listeT.add(t2);
//		listeT.add(t3);
//		assertArrayEquals(t1.TourelleAPorteeDeTir(), listeT);
//	}
//	void test() {
//		fail("Not yet implemented");
//		
//	}

}
