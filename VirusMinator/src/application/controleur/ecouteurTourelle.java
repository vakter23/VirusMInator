package application.controleur;

import java.nio.file.Paths;

import application.modele.tourelles.TourelleDocteurPingoLimbo;
import application.modele.tourelles.TourelleHydroClaque;
import application.modele.tourelles.TourelleMousseuse;
import application.modele.tourelles.TourelleSavonneuse;
import application.modele.tourelles.TourelleSilliteBang;
import application.modele.tourelles.Tourelles;
import javafx.collections.ListChangeListener;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ecouteurTourelle implements ListChangeListener<Tourelles> {

	private Pane panneauEnnemi;
	public ecouteurTourelle(Pane pane) {
		super();
		this.panneauEnnemi = pane;
	}
	/**
	 * Cette méthode appelle "supprimerSpriteTourelle" pour les viruses morts et appelle
	 * "creerSpriteTourelle"
	 */
	@Override
	public void onChanged(Change<? extends Tourelles> c) {

		while (c.next()) {
			for (Tourelles nouvelle : c.getAddedSubList()) {
				creerSpriteTourelle(nouvelle);
			}
			for (Tourelles nouvelle : c.getRemoved()) {
				supprimerSpriteTourelle(nouvelle);
			}
			
		}
	}

	private void creerSpriteTourelle(Tourelles t) {

			if(t instanceof TourelleSavonneuse){
				ImageView tourelle =  getImage("/src/ressources/tourelles/gelHydro.png");
				tourelle.setId(t.getId());
				tourelle.setLayoutX(t.getX());
				tourelle.setLayoutY(t.getY());
				panneauEnnemi.getChildren().add(tourelle);
			}
			else if (t instanceof TourelleMousseuse){
				ImageView tourelle = getImage("/src/ressources/tourelles/Avast.png");
				tourelle.setId(t.getId());
				tourelle.setLayoutX(t.getX());
				tourelle.setLayoutY(t.getY());
				panneauEnnemi.getChildren().add(tourelle);
			}
			else if (t instanceof TourelleHydroClaque){
				ImageView tourelle = getImage("/src/ressources/tourelles/gel-hydoralcoolique.png");
				tourelle.setId(t.getId());
				tourelle.setLayoutX(t.getX());
				tourelle.setLayoutY(t.getY());
				panneauEnnemi.getChildren().add(tourelle);

			}
			else if (t instanceof TourelleSilliteBang){
				ImageView tourelle = getImage("/src/ressources/tourelles/javel.png");
				tourelle.setId(t.getId());
				tourelle.setLayoutX(t.getX());
				tourelle.setLayoutY(t.getY());
				panneauEnnemi.getChildren().add(tourelle);

			}
			else if (t instanceof TourelleDocteurPingoLimbo){
				ImageView tourelle = getImage("/src/ressources/tourelles/DrPingoLimbo.gif");
				tourelle.setId(t.getId());
				tourelle.setLayoutX(t.getX());
				tourelle.setLayoutY(t.getY());
				panneauEnnemi.getChildren().add(tourelle);
			}
		

	}

	private void supprimerSpriteTourelle(Tourelles t) {
		panneauEnnemi.getChildren().remove(this.panneauEnnemi.lookup("#"+t.getId()));
		if (t instanceof TourelleDocteurPingoLimbo) {
			onDeath(t);
		}
	}

	private void onDeath(Tourelles t) {
		t.boostAttaqueSpeed(0.8);
		
	}

	public int recupererX(MouseEvent e) {
		return (int) e.getSceneX();
	}

	public int recupererY(MouseEvent e) {
		return (int) e.getSceneY();
	}

	private static ImageView getImage(String... paths) {
		return new ImageView(Paths.get(System.getProperty("user.dir"), paths).toUri().toString());
	}

}
